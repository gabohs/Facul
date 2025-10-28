CREATE DATABASE aula5;
USE aula5;

CREATE TABLE cidade (
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(32) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    
    PRIMARY KEY (id)
);

INSERT INTO cidade (nome, uf) VALUES
	('Porto Alegre', 'RS'),
	('Caxias do Sul', 'RS'),
	('Pelotas', 'RS'),
	('Canoas', 'RS'),
	('Erechim', 'RS'),

	('Florianópolis', 'SC'),
	('Joinville', 'SC'),
	('Blumenau', 'SC'),
	('São José', 'SC'),
	('Chapecó', 'SC'),

	('São Paulo', 'SP'),
	('Guarulhos', 'SP'),
	('Campinas', 'SP'),
	('São Bernardo do Campo', 'SP'),
	('Santo André', 'SP'),
	('Osasco', 'SP'),
	('Sorocaba', 'SP'),
	('Ribeirão Preto', 'SP'),
	('São José dos Campos', 'SP'),
    
    ('Manaus', 'AM');

    
ALTER TABLE cidade
	ADD COLUMN regiao VARCHAR(20) NOT NULL;
    
UPDATE cidade SET regiao = 
CASE
	WHEN uf in ('RS', 'SC', 'PR')
		THEN 'Sul'
	WHEN uf in ('SP', 'RJ', 'ES')
		THEN 'Sudeste'
	ELSE 'Norte'
        
	END;
    
DELETE FROM cidade;
-- ----------------------------------
SELECT * FROM cidade;

SELECT * FROM cidade
	WHERE uf = 'RS';
    
SELECT * FROM cidade
	ORDER BY nome DESC;