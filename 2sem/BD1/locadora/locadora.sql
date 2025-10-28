CREATE DATABASE IF NOT EXISTS LocadoraCompleta;
USE LocadoraCompleta;

CREATE TABLE cidade (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    UF CHAR(2) NOT NULL,
    regiao VARCHAR(20)
);

CREATE TABLE marca (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL
);

CREATE TABLE cliente (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cpf BIGINT NOT NULL UNIQUE,
    nome VARCHAR(45) NOT NULL,
    telefone BIGINT,
    rua VARCHAR(45),
    bairro VARCHAR(45),
    cep BIGINT,
    data_nascimento DATE,
    codcidade INT,
    CONSTRAINT fk_cliente_cidade FOREIGN KEY (codcidade) REFERENCES cidade (id)
);

CREATE TABLE carro (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(10) NOT NULL UNIQUE,
    modelo VARCHAR(45) NOT NULL,
    ano INT,
    cor VARCHAR(45),
    codmarca INT,
    CONSTRAINT fk_carro_marca FOREIGN KEY (codmarca) REFERENCES marca (id)
);

CREATE TABLE aluguel (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dataAluguel DATE NOT NULL,
    dataDevolucao DATE NOT NULL,
    codcliente INT NOT NULL,
    codcarro INT NOT NULL,
    CONSTRAINT fk_aluguel_cliente FOREIGN KEY (codcliente) REFERENCES cliente (id),
    CONSTRAINT fk_aluguel_carro FOREIGN KEY (codcarro) REFERENCES carro (id)
);

-- ===========================================================
-- INSERÇÕES
-- ===========================================================

-- CIDADES
INSERT INTO cidade (nome, UF, regiao) VALUES
('Erechim', 'RS', 'SUL'),
('Sertão', 'RS', 'SUL'),
('Gaurama', 'RS', 'SUL'),
('São Paulo', 'SP', 'SUDESTE'),
('Curitiba', 'PR', 'SUL'),
('Florianópolis', 'SC', 'SUL'),
('Belo Horizonte', 'MG', 'SUDESTE'),
('Rio de Janeiro', 'RJ', 'SUDESTE');

-- MARCAS
INSERT INTO marca (nome) VALUES
('Volkswagen'),
('Honda'),
('Toyota'),
('Chevrolet'),
('Fiat'),
('Nissan'),
('Renault'),
('Hyundai');

-- CLIENTES
INSERT INTO cliente (cpf, nome, telefone, rua, bairro, cep, data_nascimento, codcidade) VALUES
(1451658640, 'Alessandra', 999893614, 'Rua Alemanha', 'Centro', 99711000, '1996-02-12', 1),
(1603406003, 'Ana', 999336925, 'Rua Marcelino Ramos', 'Centro', 99711000, '1999-10-09', 1),
(3361391080, 'Alissia', 999693619, 'Rua Itália', 'Centro', 99711000, '1997-05-10', 1),
(6639625812, 'Amanda', 999698732, 'Rua Portugal', 'Centro', 99711000, '1998-12-26', 2),
(9963285471, 'Bruna', 999567984, 'Rua Paris', 'Centro', 99711011, '2000-02-12', 3),
(89974126398, 'Maria', 999896574, 'Rua Londres', 'Centro', 99711011, '2005-02-20', 3),
(1496385274, 'João', 999749685, 'Rua Brasil', 'Espírito Santo', 99711060, '2001-02-01', 2),
(6675395186, 'Marcelo', 999326947, 'Rua Branca', 'Centro', 99711040, '1996-07-23', 2),
(7756398710, 'Melissa', 999012639, 'Rua Germânio', 'Centro', 99711000, '1995-06-02', 1),
(1670904040, 'Júlia', 999895210, 'Rua Natal', 'Santa Catarina', 99711000, '2000-05-04', 1),
(99876123456, 'Pedro', 999112233, 'Rua São Paulo', 'Centro', 11000100, '1990-09-15', 4),
(88765432100, 'Lucas', 999554433, 'Av. Paraná', 'Centro', 80000000, '1998-07-12', 5),
(77654321900, 'Carla', 999334455, 'Rua das Flores', 'Trindade', 88000000, '1993-01-25', 6),
(66543219800, 'Isabela', 999667788, 'Rua Afonso Pena', 'Savassi', 30130000, '1997-04-19', 7),
(55432198700, 'Roberto', 999778899, 'Av. Atlântica', 'Copacabana', 22000000, '1985-11-30', 8);

-- CARROS
INSERT INTO carro (placa, modelo, ano, cor, codmarca) VALUES
('LSN4I49', 'Virtus', 2022, 'Cinza', 1),
('EFN4I49', 'Civic', 2021, 'Preto', 2),
('FRL9P36', 'Corolla', 2023, 'Branco', 3),
('LMN5I36', 'Polo', 2024, 'Prata', 1),
('ABC1D23', 'Onix', 2020, 'Azul', 4),
('FGH4E56', 'Argo', 2021, 'Vermelho', 5),
('JKL7G89', 'Kicks', 2022, 'Preto', 6),
('MNO9H01', 'Duster', 2019, 'Branco', 7),
('PQR2I34', 'HB20', 2023, 'Prata', 8),
('STU5J67', 'Golf', 2020, 'Vermelho', 1);

-- ALUGUEIS
INSERT INTO aluguel (dataAluguel, dataDevolucao, codcliente, codcarro) VALUES
('2025-01-10', '2025-01-15', 1, 1),
('2025-02-01', '2025-02-05', 2, 2),
('2025-02-10', '2025-02-14', 3, 3),
('2025-03-05', '2025-03-10', 4, 4),
('2025-03-12', '2025-03-15', 5, 5),
('2025-04-01', '2025-04-03', 6, 6),
('2025-04-07', '2025-04-12', 7, 7),
('2025-05-10', '2025-05-17', 8, 8),
('2025-05-25', '2025-05-28', 9, 9),
('2025-06-01', '2025-06-06', 10, 10),
('2025-06-10', '2025-06-15', 11, 1),
('2025-06-20', '2025-06-23', 12, 2),
('2025-07-01', '2025-07-05', 13, 3),
('2025-07-10', '2025-07-14', 14, 4),
('2025-07-15', '2025-07-20', 15, 5);


-- ===========================================================

-- Ver todos os clientes
SELECT * FROM cliente;

-- Ver todos os carros
SELECT * FROM carro;

-- Ver todos os aluguéis (mostra códigos de cliente e carro)
SELECT * FROM aluguel;

-- Ver todas as cidades
SELECT * FROM cidade;

-- Ver todas as marcas
SELECT * FROM marca;

-- Clientes cujo nome começa com 'A'
SELECT * FROM cliente WHERE nome LIKE 'A%';

-- Carros do ano de 2022
SELECT * FROM carro WHERE ano = 2022;

-- Aluguéis do mês de março
SELECT * FROM aluguel WHERE MONTH(dataAluguel) = 3;

-- Ordenar clientes por nome
SELECT * FROM cliente ORDER BY nome ASC;

-- Ordenar carros por modelo
SELECT * FROM carro ORDER BY modelo ASC;
