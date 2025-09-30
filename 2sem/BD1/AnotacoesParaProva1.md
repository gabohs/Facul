#  Resumo: Tópicos Importantes para Prova de Banco de Dados 1

## 1. Conceitos Fundamentais

- Banco de Dados: Coleção de dados relacionados, logicamente coerente, com significado inerente, projetado para uma finalidade específica
- Dados: Conjunto de informações organizadas (texto, fotos, sons, números, etc.)
- Informação: Dados organizados e transformados com significado
- Conhecimento: Resultado de várias informações organizadas logicamente

**Sistema de Banco de Dados**: Consiste em dados inter-relacionados + programas para acesso, com o objetivo de criar  um ambiente adequado e eficiente para recuperação e armazenamento

## 2. SGBD (Sistema de Gerenciamento de Banco de Dados)

- Software que manipula informações e interage com usuários

#### Vantagens dos SGBDs

- Rapidez na manipulação e acesso
- Redução da redundância
- Redução de problemas de integridade
- Restrições de segurança robustas
- Melhora no compartilhamento

- Características Principais: Integração, Restrições, Segurança/Privacidade, Restauração, Reorganização, Eficiência

## 3. Abstração e Projeto de BD

#### Níveis de Projeto

- Conceitual: Independente do SGBD, usando modelo Entidade-Relacionamento (ER/DER)
- Lógico: Depende do tipo de SGBD (relacional, orientado a objetos, etc.)
- Físico: Como os dados são realmente armazenados


## 4. Normalização

#### Objetivos

- Eliminar redundâncias e inconsistências
- Garantir integridade dos dados
- Facilitar manutenção
- Melhorar desempenho

### Formas Normais

#### Primeira Forma Normal (1FN)

-  Cada célula contém apenas um valor atômico
-  Cada registro é único (chave primária)
-  Não pode ter atributos multivalorados ou compostos

### Segunda Forma Normal (2FN)

- Deve estar em 1FN
- Todos os atributos não-chave dependem completamente da chave primária
- Elimina dependências parciais

### Terceira Forma Normal (3FN)

- Deve estar em 2FN
- Nenhum atributo não-chave depende de outro atributo não-chave
- Elimina dependências transitivas

## 5. Tipos de Dados

#### Tipos de Caracteres

- CHAR: Tamanho fixo (ex: CHAR(10))
- VARCHAR: Tamanho variável (ex: VARCHAR(255))
- TEXT: Para grandes blocos de texto

#### Tipos Numéricos

- INT: Números inteiros
- DECIMAL/NUMERIC: Números com casas decimais (ex: DECIMAL(10,2))
- FLOAT, REAL: Números de ponto flutuante

#### Tipos Data/Hora

- DATE: Apenas data
- DATETIME: Data e hora
- DATETIME2: Versão melhorada do DATETIME

## 6. Linguagem SQL

#### Divisões da SQL

- DDL (Data Definition Language): CREATE, ALTER, DROP
- DML (Data Manipulation Language): SELECT, INSERT, UPDATE, DELETE
- DCL (Data Control Language): GRANT, REVOKE

### Comandos DDL importantes

- DDL: Data Definition Language
- Esses comandos assumem o papel de definir ou modificar a estrutura do banco de dados

#### Criando o banco de dados

```SQL
CREATE DATABASE nome_bd;
USE nome_bd;
```

#### Criando tabela

```SQL
CREATE TABLE tabela (
    id INT NOT NULL AUTO_INCREMENT,
    coluna2 VARCHAR(50) NOT NULL,
    coluna3 DATE,

    PRIMARY KEY (id)
);
```

#### Alterando tabela

```SQL
-- Adicionando coluna
ALTER TABLE tabela
    ADD COLUMN <nova_coluna> VARCHAR(100);
```

```SQL
-- Renomeando coluna
ALTER TABLE tabela
    CHANGE COLUMN <nome_antigo> <nome_novo> <TIPO>;
```

