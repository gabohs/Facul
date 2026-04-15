package controlepagamento;

import java.util.Scanner;

public class SistemaPagamento 
{
    private final int TAM = 20;
    private static Scanner scan = new Scanner(System.in);
    
    private ServicoComTaxa[] servico_array = new ServicoComTaxa[TAM];
    private int cont = 0;
    
    // decidi definir os seguintes metodos como private pois usarei eles somente dentro desta classe
    private void printMenu()
    {
        System.out.println("============ MENU ============");
        System.out.println("1 - Adicionar Servico com Taxa");
        System.out.println("2 - Listar todos os servicos");
        System.out.println("3 - Mostrar total a pagar");
        System.out.println("0 - Sair");
        System.out.println("===============================");
    }

    private void adicionarServico(ServicoComTaxa s)
    {
        servico_array[cont++] = s; // checagem do cont eh feita no case 1 do switch, antes de chamar essa funcao.
        System.out.println("Servico Adicionado!!");
    }
    
    private void listarServicos()
    {
        for (int i = 0; i < cont; i++)
        {
            System.out.println("==== Servico [" + (i + 1) + "] ====");
            this.servico_array[i].escrever();
            System.out.println("Valor do pagamento: " + this.servico_array[i].calcularPagamento() + "R$");
            System.out.println("-----------------------------");
        }
    }
    
    private void mostrarTotal()
    {
        double acc = 0;
        for (int i = 0; i < cont; i++)
        {
            acc += servico_array[i].calcularPagamento();
        }
        System.out.println("TOTAL DOS PAGAMENTOS: " + acc);
    }
    
    public void executar()
    {   
        this.printMenu(); // printar o menu somente uma vez pra nao ficar muito poluido
        int opcao;
        do
        {
            System.out.print("> Sua opcao: ");
            opcao = scan.nextInt();
            scan.nextLine(); // consumir o \n pra nao bugar depois
            
            switch (opcao)
            {
                case 0:
                {
                    System.out.println("Tchau!!");
                } break;
                
                case 1:
                {
                    if (cont >= TAM)
                    {
                        System.out.println("Limite maximo de servicos atingido.");
                        continue;
                    }
                    
                    System.out.print("Descricao: ");
                    String desc = scan.nextLine();

                    System.out.print("Valor Base: ");
                    double vb = scan.nextDouble();

                    System.out.print("Percentual Taxa: ");
                    double pt = scan.nextDouble();
                    
                    ServicoComTaxa serv = new ServicoComTaxa(desc, vb, pt);
                    
                    this.adicionarServico(serv);
                } break;
                
                case 2:
                {
                    listarServicos();
                } break;
                
                case 3:
                {
                   mostrarTotal();
                } break;
                
                default:
                {
                    System.out.println("Opcao invalida!!");
                } break;

            }
            
        } while (opcao != 0);
    }
    
    // encapsulando a classe:
    public int getTAM() 
    {
        return this.TAM;
    }

    public ServicoComTaxa[] getServico_array() 
    {
        return this.servico_array;
    }

    public int getCont() 
    {
        return this.cont;
    }

    public void setServico_array(ServicoComTaxa[] servico_array) 
    {
        this.servico_array = servico_array;
    }

    public void setCont(int cont) 
    {
        this.cont = cont;
    } 
}
