import java.util.Scanner;

/*
Escreva um programa que leia 100 numeros naturais, cujos valores estao no intervalo [1, 10], e conte quantos numeros de
cada valor (1 a 10) existe
*/

public class Exercicio06
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        int[] vetor = new int[100];
        
        for (int i = 0; i < vetor.length; i++)
        {
            vetor[i] = leitor.nextInt();
        } 
        
        int[] cont = new int[10];
        for (int i = 0; i < cont.length; i++)
        {
            cont[i] = 0;
        }
        
        // realizar a contagem
        for (int i = 0; i < vetor.length; i++)
        {
            int numero = vetor[i]; // pega o valor
            cont[numero - 1]++;
        }
        
        System.out.println("Contagem");
        for (int i = 0; i < 10; i++)
        {
            System.out.println( (1 + i) + ": "+ cont[i]);
        }
    }
}
