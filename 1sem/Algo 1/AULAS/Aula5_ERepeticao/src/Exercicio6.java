import java.util.Scanner;

/* Exercicio6
Escreva um programa que leia 20 numeros reais e informe qual e o menor e o maior destes
 */

public class Exercicio6
{
    public static void main(String[] args)
    {   
        Scanner leitor = new Scanner(System.in);
        
        double valor = leitor.nextInt();
        
        double min = valor; double max = valor;
        
        for (int i = 2; i <= 20; i++) // i = 2 pois estamos lendo a partir do 2ndo valor
        {
            valor = leitor.nextInt();
            
            if (valor > max) max = valor;
            if (valor < min) min = valor;
        }
        System.out.println("Maximo: " + max);
        System.out.println("Min: " + min);
    }
}
