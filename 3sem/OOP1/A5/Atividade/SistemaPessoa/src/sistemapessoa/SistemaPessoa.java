package sistemapessoa;

import java.util.Scanner;

public class SistemaPessoa 
{
    static Scanner scan = new Scanner(System.in);
//    static String nome, endereco, telefone;
//    
//    public static void leituraDados()
//    {
//        System.out.print("Nome: ");
//        nome = scan.nextLine();
//
//        System.out.print("Endereco: ");
//        endereco = scan.nextLine();
//
//        System.out.print("Telefone");
//        telefone = scan.nextLine();
//    }
    
    
    public static void main(String[] args) 
    {
        
        String resposta = "S";
        
        while (resposta.equals("S"))
        {
            System.out.println("1 - PESSOA");
            System.out.println("2 - FORNECEDOR");
            System.out.println("3 - EMPREGADO");
            
            System.out.print("> O que voce quer criar?: ");
            int escolha = scan.nextInt();
            
            scan.nextLine();
            
            System.out.print("> Nome: ");
            String nome = scan.nextLine();
            
            System.out.print("> Endereco: ");
            String end = scan.nextLine();
            
            System.out.print("> Telefone: ");
            String tele = scan.nextLine();
          
            switch (escolha)
            {
                case 1:
                {
                    Pessoa p = new Pessoa(nome, end, tele);
                    
                    System.out.println("");
                    p.escrever();
                } break;
                
                case 2:
                {
                    System.out.print("> Valor credito: ");
                    double vCred = scan.nextDouble();
                    
                    System.out.print("> Valor divida: ");
                    double vDiv  = scan.nextDouble();
                    
                    Fornecedor f = new Fornecedor(nome, end, tele, vCred, vDiv);
                    
                    System.out.println("");
                    f.escrever();
                    scan.nextLine();
                } break; 
                
                case 3:
                {
                    // ler empregado
                } break;
                    
                default:
                    System.out.println("Numero invalido:");
            }
            
            
            System.out.print("Quer Continuar? (S/N)");
            resposta = scan.nextLine();
        }
    }
    
}
