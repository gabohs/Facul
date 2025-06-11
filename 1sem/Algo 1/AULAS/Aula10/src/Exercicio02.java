import java.util.Scanner;

/*
Implemente uma funcao recursiva para calcular a divisao inteira de 2 numeros naturais
 */

public class Exercicio02
{
    
    public static int calculaDivRec(int a, int b) // a / b
    {   
        if (a >= b) 
            return 1 + calculaDivRec(a - b, b); 
        else
            return 0;
    }
    
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int a = leitor.nextInt();
        int b = leitor.nextInt();
        
        int result = calculaDivRec(a, b);
        
        System.out.println(result);
    } 
}
