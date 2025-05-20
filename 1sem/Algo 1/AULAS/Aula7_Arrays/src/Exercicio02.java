import java.util.Scanner;

/*
Elabore um programa que leia dois vetores de dez elementos reais e faca a multiplicacao dos elementos de mesmo indice, colocando os
resultados em um terceiro vetor, que deve ser mostrado em seguida
 */

public class Exercicio02
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        double[] v1 = new double[10];
        double[] v2 = new double[10];
        
        double[] results = new double[10];
        
        for (int i = 0; i < v1.length; i++)
        {
            System.out.printf("Valor %d do vetor 1: ", i);
            v1[i] = leitor.nextDouble();
            
            System.out.printf("Valor %d do vetor 2: ", i);
            v2[i] = leitor.nextDouble();
            
            results[i] = v1[i] * v2[i];
        }
        
        for (int i = 0; i < results.length; i++)
        {
            System.out.println(results[i]);
        }
    }
}
