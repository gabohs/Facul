# Transações

-  Temos como objetivo aqui demonstrar de forma prática ao aluno o funcionamento das transações em banco de dados. Abordaremos questões como transações
simples, confirmação de transações (commit), não-confirmação de transações (rollback), lock em nível de tabelas, lock em nível de registros e deadlocks.
Uma transação pode ser entendida como o conjunto de todas as partes necessárias dentro de uma unidade lógica de trabalho, nem mais nem menos. Os dados
dentro de uma ou mais tabelas referenciadas na transação devem estar consistentes antes do início da transação e após o seu final. Uma transferência de fundos
entre duas contas correntes deve incluir o débito em uma das contas (uma sentença SQL) e o crédito em outra (outra sentença SQL). Ambas as ações devem terminar com sucesso ou com falha juntas, como sendo uma unidade de trabalho. O crédito não pode se concretizar sem que o débito também ocorra e vice-
versa.

- Uma transação é finalizada quando ocorrer sua confirmação (commit) ou sua não-confirmação (rollback). Um comando commit aplica as alterações e/ou
inserções e/ou exclusões pendentes ao banco de dados e estas passam a ser “vistas” por outros usuários em outras sessões. 

- Um comando rollback reverte as alterações e/ou inserções e/ou exclusões pendentes, voltando ao início da transação. Pode-se reverter parcialmente uma transação através do uso dos savepoints.

- Nos exercícios que faremos mais adiante poderemos verificar e entender de forma mais clara como funciona. Quanto aos privilégios, qualquer usuário pode
executar commits, rollbacks e savepoints em suas próprias sessões sem a necessidade de concessão de privilégios adicionais.

- Se esta for a primeira conexão que estamos fazendo com o banco de dados, cabem algumas observações importantes. O aplicativo que usaremos sempre será o
SqlPlus. Trata-se de uma interface por linha de comando amplamente usada por administradores de banco de dados, analistas de sistemas e desenvolvedores. O
que muda um pouco é que alguns a utilizam em ambientes UNIX, outros em LINUX e outros em WINDOWS.

Se você abrir o Terminal agora, cairá no Shell do Linux (Bash) mas intencionalmente o PATH (caminho) do usuário oracle não foi configurado para ser
carregado junto com a abertura da sessão do Terminal. Então, se você digitar agora sqlplus verá que o Terminal/Bash não encontra o aplicativo.
Vamos executar os comandos abaixo para entendermos melhor:

```sh
sqlplus
which sqlplus
echo $PATH
```

Depois, vamos iniciar uma sessão na mesma janela do Terminal porém carregando as variáveis de ambiente do usuário oracle, com

```sh
su – oracle
echo $PATH
which sqlplus
```

Veja que agora o caminho do executável do sqlplus (`/usr/lib/oracle/xe/app/oracle/product/10.2.0/server/bin`) encontra-se no PATH do usuário oracle, porque
as chamadas variáveis de ambiente foram carregadas. Assim, ao digitarmos sqlplus o Linux passa a saber onde o aplicativo está.

Vamos exemplificar o uso dos comandos commit, rollback e savepoint através de alguns exemplos. Executar os comandos abaixo sobre as tabelas de nosso
esquema EOR. EOR foi um usuário/esquema do BD criado originalmente para demonstrar as características de Objeto-Relacional do BD, então um usuário para
Esquema Objeto-Relacional. Acabamos por usar este esquema para esta bateria de exercícios sobre transações.

## Commit

```sh
sqlplus eor/eor
```

```sql
insert into cidade values ( 9001, 'RS', 'ERECHIM');

insert into cliente values ( 4001,
                             'CAIXA ECONOMICA FEDERAL',
                             SYSDATE,
                             'S',
                             9001,
                             'AV. TIRADENTES, 45',
                             '54 2106 3000');

commit;
```

Neste ponto, após o commit, a nova cidade e o novo cliente estão efetivamente cadastrados e “visíveis” às outras sessões do banco de dados. Vamos verificar
através das consultas:

```sql
select * from cidade where cod_cidade = 9001;
select * from cliente where cod_cliente = 4001;
```

## Rollback

Agora, veremos que o rollback desfaz as operações realizadas, que neste caso são inserções.

```sql
insert into cidade values ( 9002, 'RS', 'PORTO ALEGRE');
insert into cliente values (4002,
                            'PREFEITURA MUNICIPAL DE PORTO ALEGRE',
                            SYSDATE,
                            'S',
                            9002,
                            'PRACA MONTEVIDEO, 10',
                            '51 3289 3600');

rollback;

```


Neste ponto, após o rollback, nem o cliente nem a cidade foram cadastrados. Vamos verificar através das consultas:

```sql
select * from cidade where cod_cidade = 9002;
select * from cliente where cod_cliente = 4002;
```

## Savepoints

