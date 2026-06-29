# Flash Back Queries

Permite "viajar no tempo" dentro dos dados de uma tabela, sem precisar de backup nem recovery — só consultando uma versão passada dela diretamente com SQL.

É útil para saber, por exemplo, a
posição de determinado campo antes de alguma exclusão ou alteração acidental acontecer. Acrescentamos,
para isso, uma cláusula à sentença SQL que nos permite especificar o momento no passado ao qual queremos
retornar, ou ao SCN do banco de dados ao qual queremos voltar.

Quando você faz UPDATE/DELETE num Oracle, a versão anterior da linha não é destruída imediatamente — ela fica guardada por um tempo no UNDO tablespace (a mesma estrutura que sustenta o ROLLBACK e o read consistency que vimos no consistent=y do export). O Flashback Query simplesmente aproveita esse mecanismo já existente: em vez de usar o UNDO só internamente pra desfazer transações, o Oracle deixa você consultá-lo diretamente via SQL, apontando para um instante no passado.

Isso só funciona dentro da janela de retenção do UNDO (parâmetro UNDO_RETENTION do banco, geralmente minutos a poucas horas, dependendo da configuração). Não dá pra voltar "ao ano passado" — é uma ferramenta pra correção de erro recente, não um substituto de backup de longo prazo.

```sql
select *
from ESTOQUE
as of timestamp to_timestamp('2023-05-18 10:27:00', 'YYYY-MM-DD HH24:MI:SS');
```

