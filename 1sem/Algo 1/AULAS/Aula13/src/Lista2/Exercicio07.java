package Lista2;

import java.util.Scanner;
import java.util.LinkedList;

/**
Escreva um programa que crie uma fila para armazenar valores inteiros. Faça a leitura, a partir
do teclado, de 30 valores e armazene na fila. Retire cada um dos elementos da fila e
armazene-os em duas novas filas, uma somente para valores positivos e a outra para valores
não-positivos..
 */

public class Exercicio07
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        LinkedList<Integer> fila = new LinkedList();
        
        for (int i = 0; i < 30; i++)
        {
            fila.add(leitor.nextInt());
        }
        
        LinkedList<Integer> positivos = new LinkedList();
        LinkedList<Integer> negativos = new LinkedList();
       
        while(!fila.isEmpty())
        {   
            int elemento = fila.poll();
            
            if (elemento >= 0)
                positivos.add(elemento);
            else
                negativos.add(elemento);
        }
        
        System.out.println("POSITIVOS:");
        for (int n : positivos) 
            System.out.println(n + "  ");
        
        System.out.println("NEGATIVOS");
        for (int n : negativos)
            System.out.println(n + "  ");
                    
        System.out.print("\n");
    }
    
}