Agora, veremos a utilizade dos savepoints (pontos de salvamento).

```sql
insert into cidade values (9003, 'RS', 'CANOAS');

savepoint ponto1;

insert into cliente values (4003,
                            'PREFEITURA MUNICIPAL DE CANOAS',
                            SYSDATE,
                            'S',
                            9003,
                            'RUA QUINZE DE JANEIRO, 11',
                            '0800 510 1234');

rollback to ponto1;
```

Neste ponto, após o rollback, somente a cidade de CANOAS deve estar cadastrada. Vamos verificar através das consultas:

```sql
select * from cidade where cod_cidade = 9003;
select * from cliente where cod_cliente = 4003;
```

Se executarmos um rollback novamente, a transação é revertida totalmente. Executar:

```sql
rollback;

select * from cidade where cod_cidade = 9003;
select * from cliente where cod_cliente = 4003;
```

## Sessões diferentes

Agora, nos exemplos abaixo, veremos como se comportam os dados com relação a sessões diferentes.
Abrir uma sessão no SQLPlus, que chamaremos de sessão 1.

```sh
sqlplus eor/eor
```

Abrir outra sessão no SQLPlus em outra tela do Terminal (botão direito sobre o Terminal / New Terminal) , com o mesmo usuário, que chamaremos de sessão
2.

```sh
sqlplus eor/eor
```

Na **sessão 1** executar:

```sql
insert into cidade values (9003, 'RS', 'CANOAS');
insert into cliente values (4003,
                            'PREFEITURA MUNICIPAL DE CANOAS',
                            SYSDATE,
                            'S',
                            9003,
                            'RUA QUINZE DE JANEIRO, 11',
                            '0800 510 1234');
```

Na **sessão 2** executar:

```sql
select * from cidade where cod_cidade = 9003;
select * from cliente where cod_cliente = 4003;
```


<details>
<summary>Quantos registros cada uma das consultas trouxe ? Por quê?</summary>
<strong>Resposta:</strong> Nenhum, porque a transação ainda não tinha sido confirmada na sessão 1.
</details>
<br>

Na sessão 1 executar um `commit;`

Executar novamente as consultas anteriores. 

<details>
<summary>Quantos registros cada uma das consultas trouxe ? Por quê?</summary>
<strong>Resposta:</strong> Cada uma das consultas trouxe um registro porque o commit foi executado na sessão 1.
</details>
<br>


## Locks

O servidor de banco de dados deve realizar locks para garantir a integridade e consistência dos dados. 

Não é necessário que o programador de uma aplicação
tenha que se preocupar com este tipo de coisa, já que trata-se de um princípio fundamental de qualquer banco de dados. Porém, é possível que o programador
controle explicitamente os bloqueios (locks) de dentro de sua aplicação ou script.

Para entendermos melhor o funcionamento dos locks no Oracle, resolveremos
os exercícios a seguir. Inicialmente, veremos os locks implícitos gerenciados pelo próprio banco de dados e, a seguir, faremos exercícios controlando os locks
explicitamente.

Verificar antes, na sessão 1, qual a quantidade em estoque do produto 100.

```sql
select cod_produto, qtde from estoque where cod_produto=100;
```

Na sessão 1, atualizar o estoque do produto 100 dando entrada de mais 10 unidades:

```sql
update estoque set qtde=qtde+10 where cod_produto = 100;
```

Na sessão 2, atualizar o estoque do produto 100 dando entrada de mais 5 unidades:

```sql
update estoque set qtde=qtde+5 where cod_produto = 100;
```

<details>
<summary>Qual a quantidade que deve constar no estoque ao final das duas transações?</summary>
<strong>Resposta:</strong> 15
</details>
<br>

<details>
<summary>O que aconteceu com a sessão 2 após a execução do comando SQL?</summary>
<strong>Resposta:</strong> Ficou bloqueada.
</details>
<br>



Executar, na sessão 1 um `commit;` 

e verificar se a sessão 2 continua “trancada”, aguardando a liberação do lock. Consultar novamente o estoque do produto 100 **nas duas sessões**. 

<details>
<summary>Quais quantidades aparecem para cada uma das sessões ?</summary>
<strong>Resposta:</strong> 10 na sessão 1 e 15 na sessão 2.

</details>
<br>

Executar na sessão 2 um commit e consultar novamente a quantidade em estoque do produto 100.

<details>
<summary>Quais quantidades aparecem para cada uma das sessões?</summary>

<strong>Resposta:</strong> 15 nas duas sessões.
</details>
<br>

---

Para o próximo exercício, verificar antes, na sessão 1, os dados do cliente com razao_social ATAFONA S/A.

```sql
select * from cliente where razao_social='ATAFONA S/A';
```

Na sessão 1, executar:

