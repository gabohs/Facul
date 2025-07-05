package Lista2;

import java.util.Scanner;
import java.util.LinkedList;

/*
Escreva um programa que crie uma fila para armazenar valores inteiros. Em seguida, faça a
leitura, a partir do teclado, de 20 valores e armazene na fila. Ao final, retire todos os elementos
da fila e imprima na tela cada um.
 */

public class Exercicio06
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        LinkedList<Integer> fila = new LinkedList();
        
        for (int i = 0; i < 20; i++)
        {
            fila.add(leitor.nextInt());
        }
        
        while (fila.size() > 0)
        {
            System.out.print(fila.poll() + "  ");
        }
        System.out.print("\n");   
    }
    
}
