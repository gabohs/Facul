import java.util.Scanner;

/* EXERCICIO 01
Escreva um programa q leia 100 numeros reais e armazene num vetor. Em seguida exiba o quadrado e o cubo de cada um dos numeros
 */

public class Exercicio01
{
    public static void main(String[] args)
    {   
        Scanner leitor = new Scanner(System.in);
        
        double[] vetor = new double[100];
        
        for (int i = 0; i < vetor.length; i++)
        {
            vetor[i] = leitor.nextDouble();
        }
        
        for (int i = 0; i < vetor.length; i++)
        {
            System.out.println( ( vetor[i] * vetor[i] ) + " " + ( vetor[i] * vetor[i] * vetor[i] ) );
        }
    }
    
}
