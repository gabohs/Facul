import java.util.Scanner;

/* EX 28
Escreva um algoritmo que solicite a digitação de um número inteiro qualquer. Em seguida, o
algoritmo deve informar se o número é negativo, zero ou positivo. Se o número for diferente de
zero, informe também se ele é par ou ímpar.
 */

public class Exercicio28
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Informe um numero inteiro:");
        int n = leitor.nextInt();
        
        if (n < 0)
        {
            System.out.println(n + " e negativo!");
        }
        else if (n == 0)
        {
            System.out.println(n + " e zero!");
        }
        else
        {
            System.out.println(n + " e positivo!");
            
            if (n % 2 == 0)
            {
                System.out.println(n + " e par!");
            }
            else
            {
                System.out.println(n + " e impar!");
            }
        }
    }
}
