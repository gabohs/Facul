# Recycle Bin

Quando eliminamos uma tabela, o banco de dados não remove imediatamente a tabela, e sim:

- renomeia a tabela para um nome interno no formato `BIN$xxxxxxxxxxxxxxxxxxxxx==$0` e a coloca na lixeira junto com seus objetos associados (índices, por exemplo), para fins de recuperação.
- move essa entrada para a "lixeira" (recycle bin), que é só um registro lógico no dicionário de dados — os dados físicos continuam no mesmo tablespace, ocupando o mesmo espaço

Ou seja: espaço em disco não é liberado imediatamente. A tabela some da visão normal (user_tables), mas ainda existe e pode ser restaurada.

O Recycle Bin é por usuário/esquema — cada schema tem sua própria lixeira, visível via user_recyclebin

## Pra que serve

É uma rede de segurança contra erro humano: "apaguei a tabela errada" ou "preciso desfazer esse DROP" sem precisar recorrer a um backup completo/recovery, que é muito mais lento e trabalhoso. Resolve só o caso de DROP acidental — não substitui backup pra outros tipos de perda de dados.

## Consultar o que esta na lixeira

```sql
select object_name, original_name, type, droptime
from user_recyclebin;
```

ou pela interface gráfica: Apex → Utilities → Recycle Bin

## Restaurar uma tabela da lixeira:

```sql
flashback table CONTROLE to before drop;
```

Tambem da pra fazer pela interface grafica, clicando em restore

## Apagar definitivamente

```sql
drop table CONTROLE purge;          -- remove direto, sem ir pra lixeira
purge table CONTROLE;               -- esvazia da lixeira uma tabela já dropada
purge recyclebin;                   -- esvazia toda a lixeira do usuário atual
```