```sql
update cliente set razao_social='ATA FONA S/A'
where razao_social='ATAFONA S/A';
``` 

Na sessão 2, executar:

```sql
update cliente set data_cadastro='10-JUN-04'
where razao_social='ATAFONA S/A';
```

Estamos agora atualizando campos diferentes do mesmo registro do banco de dados. 

<details>
<summary>A sessão 2 ficou “trancada” ? Por quê ?</summary>

<strong>Resposta: </strong> Ficou trancada porque, apesar de serem campos diferentes, correspondem ao mesmo registro e o BD faz o bloqueio da linha inteira.
</details>
<br>

Executar, na sessão 1, um `commit`. Verificar se a sessão 2 continua “trancada”. 

<details>
<summary>Quantas linhas foram atualizadas na sessão 2? Por quê ?</summary>

<strong>Resposta: </strong> a sessão 2 foi liberada do lock mas não atualizou nenhuma linha porque a razão social usada como filtro mudou após o update da sessão 1.
</details>
<br>

---

Para o próximo exercício, verificar antes, na sessão 1, os dados do cliente com 
razao_social CODAJAS E CIA LTDA.
```sql
select * from cliente
where razao_social='CODAJAS E CIA LTDA';
```

Na sessão 1, executar:
```sql
update cliente set razao_social='CODAJAS S/A'
where razao_social='CODAJAS E CIA LTDA';
```

Na sessão 2, executar:
```sql
update cliente set data_cadastro='10-JUN-04'
where cod_cliente=4000;
```

Estamos agora atualizando campos diferentes do mesmo registro do banco de dados, usando na cláusula where, como filtro, um campo que não esta sendo
atualizado, como foi feito anteriormente.


<details>
<summary>A sessão 2 ficou “trancada” ? Por quê ?</summary>

<strong>Resposta: </strong> novamente, e independente do campo usado no update e no where, o bloqueio é feito pela linha inteira e tratava-se da mesma linha $\rarr$ cliente 4000.
</details>
<br>

Executar, na sessão 1, um `commit;`. Verificar se a sessão 2 continua “trancada”. 

<details>
<summary>Quantas linhas foram atualizadas na sessão 2? Por quê ?</summary>

<strong>Resposta: </strong> Foi atualizada uma linha porque nessa vez a sessão 1 não alterou aquilo que estava sendo usado como filtro na sessão 2.
</details>
<br>

## Comando for update

As sentenças que finalizam com o comando for update são usadas quando um usuário deseja modificar um ou mais campos de uma ou mais linhas de uma
tabela. 

Uma vez que as linhas foram retornadas por um `select ... for update` , elas ficam bloqueadas e diponíveis para que a sessão execute operações de
exclusão e atualização sobre os campos das tabelas, e só serão liberadas e visíveis com a nova posição ao final da transação, ou seja, após um commit ou um
rollback. 

Para casos em que se deseja atualizar um número relativamente grande de registros dentro de uma tabela, talvez seja mais prudente bloquear a tabela
inteira de forma exclusiva, o que veremos mais adiante. 

Também pode-se usar a opção `nowait` ao final do comando for update, fazendo com que se tenha retorno
imediatamente sobre a possibilidade ou não de obter o lock sobre a(s) linha(s).

---

Verificar, antes, os dados de produtos cuja descrição inicia com 'BOTAO COMANDO'.

Na sessão 1, executar:
```sql
select * from produto
where descricao like 'BOTAO COMANDO%';
select cod_produto, descricao
from produto
where descricao like 'BOTAO COMANDO%'
for update;
```

Na sessão 2, executar:

```sql
update produto set ativo=0
where descricao like 'BOTAO COMANDO COGUMELO%';
```

<details>
<summary>A sessão 2 ficou “trancada” ? Por quê ?</summary>

<strong>Resposta: </strong> Porque a sessão 1, apesar de não ter executado um update, selecionou as linhas com “for update”, demonstrando intenção de realizar atualizações em todas aquelas linhas.
</details>
<br>

Executar, na sessão 1, uma atualização na descrição daqueles produtos.

```sql
update produto set descricao = descricao || ' SUPER'
where descricao like 'BOTAO COMANDO%' ;
select cod_produto, descricao
from produto
where descricao like 'BOTAO COMANDO%' ;
```

<details>
<summary>A sessão 2 continua “trancada”. Por quê?</summary>

<strong>Resposta: </strong> Porque a sessão 1 ainda não finalizou a transação (commit ou rollback).

</details>
<br>

Executar na sessão 1 um `commit`. Verificar se a sessão 2 continua “trancada”. Se não, executar lá um `commit` também.

Vejamos agora que a aplicação que está se conectando no banco de dados através de uma sessão, se o desenvolvedor assim desejou, pode controlar se quer ficar
aguardando ou não a liberação de um recurso. 

