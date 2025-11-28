CREATE DATABASE IF NOT EXISTS dagostini;
USE dagostini;

CREATE TABLE Cidade(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(64) NOT NULL, -- Acrescentamos o campo nome na tabela cidade
    UF   VARCHAR(2)  NOT NULL
);

CREATE TABLE Fornecedor(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(64) NOT NULL, -- Acrescentamos o campo nome no fornecedor
    descricao TEXT   NOT NULL,
	tipo VARCHAR(64) NOT NULL, -- Acrescentamos um campo para poder definir um tipo para cada fornecedor
    id_cidade INT
);

CREATE TABLE Cliente(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome     VARCHAR(64) NOT NULL,
    rua      VARCHAR(64) NOT NULL,
    bairro   VARCHAR(64) NOT NULL,
    cep      VARCHAR(9)  NOT NULL,
    cfp      VARCHAR(11) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    
    id_cidade INT
);

CREATE TABLE Produto(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(64) NOT NULL,
    preco DOUBLE     NOT NULL,
    descricao TEXT   NOT NULL,
    quantidade_em_estoque INT NOT NULL, -- Removemos a tabela 'Estoque' e criamos esse campo
    
    id_fornecedor INT
);

CREATE TABLE Compra(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    valor           DOUBLE      NOT NULL,
    forma_pagamento VARCHAR(64) NOT NULL,
    quant_produtos  INT         NOT NULL,
    tipo_compra     ENUM('Presencial', 'Online') NOT NULL, -- Agora um enum controla o tipo de compra
    
    id_cliente INT
);

CREATE TABLE Itens(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    quant INT               NOT NULL, -- Acrescentamos o campo quantidade
    valor_total_item DOUBLE NOT NULL, -- Acrescentamos o campo do valor total do item
    
    id_compra INT,
    id_produto INT
);

CREATE TABLE Entrega(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    status_entrega VARCHAR(64) NOT NULL,
    
    id_compra INT
);

-- FKS COM ALTER ------------------------------------------------------------------------------------------------
ALTER TABLE Fornecedor 
	ADD CONSTRAINT forncedor_cidade_fk FOREIGN KEY (id_cidade) REFERENCES Cidade (id);

ALTER TABLE Cliente 
	ADD CONSTRAINT cliente_cidade_fk FOREIGN KEY (id_cidade) REFERENCES Cidade (id);

ALTER TABLE Produto 
	ADD CONSTRAINT produto_fornecedor_fk FOREIGN KEY (id_fornecedor) REFERENCES Fornecedor (id);

ALTER TABLE Compra 
	ADD CONSTRAINT compra_cliente_fk FOREIGN KEY (id_cliente) REFERENCES Cliente (id);

ALTER TABLE Itens 
	ADD CONSTRAINT itens_compra_fk FOREIGN KEY (id_compra) REFERENCES Compra (id);

ALTER TABLE Itens 
	ADD CONSTRAINT itens_produto_fk FOREIGN KEY (id_produto) REFERENCES Produto (id);

ALTER TABLE Entrega 
	ADD CONSTRAINT entrega_compra_fk FOREIGN KEY (id_compra) REFERENCES Compra (id);
-- ---------------------------------------------------------------------------------------------------------------

-- INSERTS -------------------------------------------------------------------------------------------------------
INSERT INTO Cidade (nome, UF) VALUES
	('São Paulo', 'SP'),
	('Rio de Janeiro', 'RJ'),
	('Belo Horizonte', 'MG'),
	('Viadutos', 'RS'),
	('Erechim', 'RS');
    
INSERT INTO Fornecedor (nome, descricao, tipo, id_cidade) VALUES
	('System', 'Sistemas de gestao', 'Software', 1),
	('Flores da Neusa', 'Fornecedora de flores', 'Flores', 2),
	('CyberLog', 'Seguranca da informacao', 'Software', 3);
    
INSERT INTO Cliente (nome, rua, bairro, cep, cfp, telefone, id_cidade) VALUES
	('Raquel Dagostini', 'Rua das Flores', 'Centro', '01234-567', '12345678901', '(54)9999-8888', 1),
	('Pedro Madz', 'Av. Brasil', 'Jardins', '23456-789', '23456789012', '(54)8888-7777', 2),
	('Gui Torrad', 'Rua 123', 'Dago Bairro', '34567-890', '34567890123', '(54)7777-6666', 3),
	('Danielzao', 'Av. Pedro Pinto', 'Centro', '45678-901', '45678901234', '(51)6666-5555', 4),
	('Jonas Pereira', 'Rua do Porto', 'Sao caetano', '56789-012', '56789012345', '(54)5555-4444', 5);
    
INSERT INTO Produto (tipo, preco, descricao, quantidade_em_estoque, id_fornecedor) VALUES
	('Orquidea', 150.00, 'Orquideas de todas as cores!', 50, 1),
	('Lirio', 65.50, 'Lirios de todas as cores!', 200, 1),
	('Anturio', 200.00, 'Flor legal e divertida', 15, 1),
	('Buque 5 rosas', 100.00, 'O produto perfeito para quando o amor esta no ar', 300, 1),
	('Saco de terra', 40.00, 'Saco de terra 20kg, para dar aquela aterrada no jardim!!', 100, 1);
    
INSERT INTO Compra (valor, forma_pagamento, quant_produtos, tipo_compra, id_cliente) VALUES
	(150.00, 'Cartão de Crédito', 2, 'Online', 1),
	(65.50, 'PIX', 3, 'Presencial', 2),
	(200.00, 'Cartão de Débito', 1, 'Online', 3),
	(100.00, 'Dinheiro', 4, 'Presencial', 4),
	(40.00, 'Cartão de Crédito', 2, 'Online', 5);
    
