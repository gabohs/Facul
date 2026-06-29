# EXERCICIOS DE VIEWS

### 1.Criar uma view chamada VCLITEL que selecione somente os campos COD_CLIENTE, RAZAO_SOCIAL e TELEFONE da tabela CLIENTE.

```sql
create or replace view VCLITEL as
select 	cli.cod_cliente CODCLI, 
	cli.razao_social RS, 
	cli.telefone TF
from cliente cli;
```


### 2. Criar uma view chamada VPRODINAT que seleciona todos os códigos de produtos com suas descrições e suas quantidades para todos os produtos que estejam inativos.

```sql
-- select distinct ativo from produto;

create or replace view VPRODINAT as
select prod.cod_produto,
       prod.descricao,
       est.qtde
from produto prod, estoque est
where prod.cod_produto = est.cod_produto AND prod.ATIVO = 'N';
```


### 3. Criar uma view chamada VFAT_AL_BIM1_2004 que selecione a data da venda, o código do cliente, arazão social dele, o código do produto, a descrição do produto e a quantidade vendida de todas as vendas realizadas por clientes de AL no primeiro bimestre de 2004 ordenando por data de venda de forma descendente;

```sql
create or replace view VFAT_AL_BIM1_2004 as
select vda.data_venda,
       vda.cod_cliente,
       cli.razao_social,
       prod.cod_produto,
       prod.descricao,
       vda.qtde
from venda vda, cliente cli, produto prod, cidade cid
where vda.cod_produto = prod.cod_produto AND 
      vda.cod_cliente = cli.cod_cliente  AND 
      cli.cod_cidade = cid.cod_cidade    AND
      cid.uf = 'AL'                      AND
      vda.data_venda BETWEEN to_date('01-JAN-04 00:00:00', 'dd-mon-yy hh24:mi:ss') and to_date('29-FEB-04 23:59:59', 'dd-mon-yy hh24:mi:ss')
order by vda.data_venda DESC;
```


### 4. Criar uma view chamada VFAT_NE_JAN2024 que mostre os mesmos dados da view anterior, porém somente para clientes de AL, PE, CE e RN e que tenham comprado produtos que estejam atualmente com estoque entre 0 e 5 unidades e cuja compra foi realizada em janeiro de 2024, em ordem descendente de data, e dentro do dia em ordem ascendente de razão social.

```sql
create or replace view VFAT_NE_JAN2024 as
select vda.data_venda,
       vda.cod_cliente,
       cli.razao_social,
       prod.cod_produto,
       prod.descricao,
       vda.qtde
from venda vda, cliente cli, produto prod, cidade cid, estoque est
where vda.cod_produto = prod.cod_produto 		 AND 
      vda.cod_cliente = cli.cod_cliente  		 AND 
      cli.cod_cidade = cid.cod_cidade      		 AND
      cid.uf in ('AL', 'PE', 'CE', 'RN') 		 AND
      est.cod_produto = prod.cod_produto 		 AND
      vda.data_venda BETWEEN '01-JAN-24' and '31-JAN-24' AND
      est.qtde BETWEEN 0 and 5
order by vda.data_venda DESC, cli.razao_social ASC;
```


### 5. Alterar a view anterior para incluir somente produtos cujas vendas foram maiores de 5 unidades
mostrando a quantidade atual de estoque também no select.

```sql
create or replace view VFAT_NE_JAN2024 as
select vda.data_venda,
       vda.cod_cliente,
       cli.razao_social,
       prod.cod_produto,
       prod.descricao,
       vda.qtde as qtde_vendida,
       est.qtde as qtde_estoque
from venda vda, cliente cli, produto prod, cidade cid, estoque est
where vda.cod_produto = prod.cod_produto 		 AND 
      vda.cod_cliente = cli.cod_cliente  		 AND 
      cli.cod_cidade = cid.cod_cidade      		 AND
      cid.uf in ('AL', 'PE', 'CE', 'RN') 		 AND
      est.cod_produto = prod.cod_produto 		 AND
      vda.data_venda BETWEEN '01-JAN-24' and '31-JAN-24' AND
      vda.qtde > 5               
order by vda.data_venda DESC, cli.razao_social ASC;
```


### 6. O usuário POS precisa acessar todas essas views exatamente com o nome abaixo. São elas:

```
VCLITEL
VPRODINAT
VFAT_AL_BIM1_2004
VFAT_NE_JAN2024
```

### Para isso, crie sinônimos no usuários POS para acesso às referidas views. Lembre-se que para isso o
usuário POS precisa ter privilégio de acesso às tabelas e às views.

```sql
grant select on VCLITEL to pos;
grant select on VPRODINAT to pos;
grant select on VFAT_AL_BIM1_2004 to pos;
grant select on VFAT_NE_JAN2024 to pos;
```

```bash
conn pos/pos
```

```sql
create synonym VCLITEL for eor.VCLITEL;
create synonym VPRODINAT for eor.VPRODINAT;
create synonym VFAT_AL_BIM1_2004 for eor.VFAT_AL_BIM1_2004;
create synonym VFAT_NE_JAN2024 for eor.VFAT_NE_JAN2024;
```

## OU

```
conn system/123
```
```sql
grant select on eor.VCLITEL to pos;
grant select on eor.VPRODINAT to pos;
grant select on eor.VFAT_AL_BIM1_2004 to pos;
grant select on eor.VFAT_NE_JAN2024 to pos;

create synonym pos.VCLITEL for eor.VCLITEL;
create synonym pos.VPRODINAT for eor.VPRODINAT;
create synonym pos.VFAT_AL_BIM1_2004 for eor.VFAT_AL_BIM1_2004;
create synonym pos.VFAT_NE_JAN2024 for eor.VFAT_NE_JAN2024;
```






