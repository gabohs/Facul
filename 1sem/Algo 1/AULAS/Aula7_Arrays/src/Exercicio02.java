import java.util.Scanner;

/*
Elabore um programa que leia dois vetores de dez elementos reais e faca a multiplicacao dos elementos de mesmo indice, colocando os
resultados em um terceiro vetor, que deve ser mostrado em seguida
 */

public class Exercicio02
{
    public static void res1()
    {   
        // resolucao 1
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
        
        for (double r : results)
        {
            System.out.println(r);
        }
    }
    
    public static void res2()
    {
        // resolucao 2
        Scanner leitor = new Scanner(System.in);
        
        double[][] matriz = new double[2][10];
        
        for (int i = 0; i < 2; i++) // i < matriz.length
        {
            for (int j = 0; j < 10; j++) // j < matriz[i].length
            {
                matriz[i][j] = leitor.nextDouble();
            }
        }
        
        double[] results = new double[10];
        for (int i = 0; i < results.length; i++)
        {
            results[i] = matriz[0][i] * matriz[1][i];
        }
        
    }
    
    public static void main(String[] args)
    {
        // res1();
        res2();
    }
}
