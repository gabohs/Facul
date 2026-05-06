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
    FILIAL   number not null,
    CONSTRAINT PK_PEDIDO primary key (COD_PED),
    CONSTRAINT FK_CLI_PED foreign key (COD_CLI) REFERENCES cliente(COD_CLI)
);

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

INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (11, 112, 1, 9);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (11, 118, 2, 5);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (12, 120, 1, 3);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (12, 119, 2, 1);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (12, 111, 3, 2);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (13, 113, 1, 6);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (13, 115, 2, 7);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (13, 120, 3, 3);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (13, 119, 4, 9);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (13, 111, 5, 8);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (14, 120, 1, 6);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (15, 117, 1, 7);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (15, 116, 2, 5);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (16, 115, 1, 6);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (16, 114, 2, 6);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (16, 113, 3, 2);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (16, 111, 4, 3);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (17, 117, 1, 1);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (17, 112, 2, 4);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (18, 112, 1, 5);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (19, 120, 1, 3);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (19, 115, 2, 4);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (20, 111, 1, 5);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (21, 111, 1, 4);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (21, 112, 2, 7);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (22, 119, 1, 2);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (22, 118, 2, 3);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (22, 117, 3, 1);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (23, 115, 1, 2);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (23, 111, 2, 4);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (23, 112, 3, 3);
INSERT INTO item_pedido (COD_PED, COD_PROD, NUM_ITEM, QTDE) VALUES (24, 113, 1, 2);

COMMIT; 

set serverout on

-- TRIGGER

-- tabela auxiliar
create table historico_atualizacao (
    COD_CLI              number not null,
    RAZAO_SOCIAL_ANTIGA  varchar2(255),
    RAZAO_SOCIAL_NOVA    varchar2(255),
    NOME_FANTASIA_ANTIGO varchar2(255),
    NOME_FANTASIA_NOVO   varchar2(255),
    DATA_ALTERACAO       date DEFAULT SYSDATE not null,
);

-- trigger de fato:

CREATE OR REPLACE TRIGGER t_historico_att_campos
AFTER UPDATE OF RAZAO_SOCIAL, NOME_FANTASIA ON cliente
FOR EACH ROW
BEGIN
    IF :OLD.RAZAO_SOCIAL != :NEW.RAZAO_SOCIAL or :OLD.NOME_FANTASIA != :NEW.NOME_FANTASIA THEN
        insert into historico_atualizacao (COD_CLI, RAZAO_SOCIAL_ANTIGA, RAZAO_SOCIAL_NOVA, NOME_FANTASIA_ANTIGO, NOME_FANTASIA_NOVO, DATA_ALTERACAO)
                                   values (:OLD.COD_CLI, :OLD.RAZAO_SOCIAL, :NEW.RAZAO_SOCIAL, :OLD.NOME_FANTASIA, :NEW.NOME_FANTASIA, sysdate);
    END IF;
END;
/

-- PROCEDURE

CREATE OR REPLACE PROCEDURE p_filial_inexistente (v_num_filial number) as 
    CURSOR pedidos_filial_invalida IS
        select *
        from pedido
        where FILIAL not in (1, 2, 3);
BEGIN
    dbms_output.put_line('PEDIDOS COM FILIAL INVALIDA:');
    FOR rec IN pedidos_filial_invalida
    LOOP
        dbms_output.put_line('COD_PED: ' || to_char(rec.COD_PED) || '  COD_CLI: ' || to_char(rec.COD_CLI) || '  FILIAL (inv.): ' || to_char(rec.FILIAL));
        dbms_output.new_line;
    END LOOP;

END;
/

FIM_SQLPLUS
