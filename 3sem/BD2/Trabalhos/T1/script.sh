# Precisamos executar os comandos no sqlplus:
sqlplus system/123 << FIM_SQLPLUS

-- Criar user
CREATE USER prod IDENTIFIED BY prod DEFAULT TABLESPACE users;
GRANT CONNECT, RESOURCE TO prod;

conn prod/prod

-- Tabelas

drop table cliente;
CREATE TABLE cliente (
    COD_CLI       number not null,
    RAZAO_SOCIAL  varchar2(255) not null,
    NOME_FANTASIA varchar2(255) not null,

    CONSTRAINT PK_CLIENTE primary key (COD_CLI)
);

drop table pedido;
CREATE TABLE pedido (
    COD_PED  number not null,
    COD_CLI  number not null,
    FILIAL   varchar2(255) not null,

    CONSTRAINT PK_PEDIDO primary key (COD_PED),

    CONSTRAINT FK_CLI_PED foreign key (COD_CLI) REFERENCES cliente(COD_CLI)
)

drop table produto;
CREATE TABLE produto (
    COD_PROD  number not null,
    DESCRICAO varchar2(255) not null,
    VALOR     number(10, 2) not null,

    CONSTRAINT PK_PRODUTO primary key (COD_PROD)
);

drop table item_pedido;
CREATE TABLE item_pedido (
    COD_PED  number not null,
    COD_PROD number not null,
    NUM_ITEM number not null,
    QTDE     number not null,

    CONSTRAINT PK_ITEM_PEDIDO primary key (COD_PED),
    CONSTRAINT PK_ITEM_PEDIDO primary key (COD_PROD),
    CONSTRAINT PK_ITEM_PEDIDO primary key (NUM_ITEM),

    CONSTRAINT FK_ITEMPEDIDO_PEDIDO foreign key (COD_PED) REFERENCES pedido (COD_PED),

    CONSTRAINT FK_ITEMPEDIDO_PRODUTO foreign key (COD_PROD) REFERENCES produto (COD_PROD)
);

INSERT INTO cliente (COD_CLI, RAZAO_SOCIAL, NOME_FANTASIA) VALUES (1, 'Cliente Um', 'Lojas Um');
INSERT INTO cliente (COD_CLI, RAZAO_SOCIAL, NOME_FANTASIA) VALUES (2, 'Cliente Dois', 'Magazine Dois');
INSERT INTO cliente (COD_CLI, RAZAO_SOCIAL, NOME_FANTASIA) VALUES (3, 'Cliente Tres', 'Hipermercado Tres');
INSERT INTO cliente (COD_CLI, RAZAO_SOCIAL, NOME_FANTASIA) VALUES (4, 'Cliente Quatro', 'Atacadao Quatro');
INSERT INTO cliente (COD_CLI, RAZAO_SOCIAL, NOME_FANTASIA) VALUES (5, 'Cliente Cinco', 'Distribuidora Cinco');

INSERT INTO pedido (COD_PED, COD_CLI, FILIAL) VALUES (11, 2, 3);
INSERT INTO pedido (COD_PED, COD_CLI, FILIAL) VALUES (12, 4, 1);
INSERT INTO pedido (COD_PED, COD_CLI, FILIAL) VALUES (13, 5, 2);
INSERT INTO pedido (COD_PED, COD_CLI, FILIAL) VALUES (14, 3, 2);
INSERT INTO pedido (COD_PED, COD_CLI, FILIAL) VALUES (15, 4, 1);
INSERT INTO pedido (COD_PED, COD_CLI, FILIAL) VALUES (16, 2, 3);
INSERT INTO pedido (COD_PED, COD_CLI, FILIAL) VALUES (17, 1, 1);
INSERT INTO pedido (COD_PED, COD_CLI, FILIAL) VALUES (18, 2, 3);
INSERT INTO pedido (COD_PED, COD_CLI, FILIAL) VALUES (19, 4, 1);
INSERT INTO pedido (COD_PED, COD_CLI, FILIAL) VALUES (20, 1, 1);
INSERT INTO pedido (COD_PED, COD_CLI, FILIAL) VALUES (21, 5, 2);
INSERT INTO pedido (COD_PED, COD_CLI, FILIAL) VALUES (22, 3, 5);
INSERT INTO pedido (COD_PED, COD_CLI, FILIAL) VALUES (23, 5, 2);
INSERT INTO pedido (COD_PED, COD_CLI, FILIAL) VALUES (24, 3, 4);

INSERT INTO produto (COD_PROD, DESCRICAO, VALOR) VALUES (111, 'Silicone Incolor 300g', 12.00);
INSERT INTO produto (COD_PROD, DESCRICAO, VALOR) VALUES (112, 'Cimento Portland CP II 50Kg', 28.00);
INSERT INTO produto (COD_PROD, DESCRICAO, VALOR) VALUES (113, 'Tijolo ceramico 6 furos', 1.20);
INSERT INTO produto (COD_PROD, DESCRICAO, VALOR) VALUES (114, 'Telha ceramica tipo romana', 3.50);
INSERT INTO produto (COD_PROD, DESCRICAO, VALOR) VALUES (115, 'Tinta acrilica branca 18L', 230.0);
INSERT INTO produto (COD_PROD, DESCRICAO, VALOR) VALUES (116, 'Rejunte ceramico', 9.50);
INSERT INTO produto (COD_PROD, DESCRICAO, VALOR) VALUES (117, 'Argamassa ACI 20Kg', 22.00);
INSERT INTO produto (COD_PROD, DESCRICAO, VALOR) VALUES (118, 'Interruptor simples de embutir', 12.00);
INSERT INTO produto (COD_PROD, DESCRICAO, VALOR) VALUES (119, 'Tubo PVC soldavel 25mm 6m', 32.00);
INSERT INTO produto (COD_PROD, DESCRICAO, VALOR) VALUES (120, 'Fechadura externa padrao', 95.00);


COMMIT; 

-- TRIGGER



-- PROCEDURE




FIM_SQLPLUS
