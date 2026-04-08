package cadastroprodutos;

import java.util.Scanner;

public class CadastroProdutos 
{
    private static Scanner teclado = new Scanner(System.in);
    
    private static final int NUM_PRODUTOS = 50;
    
    private static void imprime_menu()
    {
        System.out.println("=========== MENU =============");
        System.out.println("1 – Cadastrar Produto Estadual");
        System.out.println("2 – Cadastrar Produto Nacional");
        System.out.println("3 – Cadastrar Produto Importado");
        System.out.println("4 – Exibir Produtos Estaduais");
        System.out.println("5 – Exibir Produtos Nacionais");
        System.out.println("6 – Exibir Produtos Importados");
        System.out.println("7 – Exibir Todos Produtos");
        System.out.println("9 – SAIR");
        System.out.println("==============================");
        System.out.println("> Sua opcao:");
    }
    
    private static void enter_continuar()
    {
        System.out.print("Pressione enter para continuar...");
        teclado.nextLine(); // so pro menu nao ser imprimir logo depois
    }
    
    public static void main(String[] args) 
    {   
        Produto[] produtos = new Produto[NUM_PRODUTOS];
        
        int cont = 0;
        int opcao;
        
        do 
        {
            imprime_menu();
            opcao = teclado.nextInt();
            teclado.nextLine(); // consumir o \n, se nao o enter_continuar buga depois
            
            switch (opcao)
            {
                case 1:
                {               
                    System.out.print("Descricao: ");
                    String desc = teclado.next();

                    System.out.print("Valor: ");
                    double val = teclado.nextDouble();
                    teclado.nextLine();
                    
                    produtos[cont++] = new ProdutoEstadual(desc, val);
                    System.out.println("Produto Estadual Adicionado");
                } break;
                
                case 2:
                {
                    System.out.print("Descricao: ");
                    String desc = teclado.next();

                    System.out.print("Valor: ");
                    double val = teclado.nextDouble();
                    teclado.nextLine();
                    
                    produtos[cont++] = new ProdutoNacional(desc, val);
                    System.out.println("Produto Nacional Adicionado");
                } break;
                
                case 3:
                {
                    System.out.print("Descricao: ");
                    String desc = teclado.next();

                    System.out.print("Valor: ");
                    double val = teclado.nextDouble();
                    teclado.nextLine();
                    
                    produtos[cont++] = new ProdutoImportado(desc, val);
                    System.out.println("Produto Importado Adicionado");
                } break;
                
                case 4:
                {
                    System.out.println("=========================================");
                    for (int i = 0; i < cont; i++)
                    {
                        if (produtos[i] instanceof ProdutoEstadual)
                        {
                            System.out.println("--- PRODUTO ESTADUAL [" + i + "] ---");
                            produtos[i].exibir();
                        }
                            
                    }
                    System.out.println("=========================================");
                    enter_continuar();
                } break;
                
                case 5:
                {
                    System.out.println("=========================================");
                    for (int i = 0; i < cont; i++)
                    {
                        if (produtos[i] instanceof ProdutoNacional)
                        {
                            System.out.println("--- PRODUTO NACIONAL [" + i + "] ---");
                            produtos[i].exibir();
                        }
                    }
                    System.out.println("=========================================");
                    enter_continuar();
                } break;
                
                case 6:
                {
                    System.out.println("=========================================");
                    for (int i = 0; i < cont; i++)
                    {
                        if (produtos[i] instanceof ProdutoImportado)
                        {
                            System.out.println("--- PRODUTO IMPORTADO [" + i + "]  ---");
                            produtos[i].exibir();
                        }
                    }
                    System.out.println("=========================================");
                    enter_continuar();
                } break;
                
                case 7:
                {
                    System.out.println("=========================================");
                    for (int i = 0; i < cont; i++)
                    {
                        produtos[i].exibir();
                    }
                    System.out.println("=========================================");
                    enter_continuar();
                } break;
                
                default:
                    break;
            }
            
        } while(opcao != 9 && cont < 50);
    }
    
}
