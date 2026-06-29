# Exportação e Importação de dados

Os utilitários de exportação e importação de dados geram arquivos em formato proprietário para transferência
de informações entre diferentes esquemas do mesmo banco de dados, diferentes bancos de dados, ou mesmo
para backup e recovery. É possível exportar, ou fazer uma cópia, de qualquer tabela do banco de dados.

Índices, apesar de ocuparem espaço físico no banco de dados, têm somente seu comando de criação exportado, obrigando o utilitário a recriá-lo no banco de destino. O mesmo acontece com as constraints. Elas não ocupam espaço no banco de dados. Apenas representam restrições obrigatórias a serem respeitadas.

Visões, da mesma forma, têm apenas exportado seu código SQL. Não ocupam espaço físico. Estes utilitários
também permitem exportar ou importar um banco de dados inteiro. Por isso são quase sempre usados como
complemento do backup físico ou, às vezes, dependendo do caso, como única forma de backup de um banco
de dados.

Resumindo, quando você exporta uma tabela, a definição completa (DDL) vai junto com os dados. Mas índices e constraints não ocupam espaço físico — só o comando CREATE INDEX / a definição da constraint é exportado, e o utilitário recria isso no destino. Views também só levam o código SQL, nunca dado físico.

## Comandos `exp` e `imp`

`exp` e `imp` são utilitários de linha de comando do Oracle para fazer backup lógico (diferente de backup físico, que copia os arquivos do datafile diretamente). Eles leem/escrevem em um formato proprietário binário (o arquivo .dmp), e servem para:

- Mover dados entre esquemas (usuários) do mesmo banco
- Mover dados entre bancos diferentes
- Fazer backup/restore lógico
- Migrar estrutura + dados, ou só estrutura, ou só dados

```bash
exp usuario/senha file=arquivo.dmp [outros parâmetros]
imp usuario/senha file=arquivo.dmp [outros parâmetros]
```

| ARQUIVO | O que é |
| --- | --- |
| `.dmp` | O dump propriamente dito — formato binário proprietário, contém DDL + dados |
| `.log` (param LOG) | Log de texto do que aconteceu durante o export/import (sucesso, erros, contagem de linhas) |
| `.txt` (param INDEXFILE) | Quando usado no imp, não importa nada — só gera um arquivo de texto com as DDLs (CREATE TABLE, CREATE INDEX, constraints) extraídas do dump |
| `exppar.txt` / qualquer nome (param PARFILE) | Arquivo de texto puro com parâmetros, um por linha (param=valor), pra não precisar digitar tudo na linha de comando |

### Export simples + import simples, com log

```bash
exp pos/pos file=TableCli.dmp log=TableCli.log tables=tclientes
imp dest1/dest1 file=TableCli.dmp log=TableCliIMP.log tables=tclientes
```

o export gera o TableCli.dmp com os dados do user pos, e o imp importa esses dados para o user dest1 atraves do arquivo dmp gerado

- `tables=`: filtra quais tabelas exportar/importar (pode ser lista separada por vírgula). Use `*` para selecionar todas

### Buffer e commit incremental

```bash
exp pos/pos file=TablesNF.dmp tables=tnfs_saida, titens_nfs
imp dest1/dest1 file=TablesNF.dmp tables=* buffer=5000000 commit=y
```

- `tables=*` no import quando o dump já tem só as tabelas que você quer — importa todas as que estão no arquivo.
- `buffer=5000000` define 5MB de área de memória usada para ler/escrever linhas durante o processo.
- `commit=y` faz o Oracle comitar a transação cada vez que o buffer enche, em vez de só no final. Isso é importante para tabelas grandes (como TITENS_NFS, com 386 mil linhas): sem isso, o UNDO tablespace pode crescer demais ou a transação fica gigante e arriscada.

### Excluindo grants, índices e constraints

```bash
exp pos/pos file=TblEstab.dmp grants=n indexes=n constraints=n tables=testabelecimentos
imp dest1/dest1 file=TblEstab.dmp tables=*
```

- `grants=n `: não leva privilégios concedidos sobre o objeto.
- `indexes=n`: não leva a definição dos índices.
- `constraints=n`: não leva constraints (PK, FK, unique, check).

```bash
exp pos/pos file=TblEmpresas.dmp tables=tempresas rows=n indexes=y grants=y constraints=y
imp dest1/dest1 file=TblEmpresas.dmp tables=tempresas
```

- `rows=n`: exporta só a estrutura, sem nenhuma linha de dado. Útil para clonar o "esqueleto" de uma tabela em outro ambiente (ex.: preparar um ambiente de teste vazio).

- Repare que `indexes=y, grants=y, constraints=y` aqui são na verdade os defaults (não seria necessário escrevê-los), mas o exercício deixa explícito por didática.

### Export/import de usuário inteiro, consistente, com feedback

```bash
exp system/123 owner=dest1 consistent=y file=UserDest1.dmp
imp system/123 fromuser=dest1 touser=dest2 feedback=10000 file=UserDest1.dmp
```

