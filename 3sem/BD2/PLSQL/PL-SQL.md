# Exercício sobre a linguagem PL-SQL

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



