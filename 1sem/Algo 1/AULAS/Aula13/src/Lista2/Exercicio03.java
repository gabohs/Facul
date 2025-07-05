package Lista2;

import java.util.Scanner;
import java.util.Stack;

/*
Escreva um programa que crie uma pilha para armazenar valores inteiros. Faça a leitura, a partir
do teclado, de 25 valores e armazene na pilha. Retire cada um dos elementos da pilha e
armazene-os em duas novas pilhas, uma somente para valores pares negativos e a outra para
valores ímpares positivos. Descarte todos os demais.
 */

public class Exercicio03
{
    public static void main(String[] args)
    {   
        Scanner leitor = new Scanner(System.in);
        
        Stack<Integer> pilha = new Stack();
        
        for (int i = 0; i < 25; i++)
        {
            pilha.push(leitor.nextInt());
        }
        
        Stack<Integer> neg = new Stack();
        Stack<Integer> posIm = new Stack();
        
        for (int i = pilha.size() - 1; i >= 0; i--)
        {
            if (pilha.get(i) < 0)
                neg.add(pilha.pop());
            else if ( pilha.get(i) > 0 && ( pilha.get(i) % 2 != 0 ) )
                posIm.add(pilha.pop());
            else
                pilha.pop();
        }
        
        System.out.println("NEGATIVOS:");
        for (int n : neg) 
            System.out.println(n + "  ");
        
        System.out.println("POSITIVOS IMPARES:");
        for (int n : posIm)
            System.out.println(n + "  ");
                    
        System.out.print("\n");
    }
    
}
