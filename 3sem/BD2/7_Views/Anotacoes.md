# Visões (Views)

Uma view (visão) é uma tabela virtual.

Ela se comporta como uma tabela quando fazemos consultas, mas seus dados não ficam armazenados nela. O que a view armazena é apenas uma consulta SQL.

Imagine:

```sql
SELECT nome, salario
FROM funcionario;
```

Se transformarmos isso em uma view:

```sql
CREATE VIEW vfuncionario AS
SELECT nome, salario
FROM funcionario;
```
Agora podemos consultar:

```sql
SELECT * FROM vfuncionario;
```

## Exemplo

```sql
create or replace view VCLI as
select
    cli.cod_cliente CODCLI,
    cli.razao_social RS,
    cli.data_cadastro DTCAD,
    cid.descricao CIDADE,
    cid.uf UF
from cliente cli, cidade cid
where cli.cod_cidade = cid.cod_cidade
order by cli.razao_social;
```

Junta CLINETE + CIDADE em uma unica tabela virtual

Podemos escrever

```
SELECT * FROM VCLI;
```

## Exemplo 2:

User EOR precisa acessar POS.TCLIENTES, mas nao pode ver tudo. O diretor que liberar apenas Codigo e Razao social

Entao, o user POS cria:

```sql
CREATE VIEW VCLIRS AS
SELECT cod_cli,
       descricao
FROM tclientes;
```

Para dar acesso a essa view para EOR, o POS precisa executar:

```sql
GRANT SELECT ON vclirs TO eor;
```

Agora, EOR pode fazer:

```sql
SELECT * FROM pos.vclirs;
```

#### Sinonimos

```sql
CREATE SYNONYM vclirs
FOR pos.vclirs;
```

agora, podemos fazer:

```sql
SELECT * FROM vclirs;
```


## Vantagens das views:

1. Abstracao: esconder consultas complexas.
2. Seguranca: mostrar apenas colunas permitidas
3. Reutilizacao

## A view ocupa espaco?

R: Os dados não. Apenas a definição SQL