Verificar antes, na sessão 1, os dados de produtos cuja descrição inicia com 'BUCHA'.
```sql
select * from produto
where descricao like 'BUCHA%';
```

Na sessão 1, executar:
```sql
select cod_produto, descricao
from produto
where descricao like 'BUCHA%'
for update;
```

Na sessão 2, executar:
```sql
select cod_produto, descricao
from produto
where descricao like 'BUCHA PLASTICA%'
for update NOWAIT;
```

<details>
<summary>Qual a mensagem que o servidor de banco de dados retornou? Por quê?</summary>

<strong>Resposta: </strong> ORA-00054 resource busy and acquire with NOWAIT specified. Retornou erro porque a sessão 1 bloqueava os registros filtrados e NOWAIT foi  especificado, então liberou SEM ESPERA.

</details>
<br>

Executar na sessão 2 a mesma sentença, omitindo agora a cláusula `NOWAIT`.
```sql
select cod_produto, descricao
from produto
where descricao like 'BUCHA PLASTICA%'
for update;
```

Executar, na sessão 1, uma atualização na descrição daqueles produtos.
```sql
update produto set descricao = descricao || ' PLUS'
where descricao like 'BUCHA%' ;
select cod_produto, descricao
from produto
where descricao like 'BUCHA%' ;
```

<details>
<summary>A sessão 2 continua “trancada”. Por quê ? </summary>

<strong>Resposta: </strong> Sim, porque ainda não foi finalizada a transação na sessão 1 com commit ou rollback.

</details>
<br>

Executar na sessão 1 um `commit`. Verificar se a sessão 2 continua “trancada”. Se não, executar lá uma atualização inativando as buchas plásticas e confirmando
as alterações.
```sql
update produto set ativo=0
where descricao like 'BUCHA PLASTICA%';
commit;
```

---

No exercício seguinte veremos que quando se trata de registros distintos não há bloqueio por não haver concorrência de recurso. Verificar antes, na sessão 1, os
dados de produtos cuja descrição inicia com 'CONECTOR'.
```sql
select * from produto
where descricao like 'CONECTOR%';
```

Na sessão 1, executar:

```sql
select cod_produto, descricao
from produto
where descricao like 'CONECTOR%'
for update;
```

Na sessão 2, executar:

```sql
select cod_produto, ativo,descricao
from produto
where cod_produto = 1
for update;
```

<details>
<summary>A sessão 2 ficou “trancada” ? Por quê ?</summary>

<strong>Resposta: </strong> Não, porque o registro bloqueado pela sessão 2 não tinha sido bloqueado pela sessão 1. Veja para isso os códigos de produto que a sessão 1 bloqueou.

</details>
<br>

Executar, na sessão 1, uma atualização na descrição daqueles produtos.
```sql
update produto set descricao = descricao || ' PLUS'
where descricao like 'CONECTOR%' ;
commit;
```

Inativar o produto 1 na sessão 2.

```sql
update produto set ativo=0
where cod_produto=1;
commit;
```

## Deadlocks

Imagine que uma sessão 1 esteja bloqueando um recurso A , outra sessão 2 esteja bloqueando outro recurso B e uma outra sessão 3 esteja bloqueando um
recurso C. 

Agora, a sessão 1 precisa atualizar o recurso bloqueado pela sessão 2, a sessão 2 precisa atualizar o recurso bloqueado pela sessão 3 e a sessão 3
precisa atualizar o recurso bloqueado pela sessão 1. 

Como uma sessão ficaria eternamente esperando a outra, caracteriza-se como um deadlock. O Oracle
identifica a ocorrência de deadlocks e retorna uma mensagem de erro para a sessão que “iniciou o ciclo” que resultaria em um dead-lock. 

-  Vamos abrir 3 sessões
distintas via SQLPlus no esquema eor/eor e simular a ocorrência de um deadlock.


Na sessão 1 executar:

```sql
update cliente
set data_cadastro = sysdate
where razao_social = 'XINGU S/A';
```

Na sessão 2 executar:

```sql
update cliente
set data_cadastro = sysdate
where razao_social = 'VERA CRUZ S/A';
```

Na sessão 3 executar:

```sql
update cliente
set data_cadastro = sysdate
where razao_social = 'UBAUNA S/A';
```

Na sessão 1 executar:
```sql
update cliente
set data_cadastro = sysdate
where razao_social = 'VERA CRUZ S/A';
```

Na sessão 2 executar:
```sql
update cliente
set data_cadastro = sysdate
where razao_social = 'UBAUNA S/A';
```

Na sessão 3 executar:
```sql
update cliente
set data_cadastro = sysdate
where razao_social = 'XINGU S/A';
```

<details>
<summary>Qual a mensagem de erro ocorrida?</summary>

<strong>Resposta: </strong> ORA-00060: deadlock detected while waiting for resource

</details>
<br>