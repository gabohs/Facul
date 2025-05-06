import java.util.Scanner;

/* EX. 1
Leia dois números inteiros, calcule a média aritmética simples entre eles e exiba o valor.
*/

public class Exercicio01 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Primeiro numero:");
        int num1 = leitor.nextInt();
        
        System.out.println("Segundo numero:");
        int num2 = leitor.nextInt();
        
        double media = (num1 + num2) / 2;
        
        System.out.println("A media entre os numeros eh: " + media);
    }
    
}
