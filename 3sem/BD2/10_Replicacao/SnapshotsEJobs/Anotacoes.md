# Snapshots (hoje Materialized Views)

Snapshot é o nome antigo (Oracle 8/9/10) do que hoje se chama materialized view — uma "tabela" cujo conteúdo é o resultado de uma query, mas que, diferente de uma view normal, armazena os dados fisicamente. É a peça central de replicação assíncrona: a filial mantém uma cópia local dos dados da matriz, sem precisar consultar o servidor remoto toda vez.

As views não ocupam espaço (só guarda a definição da query), snapshot ocupa espaço porque guarda os dados em si, fisicamente, no schema local.

## Exercicio

### Setup

```sql
conn filial1/filial1
create database link BancoMatriz connect to matriz identified by matriz using 'XE';
```

- o snapshot depende de um dblink pra saber de onde puxar os dados remotos.

### Primeira Tentativa (erro)

```sql
create snapshot pedido
refresh fast
as select * from pedido@bancomatriz where filial = 1;
```

Isso dá ORA-23413 de propósito — é um erro didático. O motivo: refresh fast exige que exista um log de alterações (snapshot log) na tabela de origem. Sem esse log, o Oracle não tem como saber o que mudou desde a última atualização — e por isso recusa criar um snapshot que promete atualização incremental sem ter a infraestrutura pra isso.

- `refresh complete` — a cada atualização, descarta todo o conteúdo do snapshot e reconsulta a tabela de origem inteira. Simples, mas caro se a tabela de origem for grande.
- `refresh fast` — atualiza só as linhas que mudaram desde a última sincronização, usando o snapshot log como referência. Mais eficiente, mas exige essa estrutura adicional na origem.

### Criando o snapshot log para resolver o erro

```sql
conn matriz/matriz
create snapshot log on pedido;
```

Isso cria, na origem (matriz), uma tabela auxiliar chamada MLOG$_PEDIDO (o $ é convenção do Oracle pra tabelas internas de suporte). A partir daí, todo INSERT/UPDATE/DELETE feito em PEDIDO na matriz passa a gerar uma entrada nesse log — é o que possibilita propagar só as mudanças (e não a tabela inteira) pra qualquer réplica que existir, em qualquer banco remoto.

```sql
conn filial1/filial1
create snapshot pedido refresh fast as select * from pedido@bancomatriz where filial = 1;
select * from pedido;
```

Agora a criação funciona — e o select * from pedido aqui já é direto na cópia local na filial, sem precisar do dblink, porque os dados já foram materializados.

### Observando o log de alteracoes

```sql
conn matriz/matriz
select * from mlog$_pedido;          -- vazio (ou já com algo, dependendo de quando o snapshot foi criado)

insert into pedido values (200850, 155, 4044, 10, sysdate, 1);
commit;

select * from mlog$_pedido;          -- agora tem uma entrada registrando essa mudança
```

### Forçando a atualização manual do snapshot

```sql
conn filial1/filial1
exec dbms_snapshot.refresh('PEDIDO','F');
select * from pedido order by codped;
```

- `dbms_snapshot.refresh(nome, tipo)` — procedure do pacote DBMS_SNAPSHOT que dispara a atualização sob demanda.
- O segundo parâmetro 'F' força um refresh fast (incremental), mesmo que o tipo padrão configurado fosse outro. Outras opções seriam 'C' (complete) ou '?' (deixa o Oracle escolher automaticamente o melhor método).

Depois disso, o pedido inserido na matriz aparece replicado na tabela local pedido da filial.

```sql
conn matriz/matriz
select * from mlog$_pedido;
```

E o log, depois do refresh consumir as mudanças pendentes, normalmente fica vazio novamente (as entradas já consumidas são purgadas) — confirmando que o ciclo "mudança → log → refresh → réplica atualizada → log limpo" se completou.

# Jobs de Replicacao

Até aqui, tudo foi manual (exec dbms_snapshot.refresh(...) digitado por nos). Jobs servem pra automatizar exatamente isso — e qualquer outra rotina agendada do banco, não só snapshots (procedures programadas, rotinas de manutenção, etc., como o roteiro principal já mencionou na introdução).

```sql
conn filial1/filial1
var x number;
begin
  dbms_job.submit(:x,
    'dbms_snapshot.refresh(''PEDIDO'',''F'');',
    SYSDATE + 1/1440,
    'SYSDATE + 3/1440');
end;
/
```

- `:x` — variável bind de saída: o Oracle devolve aqui o número identificador do job criado (você usa esse número depois pra consultar/remover o job).
- `'dbms_snapshot.refresh(''PEDIDO'',''F'');'` — a instrução PL/SQL que será executada a cada disparo do job. Note as aspas simples duplicadas (''PEDIDO'') — é a forma de "escapar" aspas simples dentro de uma string PL/SQL que já está entre aspas simples.
- `SYSDATE + 1/1440` — quando o job vai rodar pela primeira vez. 1440 é o número de minutos em um dia (24×60), então 1/1440 = 1 minuto a partir de agora.
- `'SYSDATE + 3/1440'` — o intervalo entre execuções subsequentes: aqui, a cada 3 minutos. Esse último parâmetro é passado como string porque o Oracle reavalia essa expressão a cada execução (não é um valor fixo calculado uma vez).

Resultado: o snapshot PEDIDO na filial vai se atualizar sozinho, a cada 3 minutos

## Consultas de gerenciamento de jobs

```sql
select job, what, interval, next_date, next_sec, last_date, last_sec, failures
from user_jobs
order by what;
```

Mostra todos os jobs do usuário atual: o que executam (what), com que frequência (interval), quando rodam de novo (next_date/next_sec), quando rodaram da última vez, e quantas vezes falharam.

```sql
exec dbms_job.remove(21); -- remove job especifico
```

```sql
select * from dba_jobs_running; -- mostra jobs executando agora, no nível de todo o banco (não só do seu usuário) 
```


