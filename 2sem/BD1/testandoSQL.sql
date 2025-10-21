CREATE DATABASE testando;
DROP DATABASE testando;

USE testando;

-- Criando tabelas

CREATE TABLE pessoa (
	id INT not null auto_increment,
    
	nome          VARCHAR(30) not null,
    nascimento    DATE not null,
    idade         TINYINT not null,
    sexo          ENUM('M', 'F'),
    peso          DECIMAL(5, 2), -- 5 casas, 2 após a vírgula
    altura        DECIMAL(3, 2),
    nacionalidade VARCHAR(20) default 'Brasil',
    
    PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4;

CREATE TABLE if not exists curso (
	nome VARCHAR(30) not null unique,
    descricao TEXT,
    cargaH INT unsigned
);

DROP TABLE pessoa;
DESCRIBE pessoa;

DROP TABLE curso;
DESC curso;

-- --------------------------------------------------------------------------------------------------------------------------------
-- Inserindo na Tabela

INSERT INTO pessoa (nome, nascimento, idade, sexo, peso, altura, nacionalidade) VALUES
	("Gabriel", "2007-03-21", '18', 'M', '78.5', '1.83', "Brasil"),
    ("Fulano", "1985-01-02", '40', 'M', '70.5', '1.63', DEFAULT);
    
INSERT INTO pessoa VALUES
	(DEFAULT, "Fulana", "2001-06-15", '24', 'F', '55.2', '1.58', 'Inglaterra');

-- --------------------------------------------------------------------------------------------------------------------------------
-- Alterando a estrutura da tabela

-- Adicionando nova coluna
ALTER TABLE pessoa
	ADD COLUMN profissao VARCHAR(10) after nome; -- Adiciona novo atributo (coluna) 'profissao' após a coluna 'nome'
    
ALTER TABLE curso
	ADD id INT PRIMARY KEY not null auto_increment first;
    
-- Removendo colunas
ALTER TABLE pessoa
	DROP COLUMN profissao; -- remove a coluna 'profissao'
    
-- Alterando tipo de coluna
ALTER TABLE pessoa
	MODIFY COLUMN profissao VARCHAR(20) not null default ''; -- altera o tipo da coluna 'profissao'
	
-- Renomeando coluna
ALTER TABLE pessoa
	CHANGE COLUMN profissao prof VARCHAR(20) not null default '';	
        
-- Renomeando Tabela
ALTER TABLE pessoa
	RENAME TO cliente;
    
-- Removendo tabela
DROP TABLE if exists curso;

-- --------------------------------------------------------------------------------------------------------------------------------
-- Manipulando linhas (registros)

UPDATE pessoa
	SET nome = "Ciclana" 
    WHERE id = '3' OR nome LIKE '%ane';
    
UPDATE pessoa
	SET idade = '100', nascimento = '1925-03-21'
	WHERE nome = 'Fulana' AND sexo = 'F'
    LIMIT 1; -- muda só a primeira ocorrencia
    
DELETE FROM pessoa
	WHERE id IN (3, 4);
    
TRUNCATE pessoa; -- Esvazia a tabela

-- --------------------------------------------------------------------------------------------------------------------------------
    
SELECT * FROM pessoa;
SELECT * FROM curso;

 