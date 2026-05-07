# Exercício sobre a linguagem PL-SQL

- [Blocos PL-SQL](#blocos-pl-sql)
  - [Declarando variáveis em PL-SQL](#declarando-variáveis-em-pl-sql)
  - [Tipos de dados básicos](#tipos-de-dados-básicos)
  - [O atributo %TYPE](#o-atributo-type)
  - [Variáveis do tipo LOB](#variáveis-do-tipo-lob-large-objects)
  - [Instruções SELECT em PL-SQL](#instruções-select-em-pl-sql)

- [Exercícios Iniciais](#exercícios-iniciais)
  - [Exercício 1](#exercício-1)
  - [Exercício 2](#exercício-2)
  - [Exercício 3](#exercício-3)
    - [Exercício 3.A](#exercício-3a)
    - [Exercício 3.B](#exercício-3b)
    - [Exercício 3.C](#exercício-3c)

- [Manipulação de Dados](#manipulação-de-dados)
  - [Inserindo Dados](#inserindo-dados)
  - [Atualizando Dados](#atualizando-dados)
  - [Excluindo Dados](#excluindo-dados)
  - [Instruções COMMIT e ROLLBACK](#instruções-commit-e-rollback)

- [Procedures, Functions e Triggers](#procedures-functions-e-triggers)
  - [Procedures](#procedures)
    - [Exercício 4](#exercício-4)
    - [Exercício 4.A](#exercício-4a)
    - [Exercício 4.B](#exercício-4b)
  - [Functions](#functions)
    - [Exercício 5](#exercício-5)
    - [Exercício 5.A](#exercício-5a)
  - [Triggers](#triggers)
    - [Exercício 6](#exercício-6)
    - [Exercício 7](#exercício-7)
    - [Exercício 8](#exercício-8)

- [Cursores SQL](#cursores-sql)
  - [Cursores Implícitos](#cursores-implícitos)
    - [Atributos de um cursor SQL](#atributos-de-um-cursor-sql)
    - [Exercício 9](#exercício-9)
    - [Exercício 10](#exercício-10)
    - [Exercício 11](#exercício-11)
    - [Exercício 12](#exercício-12)
    - [Exercício 13](#exercício-13)
    - [Exercício 14](#exercício-14)
    - [Exercício 15](#exercício-15)

- [Estruturas de Controle](#estruturas-de-controle)
  - [Instruções IF](#instruções-if)
  - [Loops](#loops)
    - [Loop Básico](#loop-básico)
    - [Loop FOR](#loop-for)
    - [Loop WHILE](#loop-while)

- [O atributo %ROWTYPE](#o-atributo-rowtype)
  - [Vantagens do uso do atributo %ROWTYPE](#vantagens-do-uso-do-atributo-rowtype)
  - [Exercício 16](#exercício-16)

- [Cursores Explícitos](#cursores-explícitos)
  - [Declarando um cursor explícito](#declarando-um-cursor-explícito)
  - [Abrindo um cursor](#abrindo-um-cursor)
  - [Extraindo dados de um cursor](#extraindo-dados-de-um-cursor)
  - [Fechando o cursor](#fechando-o-cursor)
  - [Exercício 17](#exercício-17)

- [Atributos de Cursores](#atributos-de-cursores)
  - [O atributo %ISOPEN](#o-atributo-isopen)
  - [Os atributos %NOTFOUND e %ROWCOUNT](#os-atributos-notfound-e-rowcount)

- [Cursores com Registros](#cursores-com-registros)
  - [Exercício 18](#exercício-18)

- [Loops FOR de Cursores](#loops-for-de-cursores)
  - [Loops FOR usando Subconsultas](#loops-for-de-cursores-usando-subconsultas)
    - [Exercício 19](#exercício-19)
    - [Exercício 19.A](#exercício-19a)
    - [Exercício 19.B](#exercício-19b)
    - [Exercício 19.C](#exercício-19c)
    - [Exercício 19.D](#exercício-19d)

- [Cursores com Parâmetros](#cursores-com-parâmetros)

- [Cláusula FOR UPDATE](#cláusula-for-update)

- [Cursores com Subconsultas](#cursores-com-subconsultas)
  - [Exercício 20](#exercício-20)

- [Tratando Exceções](#tratando-exceções)
  - [Sintaxe](#sintaxe)
  - [Algumas exceções pré-definidas](#algumas-exceções-pré-definidas)
  - [Exercício 21](#exercício-21)
  - [Exercício 22](#exercício-22)
    - [Exercício 22.A](#exercício-22a)
    - [Exercício 22.B](#exercício-22b)
    - [Exercício 22.C](#exercício-22c)
    - [Exercício 22.D](#exercício-22d)

- [Referências](#referências)

## Blocos PL-SQL

```sql
DECLARE – opcional
    variáveis, cursores, exceções definidas pelo usuário

BEGIN – obrigatório
    instruções SQL
    instruções PL-SQL

EXCEPTION – opcional
    ações a serem desempenhadas quando ocorrem erros

END; - obrigatório
```

#### Exemplo:

```sql
DECLARE
    v_variable varchar2(5);

BEGIN
    select column_name
    into v_variable
    from table_name;

EXCEPTION
    when exception_name then ...

END;
```

### Declarando variáveis em PL-SQL

É necessário declarar todos os identificadores PL-SQL na seção de declaração antes de referenciá-los no bloco PL-SQL.

Sintaxe:
```
identificador [CONSTANT] tipo de dados [NOT NULL] [:= | DEFAULT expr];
```

Exemplos:
```sql
v_hiredate DATE;

v_deptno NUMBER(2) NOT NULL := 10;

v_location VARCHAR2(13) := 'Erechim';

c_comm CONSTANT NUMBER :=1400;
```

Outra forma de atribuir valores a variáveis é trazendo valores do banco de dados.
```sql
select sal * 0.10
    into v_bonus
    from emp
    where empno = 7369;
```

A palavra-chave `DEFAULT` também pode ser usada em vez do operador de atribuição para inicializar variáveis.

```sql
v_mgr NUMBER(4) DEFAULT 7839;
```

## Tipos de dados básicos

| Tipo de dados | Descrição |
| :--- | :--- |
| VARCHAR2 | Tipo básico para dados caracter de tamanho variável com até 32.767 bytes |
| NUMBER | Tipo básico para números fixos e de ponto flutuante |
| DATE | Tipo básico para datas e horas. Datas entre 4712 AC e 9999 DC |
| CHAR | Tipo básico para dados caracter de tamanho fixo com até 32.767 bytes |
| LONG | Tipo básico para dados caracter até um máximo de 2.147.483.647 bytes |
| LONG RAW | Tipo básico para dados binários |
| BOOLEAN | Tipo básico que armazena um de três possíveis valores: TRUE, FALSE ou NULL |
| BINARY_INTEGER | Tipo básico para inteiros entre -2.147.483.647 e 2.147.483.647 |
| PLS_INTEGER | Tipo básico para inteiros designados entre -2.147.483.647 e 2.147.483.647. Requerem menos armazenamento e são mais rápidos que os valores NUMBER e BINARY_INTEGER |

## O atributo %type

Serve para declarar uma variável como sendo do tipo definido de uma coluna do banco de dados ou outra variável previamente
declarada.

Exemplo:

```sql
...
v_ename emp.ename%type;
v_balance number(7,2);
v_min_balance v_balance%type;
...
```

## Variáveis do tipo LOB (large objects)

Com este tipo de variável é possível armazenar blocos de dados não estruturados, como textos, imagens, videoclips e formatos
de arquivos para armazenar sons.
Podem ser

- CLOBs: sigla para Character Large Object. É um tipo de dado usado em bancos de dados para armazenar grandes quantidades
de texto, como documentos, arquivos XML, logs ou qualquer conteúdo textual que exceda o tamanho suportado por tipos de
dados comuns, como VARCHAR ou CHAR.

- BLOBs: Binary Large Object é um tipo de dado usado em bancos de dados para armazenar grandes quantidades de dados
binários, como imagens, vídeos, áudios, documentos e outros arquivos não estruturados. Diferente de tipos de dados
tradicionais como VARCHAR ou TEXT, um BLOB pode armazenar dados em um formato bruto (raw), sem precisar de
conversão para texto.

- BFILEs: tipos de dados específicos usados para armazenar referências a arquivos binários que estão fora do banco de dados,
geralmente no sistema de arquivos do servidor. Diferente de um BLOB, que armazena os dados diretamente dentro do banco, o
BFILE apenas guarda um ponteiro (caminho do arquivo) para o arquivo armazenado externamente.

- NCLOB: National Character Large Object é um tipo de dado usado em bancos de dados Oracle para armazenar grandes
quantidades de texto em formatos de caracteres (NCHAR/ NVARCHAR2). Ele é similar ao CLOB (Character Large Object),
mas projetado para armazenar texto multilíngue, suportando conjuntos de caracteres internacionais.

## Instruções SELECT em PL-SQL

Sintaxe:

```sql
SELECT  select_list
    INTO {variable_name[, variable_name]... | record_name}
    FROM tabela
    WHERE condição;
```



## Exercício 1

### Obs.: Todos exercícios desta apostila de PL-SQL usarão a conta hr/hr em nosso banco de dados.

- Construir um bloco PL-SQL que retorna o número do departamento e sua localização.

```sh
sqlplus hr/hr
```
```sql
DECLARE
    v_deptno number(2);
    v_loc varchar2(15);

BEGIN
    select deptno, loc
    into v_deptno, v_loc
    from dept
    where dname = 'SALES';

END;
/
```

## Exercício 2

- Construir um bloco PL-SQL que retorna o número do departamento e sua localização. Mostrar também esta informação.

```sql
set serverout on

DECLARE
    v_deptno number(2);
    v_loc varchar2(15);

BEGIN
    select deptno, loc
    into v_deptno, v_loc
    from dept
    where dname = 'SALES';

    dbms_output.put_line('Departamento: ' || to_char(v_deptno) || '-' || 'Localizacao: ' || v_loc);

END;
/
```


## Exercício 3

- Recuperar o total de salários de todos os funcionários no departamento especificado.

```sql
DECLARE
    v_sum_sal emp.sal%type;
    v_deptno number not null := 10;

BEGIN
    select sum(sal)
    into v_sum_sal
    from emp
    where deptno = v_deptno;

    dbms_output.put_line('Soma dos salarios: ' || to_char(v_sum_sal));

END;
/
```

---

Para resolver os exercícios abaixo, primeiro crie comandos SQL que retornem as informações solicitadas, depois transforme
isso em blocos PL-SQL.

### Exercício 3.A
Mostrar o número do funcionário, seu nome e seu cargo daquele funcionário que possui o maior número/código de funcionário.

- Passo 1: mostrar o maior número de funcionário.

- Passo 2: mostrar seu nome e cargo.

- Passo 3: transformar isso em bloco PL-SQL.

### Exercício 3.B
Mostrar o nome do departamento e a localização do departamento do funcionário que foi contratado mais recentemente.

- Passo 1: mostrar a data de contratação mais recente.

- Passo 2: mostrar o número do departamento do funcionário contratado mais recentemente.

- Passo 3: mostrar nome e localização desse departamento.

- Passo 4: transformar isso em bloco PL-SQL.

### Exercício 3.C
Mostrar o nome, o cargo, o salário e a localização do funcionário que tem salário entre 4.000 e 6.000.

- Passo 1: mostrar o nome, cargo, salário e código de departamento do funcionário com salário no intervalo.

- Passo 2: mostrar a localização do departamento.

- Passo 3: transformar isso em bloco PL-SQL.

> [!NOTE]
> Respostas no arquivo 'PL-SQL - Correcao de Exercicios'

--- 

Talvez você não tenha reparado, mas os blocos PL-SQL dos exercícios anteriores só funcionaram porque as consultas
retornavam somente uma linha. Para consultas que retornam mais de uma linha faremos uso dos chamados cursores, que
veremos mais adiante. Mais de uma ou nenhuma linha geram erro. No bloco PL-SQL pode-se tratar essas exceções de erro.
Neste caso, os erros em questão a serem tratados seriam `NO_DATA_FOUND` e `TOO_MANY_ROWS`.

## Inserindo Dados

Inserir um funcionário:

```sql
BEGIN
    insert into emp (empno, ename, job, deptno)  values ( 999, 'HARDING', 'CLERK', 10 );
END;
/
```

Observe que o bloco anterior não precisaria existir se quiséssemos apenas inserir um registro. Poderíamos ter executado o
INSERT sem o bloco. Mas funciona também. Vamos verificar com

```sql
select *
from emp
where empno=999;
```

Como não há COMMIT no bloco, temos que finalizar a transação depois do bloco PLSQL executado:

```sql
commit;
```

## Atualizando Dados

Aumentar o salário de todos os funcionários na tabela EMP que sejam analistas:

```sql
select *
from emp
where job = 'ANALYST';
```

```sql
DECLARE
    v_sal_increase emp.sal%type := 2000;
BEGIN
    update emp
    set sal = sal + v_sal_increase
    where job = 'ANALYST';
END;
/
```

```sql
select *
from emp
where job = 'ANALYST';
```

```sql
commit;
```

Tenha o cuidado de não executar duas ou mais vezes !!! Caso contrário, o salário será aumentado repetidamente e você terá que

se justificar perante sua chefia, tendo talvez que passar no RH da empresa ao final do dia. Os blocos PLSQL podem ser re-
executados digitando-se “/” seguido de ENTER. Mas tenha sempre cuidado com isso em bancos de dados em “produção”.

## Excluindo dados

Excluir a linha que corresponde ao funcionário JAMES na tabela EMP:

```sql
select *
from emp
where ename = 'JAMES';
```

```sql
DECLARE
    v_ename emp.ename%type := 'JAMES';
BEGIN
    delete from emp
    where ename = v_ename;
END;
/
```

```sql
select *
from emp
where ename='JAMES';
```

```sql
commit;
```

## Instruções COMMIT e ROLLBACK

Pode-se controlar a lógica das transações com as instruções COMMIT e ROLLBACK. As transações DML são iniciadas e
finalizadas na ocorrência de uma instrução COMMIT ou ROLLBACK. Pode-se também marcar um ponto intermediário no
processo da transação através do uso dos SAVEPOINTs.

```sql
select *
from emp
where job = 'ANALYST';
```

```sql
DECLARE
    v_sal_increase emp.sal%type := 500;
BEGIN
    update emp
    set sal = sal + v_sal_increase
    where job = 'ANALYST';
    commit;
END;
/
```

```sql
select *
from emp
where job = 'ANALYST';
```

## Procedimentos, Funções e Gatilhos (procedures, functions e triggers)

### Procedures

Procedures são conjuntos de instruções SQL armazenadas no banco de dados e executadas quando invocadas. Eles podem
aceitar parâmetros de entrada e/ou retorno de valores. São úteis para encapsular lógica de negócios complexa que precisa ser
executada repetidamente.

### Functions

Functions são similares às procedures, mas **retornam um valor** escalar. Funções e procedimentos
podem ser utilizadas/chamadas em scripts, diretamente pela console SQL ou mesmo em outros procedimentos e funções. As funções são úteis para realizar cálculos ou operações em dados e retornar um resultado específico. Obviamente, também podem aceitar parâmetros de entrada.

> [!NOTE]
> Ou seja, a diferença entre function e procedure é que a function obrigatoriamente precisa retornar um valor

### Triggers

Triggers são conjuntos de instruções SQL que são automaticamente executados em resposta a
eventos específicos que ocorrem no banco de dados. Os eventos podem ser operações de inserção, atualização ou exclusão em
uma tabela. Permitem automatizar ações adicionais, como auditoria de dados, manutenção de integridade referencial, validação
de dados, entre outras. Podem ser acionados antes (before) ou depois (after) do evento que os disparou. Esses recursos são
poderosos em bancos de dados, pois permitem a criação de lógica personalizada para manipular dados e automatizar tarefas de
forma eficiente. Não há limite de tamanho para os códigos escritos nesses objetos. É claro que, para fins didáticos, veremos
exemplos bem simples em nossos exercícios, mas tais objetos podem ser realmente complexos e grandes em sistemas de
bancos de dados igualmente complexos e grandes.

---

Para facilitar ainda mais sua compreensão sobre eles, criaremos procedimentos, funções e gatilhos para basicamente as mesmas
necessidades dos exercícios anteriores. Você poderia se perguntar: mas nesse caso, se as necessidades anteriores já foram
atingidas com blocos PLSQL escritos em scripts, por que teríamos a necessidade de transformá-los nesses objetos? Tudo
depende da operacionalização. Se blocos PLSQL que serão rotineiramente executados pelo profissional de TI, desenvolvedor
ou DBA já são suficientes, tudo bem. Porém, se isso precisa ser executado a qualquer momento pelo usuário, a aplicação
poderá requisitar a execução do objeto de banco de dados (procedure ou function), sem necessidade de intervenção de outras
pessoas, e nesse caso é claramente mais eficiente ter o código implementado em tais objetos. Por vezes a performance dos
comandos armazenados no banco de dados na forma de procedimentos, funções e gatilhos, também é maior do que quando sua
execução se dá por consoles SQL, já que os objetos armazenados já estão compilados.

## Exercício 4

Criar uma procedure que receba como parâmetro um número de departamento e exiba a localização do mesmo.

```sql
CREATE OR REPLACE PROCEDURE p_local (v_deptno number) as
    v_loc varchar2(15);
BEGIN
    select loc
    into v_loc
    from dept
    where deptno = v_deptno;
    dbms_output.put_line('Depto num: ' || to_char(v_deptno) || ' - ' || 'Local: ' || v_loc);
END;
/
```

Se a procedure foi criada, significa que não houve erros de compilação. Se houve erros, digite:

```
SQL> show errors
```
para verificar quais erros foram gerados

Se não houve erros, vamos executá-la:

```
SQL> exec p_local
```

Funcionou? Por quê? ___________________________________________________________________________________________

Vamos de novo:

```
SQL> exec p_local(10)
```

Funcionou? Exibiu? Por quê? ____________________________________________________________________________________

Vamos de novo:

```
SQL> set serverout on
SQL> exec p_local(10)
```

### Exercicio 4.A

Criar uma procedure que receba como parâmetro um número de funcionário e mostre seu nome, sua data de contratação e a
cidade onde ele trabalha.

### Exercício 4.B

Criar uma procedure que receba como parâmetro um nome de cidade e mostre o nome e o salário do funcionário com o menor
salário daquela cidade.
Obs.: DALLAS: SMITH 800,00. NEW YORK: MILLER 1300,00. CHICAGO: too many rows. SEATTLE e BOSTON não
tem.

```
exec p_menor_sal_cidade ('DALLAS')
exec p_menor_sal_cidade ('NEW YORK')
exec p_menor_sal_cidade ('CHICAGO')
exec p_menor_sal_cidade ('SEATTLE')
exec p_menor_sal_cidade ('BOSTON')
```

## Exercício 5

Criar uma função que receba como parâmetro o cargo do funcionário e retorne o menor salário do cargo informado.

```sql
CREATE OR REPLACE FUNCTION f_menor_sal (v_job varchar2) RETURN NUMBER as
    v_menor_sal number(7,2);
BEGIN
    select min(sal)
    into v_menor_sal
    from emp
    where job = v_job;
    RETURN v_menor_sal;
END;
/
```
Se não houve erros, vamos executá-la:

```
SQL> exec f_menor_sal
```

Funcionou? Por quê? ______________________________________________________________________________

Vamos de novo:

```
SQL> exec f_menor_sal('CLERK')
```

Funcionou? Por quê? ______________________________________________________________________________

Vamos de novo:

```sql
select ename, job, sal
from emp
where job='CLERK';
```

```sql
select ename, job, sal
from emp
where sal = f_menor_sal('CLERK');
```
```sql
-- inserir CLERK ou SALESMAN
select ename, job, sal
from emp
where sal = f_menor_sal('&1');
```

```sql
select f_menor_sal('ANALYST')
from dual;
```

#### Agora, a função f_menor_sal criada anteriormente será usada dentro de um bloco PL-SQL:

```sql
select ename, job, sal from emp where job='CLERK';
```

```sql
-- o bloco PLSQL abaixo atualiza todos os salários dos CLERKs para o valor do menor salário entre os CLERKs utilizando a função recém criada que retornou qual é o menor entre os salários deles

DECLARE
    v_menor_sal number(7,2);
BEGIN
    v_menor_sal := f_menor_sal('CLERK');
    UPDATE emp
    SET sal = v_menor_sal
    WHERE job = 'CLERK';
    COMMIT;
END;
/
```

```sql
select ename, job, sal from emp where job='CLERK';
```

*Obs.: o texto/código de um objeto compilado fica guardado no banco de dados na view user_source. Para consultar:*

```sql
SELECT text
FROM user_source
WHERE name = 'F_MENOR_SAL' and
type = 'FUNCTION';
```

### Exercício 5.A

Criar uma função que receba como parâmetro o código de um gerente e devolva a média salarial de todos os funcionários
vinculados ao gerente passado como parâmetro.
Obs.: para fins de teste, o gerente 7698 tem funcionários com média salarial = 1400. O gerente 7839 tem funcionários com
média salarial = 2758,33.

## Exercício 6

Queremos manter o registro de alterações salariais realizadas na tabela emp. Para isso criaremos uma tabela auxiliar chamada
ATUALIZACOES_SALARIOS que irá guardar os seguintes dados: empno, ename, sal_antes, sal_depois, data_alteracao
Se você pensar bem, isso poderia ser implementado na própria aplicação que faz uso do BD, mas não é necessário, já que
podemos, para isso, criar o que chamamos de gatilho (trigger). Obs.: a trigger criada usará uma estrutura de controle IF-THEN.
Apesar de ser de fácil compreensão, falaremos um pouco mais sobre isso logo adiante neste documento.

```sql
create table ATUALIZACOES_SALARIOS 
(
    empno number(4),
    ename varchar2(10),
    sal_antes number(7,2),
    sal_depois number(7,2),
    data_alteracao date
);
```

```sql
CREATE OR REPLACE TRIGGER t_registra_salario
BEFORE UPDATE OF sal ON emp
FOR EACH ROW
BEGIN
    IF :OLD.sal != :NEW.sal THEN
        INSERT INTO ATUALIZACOES_SALARIOS (empno, ename, sal_antes, sal_depois, data_alteracao)
        VALUES (:OLD.empno, :OLD.ename, :OLD.sal, :NEW.sal, SYSDATE);
    END IF;
END;
/
```

```sql
update emp set sal=10000 where job='CLERK';
```

```sql
commit;
```

```sql
select * from atualizacoes_salarios;
```

```sql
select * from emp;
```

Note que após o UPDATE acima executamos um COMMIT. Se não tivéssemos feito isso, não teríamos efetivamente
atualizado os salário e também não teríamos as entradas na tabela atualizacoes_salarios. Por vezes, pelas
mais diferentes situações, a transação aborta sem commit e o BD realiza um rollback. Situações para isso
envolvem erros no momento do UPDATE, erros no momento da execução da TRIGGER, erros de comunicação se há
alguma tentativa de acesso remoto por dentro da TRIGGER, etc.

## Exercício 7

Vamos dropar a tabela de registro de alterações salariais e ver como uma atualização se comporta.

```sql
drop table atualizacoes_salarios;
```
```sql
update emp set sal=20000 where job='CLERK';
```

O que aconteceu? ________________________________________________________________________

Recrie a tabela e repita o update:

```sql
create table ATUALIZACOES_SALARIOS
(
    empno number(4),
    ename varchar2(10),
    sal_antes number(7,2),
    sal_depois number(7,2),
    data_alteracao date
);
```

```sql
update emp set sal=20000 where job='CLERK';
commit;
```

```sql
select * from emp;
select * from atualizacoes_salarios;
```

*Obs.: é interessante saber também que o BD, quando você dropou a tabela atualizacoes_salarios, guardou o código da TRIGGER mas ela estava com status ‘INVALID’. Isso porque o objeto TRIGGER dependia da existência da referida tabela.*

## Exercício 8

```sql
select * from user_dependencies where name = 'T_REGISTRA_SALARIO';
```

```sql
select * from user_objects where status ='INVALID';
```

```sql
drop table ATUALIZACOES_SALARIOS;
```

```sql
select * from user_objects where status ='INVALID';
```

```sql
alter trigger T_REGISTRA_SALARIO compile;
```
A Trigger compilou corretamente? ________________________________________________________

```
show errors 
```

```sql
create table ATUALIZACOES_SALARIOS
(
    empno number(4),
    ename varchar2(10),
    sal_antes number(7,2),
    sal_depois number(7,2),
    data_alteracao date
);
```

```sql
alter trigger T_REGISTRA_SALARIO compile;
```

## Cursores SQL

### Cursores implícitos

Sempre que emite-se uma instrução SQL, o Oracle Server abre uma área de memória na qual o comando é analisado e
executado. Essa área é chamada de cursor. Quando a parte executável de um bloco emite uma instrução SQL, o PL-SQL criará
um cursor implícito, que é gerenciado automaticamente. O programador pode declarar e nomear um cursor explícito, que será
visto mais adiante.

#### Atributos de um cursor SQL

| Atributo | Descrição |
| --- | --- |
| SQL%ROWCOUNT | Número de linhas afetadas pela instrução SQL mais recente(um valor inteiro) |   
| SQL%FOUND | Atributo booleano avaliado para TRUE se a instrução SQL mais recente afetar uma ou mais linhas | 
| SQL%NOTFOUND | Atributo booleano avaliado para TRUE se a instrução SQL mais recente não afetar uma ou mais linhas | 
| SQL%ISOPEN | Sempre é avaliado para FALSE no caso dos cursores implícitos pois o próprio PL-SQL fecha os mesmos após sua execução | 

## Exercício 9

Excluir da tabela EMP todos os funcionários do departamento 10, mostrando quantas linhas foram excluídas. Usaremos um
comando rollback após a transação pois queremos excluir os funcionários somente para testar o atributo SQL.

```sql
select count(*) from emp where deptno = 10;
```

```sql
set serverout on size 100000
DECLARE
    v_deptno number := 10;
BEGIN
    delete from emp
    where deptno = v_deptno;
    dbms_output.put_line ( 'Foram excluidas ' || to_char(SQL%ROWCOUNT) || ' linhas da tabela EMP');
    rollback;
END;
/
```

```sql
select count(*) from emp where deptno = 10;
```

## Exercício 10

Criar um bloco PL-SQL que seleciona o número máximo de departamento na tabela DEPT e o exibe.

## Exercício 11

Criar um bloco PL-SQL que atualize o departamento de IT da cidade de Seattle para Dallas, mostrando o número de linhas
afetadas pela atualização. Inserir o comando commit no próprio bloco.


## Exercício 12

Inserir um novo departamento 'PROJETO' com o código imediatamente superior ao do departamento RESEARCH, na cidade
de ERECHIM, através de um bloco PL-SQL. Mostrar via SQL Plus o número do novo departamento inserido e consultá-lo via SQL Plus logo após.

## Exercício 13

Queremos fazer um registro de todos os funcionários inseridos através da criação de uma trigger. Claro, você pode estar
pensando que isso poderia ser feito adicionando uma ou outra coluna na tabela EMP e criando uma consulta SQL para este fim,
mas estamos aprendendo sobre triggers e portanto faremos uma. Ela deve ser disparada sempre depois de um INSERT na tabela
EMP registrando em uma tabela auxiliar de nome EMP_INS (EMPNO, DNAME, DATA, SAL) esses dados dos funcionário
inseridos. Veja que o campo DNAME vem da tabela DEPT, e portanto o nome do departamento deve ser buscado dessa tabela
no código da trigger.

## Exercício 14

Criar uma função chamada f_func_media que recebe o número de um funcionário (empno) e devolve média salarial entre todos
os funcionários do mesmo departamento do funcionário informado.

## Exercício 15

Criar uma procedure que receba o nome de um departamento como parâmetro e atualize todos as linhas da tabela EMP desse
departamento que possuem funcionários com mais de 10 anos de empresa. Para isso vamos adicionar uma coluna nova na
tabela EMP chamada Func10 que, de início, terá todos os valores 'N';

```sql
ALTER TABLE EMP
ADD (FUNC10 CHAR(1));
```

```sql
update EMP
set FUNC10='N';
commit;
```

```sql
select * from emp;
```

## Criando estruturas de controle

Pode-se alterar o fluxo lógico de instruções usando estruturas para controle de loop e instruções IF condicionais:
```
IF – THEN - END IF
IF – THEN – ELSE - END IF
IF – THEN – ELSIF -END IF
```

### Instruções IF

#### Sintaxe

```
IF condição THEN instruções;
            [ ELSIF condição THEN instruções; ]
            [ ELSE instruções; ]

END IF;
```

#### Exemplos

1. Definir o gerente 22 caso o funcionário seja 'OSBORNE'.

```sql
IF v_ename = 'OSBORNE' THEN v_mgr := 22;
END IF;
```

2. Definir o cargo como SALESMAN, departamento 35 e comissão de 20% sobre o salário atual se o sobrenome for MILLER.

```sql
IF v_ename = 'MILLER' THEN
    v_job := 'SALESMAN';
    v_deptno := 35;
    v_new_comm := sal * 0.20;

END IF;
```

3. Definir um indicador para pedidos quando houver menos de cinco dias entre a data do pedido e a data de entrega.

```sql
IF v_shipdate – v_orderdate < 5 THEN
    v_ship_flag := 'Aceitavel';
ELSE
    v_ship_flag := 'Inaceitavel';

END IF;
```

4. Para um determinado valor, calcular um percentual desse valor com base em uma condição.

```sql
IF v_start > 100 THEN
    v_start := 2 * v_start;

ELSIF v_start >= 500 THEN
    v_start := 0.5 * v_start;

ELSE
    v_start := 0.1 * v_start;
```

## Loops

Repetem uma instrução ou sequência de instruções várias vezes.


### Loop BÁSICO:

```sql
LOOP
    Instrução 1;
    Instrução 2;
    . . .
EXIT (WHEN condição];
END LOOP;
```

### Loop FOR:

```sql
FOR contador IN [REVERSE] lower_bound .. upper_bound
    Instrução 1;
    Instrução 2;
    . . .
END LOOP;
```

### Loop WHILE:

```sql
WHILE condição LOOP
    Instrução 1;
    Instrução 2;
    . . .
END LOOP;
```

Trabalharemos com exercícios de LOOP mais adiante com os cursores explícitos.

## O atributo %ROWTYPE

Para declarar um registro com base em um conjunto de colunas em uma view ou tabela de banco de dados, usa-se o atributo
`%rowtype.`

Exemplo:

```sql
DECLARE
    emp_rec emp%rowtype;
...
```
O registro emp_rec terá uma estrutura correspondente aos campos da tabela EMP.

### Vantagens do uso do atributo %ROWTYPE
- o número e tipos de dados das colunas de banco de dados subjacentes podem não ser conhecidas.
- o número e tipos de dados das colunas de banco de dados subjacentes podem ser alteradas em tempo de execução.


Para fazer referência a um campo individual, usa-se
record_name.field_name. 
Ex:

```sql
emp_rec.comm := 750;
```

## Exercício 16

Vamos fazer um exemplo simples para demonstrar o uso do atributo rowtype. Para isso vamos inserir através de um bloco PL-
SQL os dados do funcionário MILLER (empno = 7934), que está se aposentando, em uma tabela chamada retired_emps.

```sql
create table retired_emps as
select * from emp
where rownum < 1;
```

```sql
select *
from emp
where empno=7934;
```

```sql
DECLARE
    emp_rec emp%rowtype;
BEGIN
    select * into emp_rec
    from emp
    where empno = &numero_do_empregado;
    
    insert into retired_emps (empno, ename, job, mgr, hiredate, leavedate, sal, comm, deptno )
    values (emp_rec.empno, emp_rec.ename, emp_rec.job, emp_rec.mgr, emp_rec.hiredate, sysdate, emp_rec.sal, emp_rec.comm, emp_rec.deptno);
    commit;
END;
/
```

```sql
select *
from emp
where empno=7934;
```

```sql
select *
from retired_emps
where empno=7934;
```

## Cursores explícitos

Vimos até então que cada instrução executada pelo Oracle Server tem um cursor individual associado. Podem ser implícitos,
declarados automaticamente para todas as instruções DML (recém abordados), bem como explícitos, declarados e nomeados
pelo programador. Ao usar cursores explícitos, você tem controle total sobre a iteração e processamento das linhas retornadas
pela consulta. Isso permite que você manipule as linhas conforme necessário, fazendo operações específicas em cada uma
delas.

### Declarando um cursor explicito

```sql
CURSOR cursor_name IS
    select_statement;
```

Pode-se usar também a cláusula ORDER BY se for necessária uma ordenação específica.

#### Exemplos

```sql
DECLARE
    CURSOR emp_cursor IS
        select empno, ename
        from emp;

    CURSOR dept_cursor IS
        select *
        from dept
        where deptno = 10;
```

### Abrindo um cursor 

```sql
OPEN cursor_name;
```

### Extraindo dados de um cursor

```sql
FETCH cursor_name INTO [ variavel1, variavel2, ...] | record_name];
```

A instrução FETCH recupera as linhas no conjunto ativo uma por vez. Após cada extração, o cursor avança para a próxima
linha no conjunto ativo.

Exemplo:

```sql
FECTH emp_cursor INTO v_empno, v_ename;
```

```sql
OPEN defined_cursor;
LOOP
    FETCH defined_cursor INTO defined_variables;
    EXIT WHEN ... ;
    ...
    -- processamento dos dados trazidos
    ...
END;
```

### Fechando o cursor

```sql
CLOSE cursor_name;
```

O cursor deve ser sempre fechado após o término do processamento das linhas. Pode ser reaberto se necessário. O parâmetro
OPEN_CURSORS no arquivo de inicialização do Oracle define o número máximo de cursores que podem ficar abertos para a
instância ao mesmo tempo.

### Exercício 17

Recuperar os 10 primeiros funcionários que aparecem na tabela EMP.

```sql
set serverout on

DECLARE
    v_empno emp.empno%TYPE;
    v_ename emp.ename%TYPE;
    CURSOR emp_cursor IS
        select empno, ename
        from emp;

BEGIN
    OPEN emp_cursor;
    FOR I IN 1..10 LOOP
        FETCH emp_cursor INTO v_empno, v_ename;
        DBMS_OUTPUT.PUT_LINE ('Funcionario ' || to_char(i) || ':' || v_empno || '-' || v_ename);
    END LOOP;
    CLOSE emp_cursor;
END;
/
```


## O atributo %ISOPEN

Pode ser usado para garantir o acesso ao cursor somente quando o mesmo estiver aberto.

Exemplo:

```sql
IF NOT emp_cursor%ISOPEN THEN
    OPEN emp_cursor;
END IF;

LOOP
    FETCH emp_cursor ...
```

## Os atributos %NOTFOUND e %ROWCOUNT

Exemplo (veja que no caso abaixo não foi necessário o FOR porque ou o ROWCOUNT ou o NOTFOUND determinariam o
fim do FETCH):

```sql
set serverout on

DECLARE v_empno emp.empno%type;
    v_ename emp.ename%type;
    CURSOR emp_cursor IS
        SELECT empno, ename
        FROM emp;

BEGIN
    OPEN emp_cursor;
    LOOP
        FETCH emp_cursor INTO v_empno, v_ename;
            EXIT WHEN emp_cursor%rowcount > 6 OR emp_cursor%notfound;
            DBMS_OUTPUT.PUT_LINE ('Funcionario' || ': ' || v_empno || '-' || v_ename);
    END LOOP;   
    CLOSE emp_cursor;
END;
/
```

## Cursores com registros

Servem para processar linhas de um conjunto ativo extraindo valores para um PL-SQL Record. Pode-se também definir um
registro com base na lista selecionada de colunas em um cursor explícito. Na operação de FETCH, ao usar um registro, não é
necessário especificar cada um dos campos, já que os dados do cursor são jogados para o registro.


## Exercício 18

Usar um cursor para recuperar números e nomes de funcionários e inserir em uma tabela essas informações.

```sql
create table ListaFunc ( NumFunc  number(4),
                         NomeFunc varchar2(10));
```

```sql
DECLARE
    CURSOR emp_cursor IS
        SELECT empno, ename
        FROM emp;
    emp_record emp_cursor%ROWTYPE;

BEGIN
    OPEN emp_cursor;
    LOOP
        FETCH emp_cursor INTO emp_record;
        EXIT WHEN emp_cursor%NOTFOUND;
        
        INSERT INTO ListaFunc ( numfunc, nomefunc )
        VALUES                ( emp_record.empno, emp_record.ename );
    END LOOP;
    COMMIT;
    CLOSE emp_cursor;
END;
/
```

```sql
select * from ListaFunc;
```

## Loops FOR de cursores

### Sintaxe

```sql
FOR record_name IN cursor_name LOOP
    Instrução1;
    Instrução2;
    . . .
END LOOP;
```

**record_name** é o nome do registro declarado implicitamente.
**cursor_name** é um identificador PL-SQL para o cursor declarado anteriormente.

Um loop FOR de cursor processa linhas em um cursor explícito. Ele é um atalho porque o cursor é aberto, linhas são extraídas
uma vez para cada iteração no loop e o cursor é fechado automaticamente após o processamento de todas as linhas. O loop em
si é terminado automaticamente ao final da iteração quando a última linha for extraída. É prático porque percorrerá todo o
cursor, linha por linha, permitindo processamentos em particular para cada linha, e geralmente é isso que é utilizado, já que na
maioria das vezes busca-se analisar todos os dados de um cursor e não somente conjuntos de dados dele como vimos
anteriormente quanto usamos o atributo *rowcount*.

## Exercício 19

Mostrar os funcionários que estão trabalhando atualmente no departamento de vendas.

```sql
set serverout on

DECLARE
    CURSOR emp_cursor IS
        select ename, deptno
        from emp;

BEGIN
    FOR emp_record IN emp_cursor
    LOOP
        IF emp_record.deptno = 30 THEN
        DBMS_OUTPUT.PUT_LINE ('O funcionario ' || emp_record.ename || ' trabalha no depto de vendas');
        END IF;
    END LOOP;
END;
/
```

## Loops FOR de cursores usando subconsultas

Nestes casos, não é necessário declarar um cursor. Por exemplo, o exercício 9 poderia ser resolvido da seguinte forma:

```sql
set serverout on

BEGIN
    FOR emp_record IN (
        select ename, deptno
        from emp 
    )
    LOOP
        IF emp_record.deptno = 30 THEN
            DBMS_OUTPUT.PUT_LINE ('O funcionario ' || emp_record.ename || ' trabalha no depto de vendas');
        END IF;
    END LOOP;
END;
/
```

### Exercício 19.A

Criar uma procedure chamada ClassificaEmp que varre a tabela de empregados usando FOR LOOP e mostra o nome do
empregado, seu salário, e uma classificação como “Salario Alto” se o salário for maior que 2.500 ou “Salario Normal” caso
contrário.

### Exercício 19.B

Altere a procedure anterior para as seguintes classificações: “Salario Alto” se o salário for maior que 2.500, “Salario Medio” se
o salário for entre 1.000 e 2.500, e “Salario Baixo” se for menor que 1.000.

### Exercício 19.C

Criar uma procedure chamada AumentaSalario que receba como parâmetro um valor de salário e através de um cursor com
FOR LOOP atualize todos os salários menores que o parâmetro informado aumentando os mesmos em 10%. A procedure
deverá exibir na tela o número, o nome, o salário antigo e o novo salário do funcionário.

### Exercício 19.D

Mude a procedure anterior para tornar o percentual de aumento do salário um outro parâmetro passado na chamada da função.


## Cursores com parâmetros

Parâmetros permitem que valores sejam passados para um cursor quando ele é aberto e sejam usados na consulta quando ela é
executada. Cada parâmetro na declaração do cursor deve ter um parâmetro correspondente na instrução OPEN. Os tipos de
dados dos parâmetros são iguais aos das variáveis, só que não precisa ser definido um tamanho para eles.

### Sintaxe

```sql
CURSOR cursor_name [ ( parameter_name tipo_de_dado, ... ) ]
IS
select_statement;
```

### Exemplos

```sql
DECLARE
    v_emp_job emp.job%type := 'CLERK'
    v_ename emp.ename%type;
    CURSOR emp_cursor ( p_deptno NUMBER, p_job VARCHAR2 ) IS
        SELECT ...
```

Qualquer das instruções a seguir abre o cursor:

```sql
OPEN emp_cursor ( 10, v_emp_job );
```

```sql
OPEN emp_cursor ( 20, 'ANALYST');
```

Pode-se passar também parâmetros para um cursor dentro de um loop FOR:

```sql
DECLARE
    CURSOR emp_cursor (p_deptno NUMBER, p_job VARCHAR2) IS
        SELECT ...

BEGIN
    FOR emp_record IN emp_cursor (10, 'ANALYST') LOOP ...
```

## A cláusula FOR UPDATE

É conveniente utilizar a cláusula FOR UPDATE sempre antes de alguma atualização ou exclusão de linhas. Se quiséssemos
atualizar os salários de todos os funcionários do departamento 30, poderíamos fazer um cursor que nos garantisse que as linhas
estariam liberadas para a atualização antes de disparar o comando UPDATE.

Por exemplo:

```sql
DECLARE
    CURSOR emp_cursor IS
        select empno, ename, sal
        from emp
        where deptno = 30
        FOR UPDATE OF sal NOWAIT;
```

## Cursores com subconsultas

Uma subconsulta é uma consulta, geralmente entre parênteses, que aparece dentro de outra instrução DML. São geralmente
usadas na cláusula WHERE de uma sentença SQL, mas podem ser usadas também na cláusula FROM.

Exemplo:

```sql
DECLARE

    CURSOR funcs_cursor IS
        select t1.deptno, t1.dname, t2.total
        from dept t1, ( select deptno, count(*) total
                        from emp
                        group by deptno ) t2
        where t1.deptno = t2.deptno and
        t2.total > 3;
```

No exemplo anterior, o cursor possui uma subconsulta na cláusula FROM, que monta uma tabela temporária contendo o
número de funcionários por departamento. Assim, ele pode retornar somente o código e o nome dos departamentos que
possuam mais de 3 funcionários, bem como o total de funcionários desses departamentos.


## Exercício 20

Usar um cursor para recuperar o número e o nome dos departamentos a partir da tabela DEPT. Passar o número do
departamento para outro cursor que deverá recuperar os detalhes sobre o nome do funcionário, cargo, data de admissão e
salário de todos os funcionários que trabalham naquele departamento a partir da tabela EMP.

## Tratando exceções

Uma exceção é um identificador em PL-SQL criado durante a execução de um bloco que termina seu corpo principal de ações.
Um bloco sempre termina quando o código PL-SQL cria uma exceção, mas pode-se especificar um handler (manipulador) de
exceções para executar ações finais.

Existem duas formas de criação de exceções:

- quando o próprio Oracle Server gera a mesma. Por exemplo, na ocorrência do erro ORA-01403, quando nenhuma
linha é recuperada do banco de dados em uma instrução SELECT. Nesse momento, será gerada a exceção
NO_DATA_FOUND

- quando a exceção é criada explicitamente, emitindo a instrução RAISE dentro do bloco. Trata-se de uma exceção
definida pelo programador

Uma exceção pode ser capturada pelo manipulador e tratada dentro do bloco, concluindo o mesmo com êxito, ou se propagar
para o ambiente que chamou o procedimento PL-SQL terminando o processo com falha.

### Sintaxe

```sql
EXCEPTION
    WHEN exceção1 [ OR exceção2 . . . ] THEN
        instrução1;
        instrução2;
        . . .

    [ WHEN exceção3 [ OR exceção4 . . . ] THEN
        instrução1;
        instrução2;
        . . . ]
    [ WHEN OTHERS THEN
        instrução1;
        instrução2;
        . . . ]
```

O handler de exceção WHEN OTHERS captura qualquer exceção não tratada. Por isso é o último handler de exceção definido.


### Algumas exceções pré-definidas

| Nome da exceção | Erro do Oracle Server | Quando ocorre | 
| --- | --- | --- | 
| CURSOR_ALREADY_OPEN | ORA-06511 | Na tentativa de abertura de um cursor já aberto |
| INVALID_NUMBER | ORA-01722 | Na falha de conversão de string de caracteres para número |
| LOGIN_DENIED | ORA-01017 | Ao estabelecer login com o Oracle Server com usuário ou senha inválido(a) |
| NO_DATA_FOUND | ORA-01403 | Em consultas de linha única que não retornam dados |
| NOT_LOGGED_ON | ORA-01012 | Em uma chamada ao banco de dados sem estar conectado ao mesmo |
| TIMEOUT_ON_RESOURCE | ORA-00051 | Ao exceder o tempo limite de espera por um recurso  |
| TOO_MANY_ROWS | ORA-01422 | Em consultas de linha única que retornam mais de uma linha |
| ZERO_DIVIDE | ORA-01476 | Na tentativa de divisão por ZERO |

### Exemplo

```sql
BEGIN
    EXCEPTION
        when NO_DATA_FOUND then
            instrucao1;
            instrucao2;
        when TOO_MANY_ROWS then
            instrucao1;
        when OTHERS then
            instrucao1;
            instrucao2;
            instrucao3;
END;
```

## Exercício 21

No bloco PLSQL abaixo estamos buscando na tabela emp o nome de um empregado por cargo e jogando para dentro de duas
variáveis a serem usadas na função PUT_LINE. Porém, sempre é esperado que tal SQL somente retorne uma linha, e, assim,
zero linhas ou mais de uma linha seria um erro, que será tratado pelas exceções inseridas. Vamos entrar primeiro com o valor
PRESIDENT para o filtro da cláusula WHERE. Tudo funciona bem porque existe só 1 presidente. Mudar depois o job para
SALESMAN para gerar a exception TOO_MANY_ROWS. Depois trocar o job para DBA para gerar a exception
NO_DATA_FOUND.

```sql
set serverout on

DECLARE
    v_ename emp.ename%type;
    v_deptno emp.deptno%type;
BEGIN
    SELECT ename, deptno INTO v_ename, v_deptno
    FROM emp
    WHERE job = '&1';
    DBMS_OUTPUT.PUT_LINE ('Funcionario ' || v_ename || ' trabalha no depto ' || v_deptno);

    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Erro: nenhum dado encontrado pela consulta SQL');
        WHEN TOO_MANY_ROWS THEN
            DBMS_OUTPUT.PUT_LINE('Mais de uma linha encontrada pela consulta SQL');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
END;
/
```

## Exercício 22

Mas e o que aconteceria com o mesmo bloco PLSQL se as exceções não fossem inseridas. Veja abaixo que o bloco é idêntico
ao anterior porém sem o tratamento de exceções. Insira PRESIDENT, SALESMAN e DBA novamente observando o que
acontece em cada um dos casos.

```sql
set serverout on

DECLARE
    v_ename emp.ename%type;
    v_deptno emp.deptno%type;
BEGIN
    SELECT ename, deptno INTO v_ename, v_deptno
    FROM emp
    WHERE job = '&1';
    DBMS_OUTPUT.PUT_LINE ('Funcionario ' || v_ename || ' trabalha no depto ' || v_deptno);
END;
/
```

Qual diferença você percebeu entre as execuções dos exercícios anteriores, ou seja, quando havia tratamento de exceções e
quando não havia? 

Com a prática você perceberia que quando o SGBD gera um erro, o bloco PLSQL, esteja ele em um script, dentro de uma
procedure, de uma trigger ou de uma função, é abortado. No entanto, se há tratamento de exceções, o processamento poderá
continuar conforme programado.

### Exercício 22.A

Criar um bloco PL/SQL que mostra quantas vezes o maior salário da empresa é maior do que o salário de cada funcionário,
mostrando também o nome de cada funcionário.
Os nomes dos funcionários devem aparecer em ordem decrescente de seus números.

### Exercício 22.B

Inserir agora o seguinte funcionário em EMP:
insert into emp (empno, ename, job, mgr, hiredate, sal, deptno) values (8000,'MATHEUS', 'CLERK', 7935, sysdate, 0, 10);
commit;
Executar o mesmo bloco PL/SQL do exercício anterior. O que acontece?

### Exercício 22.C

Inserir agora no bloco PL/SQL uma exceção do tipo ZERO_DIVIDE que resolva o problema.

### Exercício 22.D

Mudar agora a exceção de ZERO_DIVIDE para OTHERS mas mostrando na mensagem o código de erro do Oracle.

---

[1]
Três principais publicações foram consultadas para o desenvolvimento desta sequência didática de exercícios:

Krishnamurthy, U. Oracle Database SQL Language Quick Reference. Oracle Corporation Press, 2022. Disponível em:
<https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlqr/sql-language-quick-reference.pdf>. Acesso em: 21 mar. 2024.

Kochhar, N.; Gravina, E.; Nathan, P. Introduction to Oracle – SQL and PL-SQL - NT. Oracle Corporation Press, 2000.

Morin, L. Database PL/SQL Language Reference. Oracle Corporation Press, 2023. Disponível em:
<https://docs.oracle.com/en/database/oracle/oracle-database/19/lnpls/database-pl-sql-language-reference.pdf>. Acesso em: 21
mar. 2024.



