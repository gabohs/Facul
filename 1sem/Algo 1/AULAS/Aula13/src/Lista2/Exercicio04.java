package Lista2;

import java.util.Scanner;
import java.util.Stack;

/*
Escreva um programa que leia uma string. Em seguida, empilhe cada um dos caracteres da
string, desde o início. Desempilhe os caracteres e junte-os (concatene-os numa nova string).
Imprima a nova string.
 */

public class Exercicio04
{   
    public static void main(String[] args)
    {   
        Scanner leitor = new Scanner(System.in);
        
        String str = leitor.nextLine();
        
        Stack<Character> pilha = new Stack();
        
        for (int i = 0; i < str.length(); i++)
        {
            pilha.push(str.charAt(i));
        }
        
        String nova = "";
        
        while (!pilha.empty())
        {
            nova += pilha.pop();
        }
        
        System.out.println("Nova string:");
        System.out.println(nova);
    }
    
}