INSERT INTO Itens (quant, valor_total_item, id_compra, id_produto) VALUES
	(1, 150.00, 1, 1),
	(2, 65.50, 1, 2),
	(3, 200.50, 2, 2),
	(1, 100.00, 3, 3),
	(2, 400.00, 3, 3);
    
INSERT INTO Entrega (status_entrega, id_compra) VALUES
	('Em separação', 1),
	('Enviado', 2),
	('Entregue', 3),
	('Aguardando retirada', 4),
	('Em trânsito', 5);
-- ---------------------------------------------------------------------------------------------------------------

-- DROPS ----------------------------------------------------------------
DROP TABLE Cliente;
DROP TABLE Entrega;
DROP TABLE Cidade;
DROP TABLE Compra;
DROP TABLE Itens;
DROP TABLE Produto;
DROP TABLE Fornecedor;
-- ----------------------------------------------------------------------

-- UPDATES ---------------------------------------------------------------------------------------------------------------------
UPDATE Cidade SET nome = 'São Paulo - Capital' WHERE id = 1;
UPDATE Produto SET preco = preco * 1.10 WHERE id = 1;
UPDATE Entrega SET status_entrega = 'Entregue' WHERE id = 1;
UPDATE Cliente SET telefone = '(11)98888-7777' WHERE id = 1;
UPDATE Produto SET quantidade_em_estoque = quantidade_em_estoque - 5 WHERE id = 2;
UPDATE Compra SET forma_pagamento = 'PIX' WHERE id = 3;
UPDATE Fornecedor SET tipo = 'Sistemas' WHERE id = 1;
UPDATE Itens SET valor_total_item = 400.00 WHERE id = 1;
UPDATE Cliente SET bairro = 'Progresso', cep = '01234-000' WHERE id = 2;
UPDATE Produto SET quantidade_em_estoque = 20 WHERE id_fornecedor = 2;
UPDATE Produto SET descricao = 'Flor legal, muito cheirosa e interessante. Perfeito para emanueis amorosos' WHERE id = 1;
-- ----------------------------------------------------------------------------------------------------------------------------

-- SELECTs -----------------------------------------------------
--
SELECT * FROM Cliente 
	WHERE nome LIKE 'R%'
	ORDER BY nome;
--
SELECT * FROM Produto 
	WHERE descricao LIKE '%flor%'
	ORDER BY preco DESC;
--
SELECT * FROM Produto 
	WHERE preco BETWEEN 50 AND 150
	ORDER BY preco;
--
SELECT * FROM Compra 
	WHERE valor BETWEEN 100 AND 200
	ORDER BY valor DESC;
--
SELECT * FROM Cidade 
	WHERE UF IN ('RS', 'SP')
	ORDER BY nome;
--
SELECT * FROM Compra 
	WHERE forma_pagamento IN ('PIX', 'Cartão de Crédito')
	ORDER BY id_cliente;
--
SELECT * FROM Cidade 
	WHERE UF NOT IN ('RS')
	ORDER BY UF, nome;
--
SELECT * FROM Entrega 
	WHERE status_entrega NOT IN ('Entregue')
	ORDER BY status_entrega;
--
SELECT * FROM Fornecedor 
	WHERE nome LIKE '%Sys%'
	ORDER BY tipo, nome;
--
SELECT * FROM Itens 
	WHERE valor_total_item BETWEEN 100 AND 300
	ORDER BY valor_total_item DESC;
--
SELECT c.nome, c.telefone, cd.nome as cidade 
	FROM Cliente c 
	JOIN Cidade cd ON c.id_cidade = cd.id 
	WHERE cd.id IN (1, 3, 5)
	ORDER BY cd.nome, c.nome;
--
SELECT p.*, f.nome as fornecedor 
	FROM Produto p 
	JOIN Fornecedor f ON p.id_fornecedor = f.id 
	WHERE p.id_fornecedor NOT IN (2)
	ORDER BY f.nome, p.preco;
--
-- --------------------------------------------------------------

-- SELECTs c/ group by -----------------------------------------------------
--
SELECT c.nome as cidade, COUNT(cl.id) as total_clientes
	FROM Cidade c 
	LEFT JOIN Cliente cl ON c.id = cl.id_cidade
	GROUP BY c.id, c.nome
	ORDER BY total_clientes DESC;
--
SELECT forma_pagamento, COUNT(*) as total_compras, SUM(valor) as valor_total, AVG(valor) as valor_medio
	FROM Compra
	GROUP BY forma_pagamento
	ORDER BY valor_total DESC;
--
SELECT f.nome as fornecedor, COUNT(p.id) as total_produtos, SUM(p.quantidade_em_estoque) as estoque_total
	FROM Fornecedor f 
	LEFT JOIN Produto p ON f.id = p.id_fornecedor
	GROUP BY f.id, f.nome
	ORDER BY total_produtos DESC;
--
SELECT status_entrega, COUNT(*) as total_entregas
	FROM Entrega
	GROUP BY status_entrega
	ORDER BY total_entregas DESC;
--
SELECT tipo_compra, COUNT(*) as total_compras, AVG(valor) as valor_medio, MAX(valor) as maior_compra, MIN(valor) as menor_compra
	FROM Compra
	GROUP BY tipo_compra
	ORDER BY total_compras DESC;
--
SELECT p.tipo as produto, p.descricao, SUM(i.quant) as total_vendido, SUM(i.valor_total_item) as valor_total_vendido
	FROM Produto p 
	JOIN Itens i ON p.id = i.id_produto
	GROUP BY p.id, p.tipo, p.descricao
	ORDER BY total_vendido DESC;
--
-- -------------------------------------------------------------------------