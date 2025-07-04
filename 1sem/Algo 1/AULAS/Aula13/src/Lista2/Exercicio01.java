package Lista2;

import java.util.Scanner;
import java.util.Stack;

/*
Escreva um programa que crie uma pilha para armazenar valores inteiros. Em seguida, faça a
leitura, a partir do teclado, de 20 valores e armazene na pilha. Ao final, retire todos os elementos
da pilha e imprima na tela cada um.
 */

public class Exercicio01
{
    public static void main(String[] args)
    {   
        Scanner leitor = new Scanner(System.in);
        
        Stack<Integer> pilha = new Stack();
        
        for (int i = 0; i < 20; i++)
        {
            pilha.push(leitor.nextInt());
        }
        
        while(!pilha.empty())
        {
            System.out.print(pilha.pop() + "  ");
        }
        System.out.print("\n");
    }
    
}
