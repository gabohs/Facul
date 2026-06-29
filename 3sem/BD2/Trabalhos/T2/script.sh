sqlplus system/123 << FIM_SQLPLUS

CREATE USER filiala IDENTIFIED BY filiala DEFAULT TABLESPACE users;
GRANT CONNECT, RESOURCE TO filiala;
GRANT CREATE SNAPSHOT TO filiala;

CREATE USER filialb IDENTIFIED BY filialb DEFAULT TABLESPACE users;
GRANT CONNECT, RESOURCE TO filialb;
GRANT CREATE SNAPSHOT TO filialb;

GRANT SELECT ON prod.pedido TO filiala;
GRANT SELECT ON prod.item_pedido TO filiala;
GRANT SELECT ON prod.pedido TO filialb;
GRANT SELECT ON prod.item_pedido TO filialb;

-- Criando os snapshots

-- Filial A
conn filiala/filiala

create snapshot pedido
refresh complete
as
select * 
from prod.pedido 
where filial = 1;

create snapshot item_pedido
refresh complete
as
select ip.cod_ped, ip.cod_prod, ip.num_item, ip.qtde
from prod.item_pedido ip, prod.pedido p
where ip.cod_ped = p.cod_ped AND p.filial = 1;


-- Filial B
conn filialb/filialb

create snapshot pedido
refresh complete
as
select * from prod.pedido where filial = 2;

create snapshot item_pedido
refresh complete
as
select ip.cod_ped, ip.cod_prod, ip.num_item, ip.qtde
from prod.item_pedido ip, prod.pedido p
where ip.cod_ped = p.cod_ped AND p.filial = 2;


-- Registrando as snapshots

conn filiala/filiala
var a NUMBER;
BEGIN
  dbms_job.submit(:a,
    'dbms_snapshot.refresh(''pedido, item_pedido'', ''C'');',
    sysdate + 1/1440,
    'sysdate + 3/1440');
END;
/

conn filialb/filialb
var b NUMBER;
BEGIN
  dbms_job.submit(:b,
    'dbms_snapshot.refresh(''pedido, item_pedido'', ''C'');',
    sysdate + 1/1440,
    'sysdate + 3/1440');
END;
/
COMMIT;



commit;







FIM_SQLPLUS