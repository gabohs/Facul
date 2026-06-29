# Shell Scripts

Um shell script é um script escrito para o shell, ou seja, o interpretador de linha de comando do sistema
operacional. Com um shell script (termo usualmente associado ao Linux e ao Unix) ou programa de lote
(termo usualmente associado ao Windows), podemos automatizar tarefas rotineiras que precisam se repetir,
como por exemplo:

- rotinas de backup
- processos de limpeza semanal, diária ou mensal de diretórios
- consultas a bancos de dados que precisam ser executadas diariamente e,
possivelmente, terem suas saídas ou dados enviados para o email do usuário
- interfaces entre sistemas distintos, etc ...

### chmod

- Comando que altera as permissoes do arquivo

para ver as permissoes:

```bash
ls -l
```

Retorna algo como:

```
-rwxr-xr--
```

```
- rwx r-x r--
  │   │   │
  │   │   └── outros (others)
  │   └────── grupo (group)
  └────────── dono (owner)
```

r = read; w = write; x = execute

Para rodar o script, precisamos ter a permissao de execucao

Cada permissao tem um valor 

| Permissao | Valor | 
| --- | --- |
| r | 4 | 
| w | 2 |
| x | 1 |

Entao, para ler, escrever e executar, teremos o valor 7

Se fizermos:

```bash
chmod 754 arquivo.sh
```

O dono pode fazer tudo
O grupo pode ler e executar
E outros podem apenas ler

## Cron

Cron é o "agendador de tarefas" do Linux

```bash
crontab -e
```

```
* * * * * comando
```

A ordem e: 

1. minuto
2. hora
3. dia do mês
4. mês
5. dia da semana

Exemplo:

```
0 2 * * * backup.sh
```

- Executar backup.sh às 02:00 todos os dias

