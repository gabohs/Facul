import java.util.Scanner;

/* Exercicio 4
Receba um numero e escreva os 10 proximos 
 */

public class Exercicio4
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        int inicio = leitor.nextInt();
        
        for (int i = inicio + 1; i <= inicio + 10; i++)
        {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
    
}