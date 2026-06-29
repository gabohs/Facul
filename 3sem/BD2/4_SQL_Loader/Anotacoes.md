# SQL Loader

Quando for necessário carregar dados de sistemas legados ou mesmo programas cuja interface com o mundo
externo pode existir somente através de arquivos-texto, faz-se necessária a utilização de uma ferramenta
capaz de realizar este processo. O banco Oracle possui o aplicativo SQL Loader.

O SQL Loader (sqlldr) é o utilitário Oracle para carregar dados de arquivos-texto externos para dentro de tabelas do banco

Ele trabalha com um arquivo de configuração chamado controlfile, que mapeia os dados de entrada para
algum formato na saída (tabela do banco de dados). Gera um arquivo de log com o registro da carga dos
dados, um arquivo com os registros que, por uma ou outra razão, não foram carregados ao banco de dados, e
um arquivo contendo todos os registros que também não foram carregados mas porque não atenderam ao
filtro WHEN quando este for usado. Estes últimos são chamados de registros descartados, ou discarded
records.

## SQLLoader vs exp e imp

- `exp/imp` trabalham com o formato proprietário Oracle (.dmp) — servem para mover dados entre bancos Oracle.

- `sqlldr` lê arquivos-texto comuns (CSV, posição fixa, delimitado, etc.) — serve para trazer dados de fora do mundo Oracle: sistemas legados, planilhas exportadas, dispositivos de hardware, integrações com outros sistemas, qualquer coisa que só consiga "falar" via arquivo plano.

## O Comando

```bash
sqlldr control=carga.ctl userid=pos/pos data=dados.txt log=carga.log bad=carga.bad discard=carga.dis
```

- `control=carga.ctl` — qual control file usar (define o "como")
- `userid=pos/pos` — mesma lógica do exp/imp: usuário/senha de conexão, e é o esquema dono da tabela de destino
- `data=dados.txt` — qual arquivo contém os dados a carregar
- `log=carga.log` — onde registrar o resultado do processamento
- `bad=carga.bad` — onde gravar linhas rejeitadas por erro
- `discard=carga.dis` — onde gravar linhas descartadas pela cláusula WHEN

## Arquivos envolvidos

<table class="min-w-full border-collapse text-sm leading-[1.7] whitespace-normal"><thead class="text-left"><tr><th scope="col" class="text-text-100 border-b-0.5 border-[hsl(var(--border-300)/0.6)] py-2 pr-4 align-top font-bold">Arquivo</th><th scope="col" class="text-text-100 border-b-0.5 border-[hsl(var(--border-300)/0.6)] py-2 pr-4 align-top font-bold">Papel</th><th scope="col" class="text-text-100 border-b-0.5 border-[hsl(var(--border-300)/0.6)] py-2 pr-4 align-top font-bold">Quem gera</th></tr></thead><tbody><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">.ctl</code> (control file)</td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">Define <strong>como</strong> ler o arquivo de entrada: layout das colunas, delimitadores, mapeamento pra tabela/colunas de destino</td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">Você escreve antes</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">.txt</code> (data file)</td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">Os dados em si, em texto puro</td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">Vem do sistema externo</td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">.log</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">Log do processamento — quantas linhas lidas, quantas carregadas, erros</td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">Gerado pelo <code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">sqlldr</code></td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">.bad</code></td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">Linhas que <strong>falharam</strong> ao carregar (ex.: violação de constraint, coluna obrigatória nula, tipo incompatível)</td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">Gerado pelo <code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">sqlldr</code></td></tr><tr><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top"><code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">.dis</code> (discard)</td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">Linhas que foram <strong>descartadas intencionalmente</strong> porque não satisfizeram a cláusula <code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">WHEN</code> do control file (não é erro, é um filtro proposital)</td><td class="border-b-0.5 border-[hsl(var(--border-300)/0.3)] py-2 pr-4 align-top">Gerado pelo <code class="bg-text-200/5 border border-0.5 border-border-300 text-danger-000 whitespace-pre-wrap rounded-[0.4rem] px-1 py-px text-[0.9rem]">sqlldr</code></td></tr></tbody></table>

## Control File (.ctl)

Esse é o coração do processo — é nele que você diz pro sqlldr:

- qual tabela é o destino
- como o arquivo de dados está delimitado (vírgula, posição fixa, etc.)
- como cada campo do arquivo mapeia pra cada coluna da tabela
- opcionalmente, condições WHEN para filtrar quais linhas carregar