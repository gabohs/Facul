# Exercício: Levantamento de requisitos para a empresa FoodFast

- Gabriel H. Schaeffer

## Requisitos Funcionais

| RF1 | Cadastro de clientes |
| --- | --- |
| DESCRIÇÃO | O sistema deve permitir o cadastro de clientes, utilizando e-mail e senha como identificadores para o Login. |
| PRIORIDADE | ALTA |

<br>

| RF2 | Login |
| --- | --- |
| DESCRIÇÃO | O sistema deve ter uma funcionalidade segura de acesso, diretamente relacionada ao cadastro de clientes. Deve permitir recuperação de senha.  |
| PRIORIDADE | ALTA |

<br>

| RF3 | Pedido |
| --- | --- |
| DESCRIÇÃO | O cliente pode realizar pedidos em restaurantes parceiros pelo aplicativo. |
| PRIORIDADE | ALTA |

<br>

| RF4 | Cancelamento do Pedido |
| --- | --- |
| DESCRIÇÃO | O cliente deve possuir o direito de cancelar seu pedido, desde que a solitação esteja em conformidade com a RNF3 |
| PRIORIDADE | ALTA |

<br>

| RF5 | Pagamento |
| --- | --- |
| DESCRIÇÃO | O sistema deve possuir funcionalidade de pagamento suportando os métodos estabelecidos na RN01  |
| PRIORIDADE | ALTA |

<br>

| RF6 | Notificação |
| --- | --- |
| DESCRIÇÃO | O sistema deve enviar uma notificação para o usuário quando o restaurante responsável alterar o status do pedido  |
| PRIORIDADE | MÉDIA |

<br>

| RF7 | Alteração do status do pedido |
| --- | --- |
| DESCRIÇÃO | O restaurante deve ter controle sobre os status do pedido, podendo alterar seu status respeitando a RNF4 |
| PRIORIDADE | ALTA |



## Requisitos não funcionais

| RNF1 | Disponibilidade do Sistema |
| --- | --- |
| DESCRICAO |  O sistema deverá estar disponível pelo menos 99% do tempo em cada mês e deve suportar até 10.000 acessos simultâneos sem perder o desempenho |
| CATEGORIA | Infraestrutura |
| OBRIGATORIEDADE | Obrigatório |

<br>

| RNF2 | Conformidade com a LGPD |
| --- | --- |
| DESCRIÇÃO | O sistema deve estar em conformidade com as normas LGPD, garantindo a proteção dos dados do cliente.  |
| CATEGORIA | Segurança |
| OBRIGATORIEDADE | Obrigatório |

<br>

| RNF3 | Viabilidade acerca do cancelamento de pedido |
| --- | --- |
| DESCRIÇÃO | Só é dado ao cliente o direito de cancelar o pedido se este ainda não estiver em preparo  |
| CATEGORIA | Funcionalidade |
| OBRIGATORIEDADE | Obrigatório |

<br>

| RNF4 | Status do pedido |
| --- | --- |
| DESCRIÇÃO | o restaurante responsável pelo pedido deverá alterar o status dele, quando for conveniente, para “em preparo”, “a caminho” ou “entregue”, mantendo o cliente sempre atualizado.
| CATEGORIA | Funcionalidade |
| OBRIGATORIEDADE | Obrigatório |

<br>

## Regras de Negócio

| Nome | Métodos de Pagamento (RN01) |
| --- | --- |
| DESCRIÇÃO | Os pagamentos devem ser efetuados via PIX ou cartão de crédito |
| FONTE | Fred, Finance Manager da FoodFast |
| HISTÓRICO | Data de identificação: 01/10/2025 |

<br>

| Nome | Viabilidade do cancelamento (RN02) |
| --- | --- |
| DESCRIÇÃO | O cliente tem o direito de cancelar seu pedido, desde que o status deste (mais detalhes na RNF4) ainda não seja "em preparo" ou posterior |
| FONTE | Pedro, CEO FoodFast |
| HISTÓRICO | Data de identificação: 01/10/2025 |

<br>

| Nome | Taxa de serviço (RN03) |
| --- | --- |
| DESCRIÇÃO | É mandatório que 15% dos lucros obtidos pelo restaurante por pedido entregue sejam repassados para a plataforma FoodFast |
| FONTE | Pedro, CEO FoodFast |
| HISTÓRICO | Data de identificação: 01/10/2025 |