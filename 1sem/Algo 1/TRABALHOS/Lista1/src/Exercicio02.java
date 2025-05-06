import java.util.Scanner;

/* EX. 2
Leia dois números inteiros, calcule a média aritmética ponderada entre eles, considerando os
pesos 2,5 e 3,5, respectivamente, e exiba o valor.
*/

public class Exercicio02 
{
    public static void main(String[] args) 
    {   
        final double Peso1 = 2.5;
        final double Peso2 = 3.5; 
        
        Scanner leitor = new Scanner(System.in);
      
        System.out.println("Primeiro numero:");
        int num1 = leitor.nextInt();
        
        System.out.println("Segundo numero:");
        int num2 = leitor.nextInt();
        
        double mediaPond = (num1 * Peso1) + (num2 * Peso2) / (Peso1 + Peso2);
        
        System.out.println("A media ponderada entre os numeros eh: " + mediaPond);
    }
    
}
