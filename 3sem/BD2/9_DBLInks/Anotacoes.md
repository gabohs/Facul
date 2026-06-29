# Database Links

Um database link é um objeto do Oracle que cria uma "ponte" de conexão para acessar objetos (tabelas, views) de outro esquema/usuário, seja no mesmo banco, seja em um banco remoto totalmente diferente — desde que exista rede e permissão entre os servidores. Uma vez criado, você referencia uma tabela remota como se fosse local, só adicionando @nome_do_link no final do nome.

```sql
create database link DL1
    connect to MATRIZ identified by MATRIZ
    using 'BD1';
```

- `DL1` — nome do link (objeto local, do esquema filial1)
- `connect to MATRIZ identified by MATRIZ` — credenciais usadas na máquina remota: o link vai se autenticar lá como usuário MATRIZ, senha MATRIZ — não usa a sua sessão atual
- `using 'BD1'` — qual string de conexão do tnsnames.ora usar pra achar o host/porta/serviço

## Operacoes sobre DBLinks

```sql
desc pedido@dl1;

insert into PEDIDO@DL1 (CODPED, CODCLI, CODPROD, QTDE, DATA, FILIAL)
values (999, 10, 35, 50.8, sysdate, 1);
commit;

delete from PEDIDO@DL1 where CODPED=999;
commit;
```

o link não serve só para SELECT. Você faz DESC, INSERT, DELETE, COMMIT normalmente, como se a tabela remota fosse local.

## Sinonimos

```sql
create synonym PED for PEDIDO@DL1;

insert into PED (CODPED, CODCLI, CODPROD, QTDE, DATA, FILIAL)
values (999, 10, 35, 50.8, sysdate, 1);
commit;

delete from PED where CODPED=999;
commit;
```