```SQL
-- Modificando tipo da coluna
ALTER TABLE tabela
    MODIFY COLUMN <coluna> <NOVO_TIPO>;
```

### Comandos DML Importantes

- DML: Data Manipulation Language
- Esses comandos são usados para trabalhar com os dados dentro do banco de dados

#### Insert

```SQL
INSERT INTO tabela (<coluna1>, <coluna2>, ...) VALUES 
    (<'valor1'>, <'valor2'>, ...);
```

#### Select

```SQL
SELECT * FROM tabela;
```

```SQL
SELECT <coluna1>, <coluna2> FROM <tabela> WHERE <condição>;
```

#### Update

```SQL
UPDATE <tabela>
    SET <coluna> = <novo_valor> WHERE <condicao>
```

#### Delete

- Usado para remover linhas (rows) de uma tabela

```SQL
DELETE FROM <tabela> -- Deleta todas as linhas da tabela, a esvaziando
```

```SQL
DELETE FROM <tabela> WHERE <condicao> --Deleta as linhas respeitando a condição estabelecida
```

#### Drop

```SQL
DROP TABLE table_name; -- Remove completamente a tabela do banco de dados
```

```SQL
ALTER TABLE
    DROP COLUMN <coluna> -- Deleta a coluna especificada
```

### Cláusula WHERE

- Filtra registros baseado em condições

#### Exemplos

- Usando uma tabela "carro", que, como o nome sugere, contém dados de veículos:

```SQL
SELECT modelo, valorDiaria FROM carro WHERE valorDiaria BETWEEN 80 AND 120;

SELECT placa FROM carro WHERE placa LIKE "%1234";

SELECT modelo FROM carro WHERE modelo NOT LIKE "%a";

DELETE FROM carro WHERE ID IN(11, 12);
```

## 7. As Principais Restrições (Constraints)

- PRIMARY KEY: Chave primária
- FOREIGN KEY: Chave estrangeira
- UNIQUE: Valores únicos
- NOT NULL: Não aceita valores nulos
- DEFAULT: Valor padrão
- CHECK: Verifica limites de valores

##  8. Modelo Entidade-Relacionamento (MER)

- Lista de entidades, atributos e relacionamentos.

### Componentes Principais

#### Entidades 

- Objetos do mundo real (pessoas, objetos, eventos)

#### Atributos 

- Características que descrevem as entidades
- Possuem sempre um tipo de dados (domínio)

- Atributo Simples/Atômico: indivisível. Ex.: CPF. Em um cenário ideal, todos os atributos de uma tabela (entidade) devem ser atômicos, e ao desenvolver o banco de dados deve-se ter isto como objetivo, salvo algumas exceções.
  
- Atributo Composto: pode sem dividido em atributos menores. Ex.: Endereço
  
- Atributo Multivalorado: pode conter mais de um valor para um mesmo registro. Ex.: Telefone. Por exemplo, uma pessoa pode ter tanto um telefone pessoal, quanto um telefone de casa.

- Atributo Determinante: pode ser um ID específico, ou também um CPF, por exemplo, visto que este é um número único. Como ele nunca se repete, sabendo o valor do atr. determinante, podemos descobrir com certeza o valor de outro(s) atributo(s). Um exemplo seria a chave primária.

- Atributo Identificador: identifica uma instância específica na classe de entidade. Um exemplo seria as chaves estrangeiras.


#### Relacionamentos

- Associações entre entidades

### Tipos de Relacionamentos (Cardinalidade)

- Um para Um (1:1)
- Um para Muitos (1:N)
- Muitos para Um (N:1)
- Muitos para Muitos (N:N)

### Chaves

- Chave Primária: Identifica exclusivamente cada registro
- Chave Estrangeira: Estabelece relacionamentos entre entidades
- Chave Candidata/Alternativa: Outros atributos que podem identificar registros


## 9. Diagrama Entidade-Relacionamento (DER)

- utilizado para representar de forma gráfica o que foi descrito no MER 




