package Lista1;

import java.util.Scanner;
import java.util.ArrayList;

/*
Escreva um programa em Java que crie uma lista para armazenar valores inteiros. Em seguida,
faça a leitura, a partir do teclado, de 20 valores e armazene na lista.
*/

public class Exercicio01
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        ArrayList<Integer> lista = new ArrayList();
        for (int i = 0; i < 20; i++)
        {
            lista.add(leitor.nextInt());
        }
        
        for (int n : lista)
            System.out.print(n + "  ");
        
        System.out.println("\nTamanho da lista: " + lista.size());
    }
    
}
