# Tuning de Consultas SQL

Vários sistemas atuais enfrentam problemas de performance. Estes problemas podem ser de vários tipos e
causados por razões diversas, como por exemplo:

1. servidor de banco de dados com pouco poder de processamento
2. cliente de banco de dados com pouco poder de processamento
3. servidor de banco de dados com pouca memória
4. má configuração do sistema operacional
5. má distribuição física do banco de dados nos discos ou unidades de armazenamento
6. discos ou unidades de armazenamento com má performance
7. concorrência ou tráfego de rede muito intenso
8. meio físico de transmissão de dados com baixa performance
9. modelagem de dados mal feita
10. aplicação (programa) mal escrito
11. consulta (SQL) ao banco de dados mal escrita
12. falta de índices no banco de dados para agilizar a execução das consultas
13. má configuração do banco de dados
14. má configuração do sistema de middleware
15. interface de comunicação entre aplicação e banco de dados de baixa performance (Ex.:ODBC)

Portanto, uma metodologia de ajuste de performance não deve focar somente em um destes pontos, mas sim,
em todos. Uma aplicação, por exemplo, deve “nascer” objetivando uma boa performance além de atender às
necessidades de quem a solicitou. Ainda, se você for responsável por agir sobre um problema de performance
em um sistema, deve definir anteriormente os objetivos e agir primeiro sobre o que é mais crítico, que dá
mais retorno. Administradores de banco de dados, administradores de rede, analistas e programadores devem
trabalhar juntos como um time e não como adversários. Tipicamente, 20% das transações sobre bancos de
dados são responsáveis por 80% do uso do sistema, e estas transações é que devem ser o foco do trabalho.

## 1. RBO vs CBO

Antes do Oracle 10, existiam dois motores de decisão pra montar o plano de execução de uma query:

- `RBO (Rule-Based Optimizer)` — decide o caminho de acesso com base em regras fixas de prioridade (ex.: "acesso por ROWID é melhor que acesso por índice único, que é melhor que acesso por índice não-único, que é melhor que full table scan"). Não olha pra quantidade real de dados.
- `CBO (Cost-Based Optimizer)` — decide com base em estatísticas reais sobre as tabelas (quantidade de linhas, distribuição de valores, blocos ocupados) e estima o custo (leituras lógicas, CPU, tráfego de rede) de cada plano possível, escolhendo o mais barato.

A partir da versão 10 somente o CBO passou a ser usado.

Para
fins didáticos, estaremos estudando inicialmente o RBO, já que fica mais fácil entender o funcionamento e
uso de índices com este otimizador.

```sql
alter system set optimizer_mode = RULE;    -- força RBO
alter system set optimizer_mode = CHOOSE;  -- deixa o Oracle escolher CBO se houver estatísticas, senão RBO
```

## Autotrace

Ferramenta do SQL*Plus pra ver o plano de execução escolhido e estatísticas de uma consulta:

```sql
set autotrace on                       -- mostra resultado + plano + estatísticas
set autotrace off                      -- desliga
set autotrace traceonly                -- plano + estatísticas, sem mostrar as linhas do resultado
set autotrace traceonly explain        -- só o plano de execução
set autotrace traceonly statistics     -- só as estatísticas (leituras físicas/lógicas etc.)
show autotrace                         -- mostra config atual
```

- `set timing on` complementa isso mostrando o tempo real (wall-clock) de cada comando — é o que vocês usam para comparar "antes/depois" do índice de forma concreta.

## Índices

No nível mais baixo, uma tabela sem índice é apenas um amontoado de blocos de dados alocados em disco de forma desordenada. Para encontrar uma única linha, o banco precisa ler bloco por bloco (operação conhecida como Full Table Scan), jogá-los na memória cache e varrê-los sequencialmente. Isso gera um custo massivo de I/O (Estatística: physical reads).

Um índice é uma estrutura de dados secundária, ordenada, que mapeia o valor de uma coluna (ou conjunto de colunas) para o endereço físico exato da linha na tabela. Esse endereço físico é chamado de ROWID.

O que é o ROWID? > É o ponteiro de nível mais baixo que o banco de dados possui. Ele contém as informações exatas de localização da linha: o arquivo de dados, o bloco específico dentro desse arquivo e a linha exata dentro do bloco. Acessar uma linha por ROWID é a operação mais rápida possível no banco de dados.

### 2.1. Índice B-Tree (Balanced Tree)
É o tipo padrão e mais utilizado no mercado (e o principal alvo de estudo no RBO). Ele é estruturado como uma árvore balanceada invertida.

Nó Raiz (Root Node): O ponto de entrada. Contém ponteiros para os nós intermediários.

Nós de Ramificação (Branch Nodes): Direcionam a busca filtrando os intervalos de valores.

Nós Folha (Leaf Nodes): O nível mais baixo. Eles contêm a chave do índice (o valor da coluna) e o respectivo ROWID. Além disso, os nós folha são organizados como uma lista duplamente ligada (ponteiros para o próximo nó e para o nó anterior), o que torna buscas por intervalo (BETWEEN, >, <) extremamente eficientes.

Quando você executa um filtro usando uma coluna indexada por B-Tree, a busca navega verticalmente pela árvore (geralmente exigindo apenas 3 ou 4 leituras de blocos, mesmo em tabelas com milhões de registros) até encontrar o nó folha, que entrega o ROWID exato para buscar o restante dos dados na tabela.

### 2.2. Índice Bitmap
Diferente do B-Tree, o índice Bitmap é projetado para colunas com baixa cardinalidade (onde há poucos valores distintos possíveis, como Sexo, Estado_Civil, Status_Ativo).

Em vez de mapear cada linha individualmente com uma chave e um ROWID, ele cria uma representação em cadeia de bits (0 e 1) para cada valor possível da coluna.

Vantagem: Otimiza o uso de espaço e permite que o banco de dados combine múltiplos filtros usando operações lógicas bitwise (AND, OR, NOT) diretamente na memória de forma extremamente rápida.

Desvantagem Crucial: Qualquer inserção ou atualização (DML) bloqueia o bloco de bitmap inteiro, e não apenas a linha. Portanto, são péssimos para sistemas OLTP (alta concorrência de escrita) e excelentes para Data Warehouses (OLAP, leitura massiva).

## 3. Caminhos de Acesso Comuns (Access Paths)
Ao analisar o plano de execução gerado pelo AUTOTRACE, os operadores de acesso mais comuns que você verá são:

TABLE ACCESS FULL (FTS): O banco lê todos os blocos da tabela sequencialmente até a "High Water Mark" (a marca do último bloco que já conteve dados). Utiliza leitura multibloco (db_file_multiblock_read_count), o que ajuda na performance de leitura de discos, mas consome muita CPU e largura de banda de memória se a tabela for grande.

INDEX UNIQUE SCAN: Ocorre quando o otimizador busca por um valor específico em uma coluna que possui uma restrição de unicidade (PRIMARY KEY ou UNIQUE). O banco sabe que vai encontrar, no máximo, uma única linha. Para na primeira correspondência.

INDEX RANGE SCAN: Ocorre quando o banco busca por valores em um índice não-único ou usa operadores de intervalo (ex: WHERE id > 100). O motor navega até o primeiro registro correspondente no nó folha e continua lendo horizontalmente os nós folha seguintes até o critério deixar de ser atendido.

TABLE ACCESS BY INDEX ROWID: Quase sempre aparece logo após um scan de índice. Significa que o banco pegou os ROWIDs encontrados no nó folha do índice e foi até os blocos da tabela física buscar as outras colunas que você colocou no SELECT (e que não faziam parte do índice).
