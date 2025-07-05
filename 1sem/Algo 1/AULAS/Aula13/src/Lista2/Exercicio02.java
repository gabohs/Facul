package Lista2;

import java.util.Scanner;
import java.util.Stack;

/*
Escreva um programa que crie uma pilha para armazenar valores inteiros. Faça a leitura, a partir
do teclado, de 30 valores e armazene na pilha. Retire cada um dos elementos da pilha e
armazene-os em duas novas pilhas, uma somente para valores pares e a outra para valores
ímpares.
 */

public class Exercicio02
{
    public static void main(String[] args)
    {   
        Scanner leitor = new Scanner(System.in);
        
        Stack<Integer> pilha = new Stack();
        
        for (int i = 0; i < 30; i++)
        {
            pilha.push(leitor.nextInt());
        }
        
        Stack<Integer> pares = new Stack();
        Stack<Integer> impares = new Stack();
        
        for (int i = pilha.size() - 1; i >= 0; i--)
        {
            if (pilha.get(i) % 2 == 0)
                pares.add(pilha.pop());
            else
                impares.add(pilha.pop());
        }
        
        System.out.println("PARES:");
        for (int n : pares) 
            System.out.println(n + "  ");
        
        System.out.println("IMPARES");
        for (int n : impares)
            System.out.println(n + "  ");
                    
        System.out.print("\n");
        
    }
    
}
