import java.util.Scanner;

/* EX 20
Escreva um algoritmo que solicite a digitação de um ano. Com base nessa informação, deve
usar a regra completa para indicar se o ano é bissexto: seja divisível por 4, mas não divisível por
100, exceto se for divisível por 400. Informe ao final se o ano é ou não bissexto.
 */

public class Exercicio20 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite um ano: ");
        int ano = leitor.nextInt();
        
        if ( (ano % 4 == 0) && ( ano % 100 != 0 || ano % 400 == 0) )
        {
            System.out.println(ano + " eh bissexto");
        }
        else
        {
            System.out.println(ano + " nao eh bissexto");
        }
    }
    
}