- `owner=dest1`: exporta todos os objetos pertencentes ao usuário dest1 (em vez de listar tabela por tabela).
- `consistent=y`: garante que a exportação seja um "snapshot" coerente do banco em um único ponto no tempo, mesmo que outras transações estejam alterando dados durante o processo (isso usa o mecanismo de read consistency do Oracle, baseado em UNDO).
- Note que aqui quem executa é `system/123` (superusuário), não o próprio dono dos dados — porque precisa de privilégio pra acessar objetos de outro esquema.
- `fromuser=dest1 touser=dest2`: no import, isso faz o remapeamento de esquema: tudo que era do dest1 no dump é recriado sob o dest2.
- `feedback=10000`: imprime um indicador de progresso (geralmente um ponto) a cada 10.000 linhas importadas. Puramente cosmético/monitoramento, não afeta o resultado.

### Gerando script DDL a partir do dump (sem importar nada)

```bash
exp pos/pos file=Paises.dmp log=Paises.log tables=tpaises
imp system/123 tables=* file=Paises.dmp indexfile=DDLs.txt
pg DDLs.txt
```

- quando você passa `indexfile=DDLs.txt` no imp, o import não importa nada de fato — ele só lê o dump e escreve num arquivo de texto todas as instruções DDL (CREATE TABLE, CREATE INDEX etc.) que estariam embutidas naquele dump.
- É uma forma de "engenharia reversa": extrair a estrutura SQL de uma tabela só a partir do seu backup lógico.
- `pg` é só o paginador de texto do Unix (parecido com more/less) para visualizar o conteúdo do arquivo gerado.

### Export/import de usuário sem dados e sem estatísticas

```bash
exp system/123 file=UserDest2.dmp owner=dest2 log=UserDest2.log
imp system/123 fromuser=dest2 touser=dest3 rows=n file=UserDest2.dmp
```

- `rows=n` aqui no import (diferente do exercício 4, que era no export) — significa que mesmo que o dump tenha os dados, o import vai ignorar as linhas e recriar só a estrutura.
- Note que não tem `statistics=n` explícito no exp aqui — mas o exercício descreve a intenção (sem estatísticas); na prática, statistics controla se as estatísticas do otimizador de consultas (cardinalidade, distribuição de valores) são levadas junto.


### Import seletivo de uma tabela específica a partir de um dump de usuário inteiro

```bash
imp system/123 fromuser=dest2 touser=dest3 file=UserDest2.dmp tables=tclientes log=ImpCli.log
imp system/123 fromuser=dest2 touser=dest3 file=UserDest2.dmp tables=tclientes log=ImpCli.log ignore=y
```

- Mostra que mesmo um dump de usuário inteiro pode ser usado pra importar só uma tabela (`tables=tclientes`), sem precisar reexportar.
- `ignore=y`: ignora erros de objeto já existente (não tenta recriar a tabela) e tenta inserir os dados mesmo assim. Se houver violação de chave única/primária nas linhas, essas linhas específicas falham, mas o resto segue.

### Backup completo do banco

```bash
exp system/123 file=BkpBD.dmp log=BkpBD.log full=y consistent=y
```

- `full=y` — exporta o banco de dados inteiro, todos os esquemas, não só um usuário.
- Combinado com `consistent=y`, é literalmente um backup lógico completo e coerente.

### Arquivo de parâmetros (parfile)

```
owner=Pos,Dest1,Dest2,Dest3,Dest4
file=Dados.dmp
log=Dados.log
buffer=4000000
```

```bash
exp system/123 parfile=exppar.txt
```

- Em vez de passar tudo na linha de comando, você escreve os parâmetros num arquivo texto puro e referencia com `parfile=`

## Parametros mais usados

<table class="min-w-full border-collapse text-sm leading-[1.7] whitespace-normal"><thead class="text-left"><tr><th scope="col" class="text-text-100 border-b-0.5 border-[hsl(var(--border-300)/0.6)] py-2 pr-4 align-top font-bold">Parâmetro</th><th scope="col" class="text-text-100 border-b-0.5 border-[hsl(var(--border-300)/0.6)] py-2 pr-4 align-top font-bold">Função</th></tr></thead><tbody><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">file</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">nome do arquivo <code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">.dmp</code></td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">log</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">nome do arquivo de log</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">tables</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">lista de tabelas a exportar/importar</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">owner</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">exporta tudo de um (ou mais) esquema(s)</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">fromuser</code>/<code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">touser</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">remapeia esquema de origem → destino no import</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">rows=y/n</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">leva ou não os dados (linhas)</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">indexes=y/n</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">leva ou não definição de índices</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">constraints=y/n</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">leva ou não constraints</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">grants=y/n</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">leva ou não privilégios concedidos</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">statistics</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">leva ou não estatísticas do otimizador</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">buffer</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">tamanho do buffer de memória em bytes</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">commit=y/n</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">comita a cada buffer cheio (import)</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">consistent=y/n</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">garante snapshot coerente no momento do export</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">feedback=N</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">mostra progresso a cada N linhas</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">ignore=y/n</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">ignora erro de objeto já existente no destino</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">indexfile</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">gera só as DDLs em texto, não importa nada</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">full=y</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">export/import do banco inteiro</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">parfile</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">arquivo de texto com parâmetros</td></tr></tbody></table>

