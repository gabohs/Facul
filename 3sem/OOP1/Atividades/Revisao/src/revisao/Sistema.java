package revisao;

import java.util.Scanner;

public class Sistema 
{
    private final int tam = 50;
    private Funcionario[] funcionarios = new Funcionario[tam];
    
    private static Scanner scan = new Scanner(System.in);
    
    public void print_menu()
    {
        System.out.println("================================");
        System.out.println("1 – Cadastrar Funcionário");
        System.out.println("2 – Exibir a Lista de Funcionários");
        System.out.println("9 – Sair");
        System.out.println("================================");
        System.out.print("> Opcao: ");
    }
    
    public void rodar()
    {
        int opcao;
        int cont = 0;
        do
        {
            print_menu();
            
            opcao = scan.nextInt();
            scan.nextLine();
            
            switch(opcao)
            {
                case 1:
                {
                    if (cont >= 50)
                    {
                        System.out.println("Num maximo de funcionarios alcancado");
                        break;
                    }
                    
                    Funcionario f = new Funcionario();
                    System.out.println("Cadastando Funcionario...");
                    
                    System.out.print("Nome: ");
                    f.setNome(scan.nextLine());
                    
                    System.out.print("CPF: ");
                    f.setCpf(scan.nextLine());
                    
                    System.out.print("Salario: ");
                    f.setSalario(scan.nextDouble());
                    
                    funcionarios[cont++] = f;
                    
                } break;
                
                case 2:
                {
                    System.out.println("\nESCREVENDO FUNCIONARIOS...\n");
                    for (int i = 0; i < cont; i++)
                    {
                        System.out.println("FUNCIONARIO " + i);
                        funcionarios[i].escrever();
                        System.out.println("--------------------------------------");
                    }
                     
                } break;
                
                case 9:
                {
                    System.out.println("Tchau!");
                } break;
                    
                
                default:
                    System.out.println("Opcao invalida!!");
            }
            
        } while (opcao != 9);
    }
    
}
