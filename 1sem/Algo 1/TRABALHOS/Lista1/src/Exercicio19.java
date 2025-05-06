import java.util.Scanner;

/* EX 19
Escreva um algoritmo que solicite a digitação de um ano. Com base nessa informação, deve-se
usar a regra simples para indicar se o ano é bissexto: seja divisível por 4. Informe ao final se o
ano é ou não bissexto.
 */

public class Exercicio19 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite um ano: ");
        int ano = leitor.nextInt();
        
        if (ano % 4 == 0)
        {
            System.out.println(ano + " eh bissexto!");
        }
        else
        {
            System.out.println(ano + " nao eh bissexto!");
        }
    }
}
