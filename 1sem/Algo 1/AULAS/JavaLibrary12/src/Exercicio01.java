/*
olimpiada.ic.unicamp.br/pratique/p2/2021/f1/zero
*/

import java.util.Scanner;
import java.util.Stack;

public class Exercicio01
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        System.out.println("Quantidade de inputs: ");
        int N = s.nextInt();
        
        Stack<Integer> stack = new Stack();
       
        for (int i = 0; i < N; i++)
        {
            int numFalado = s.nextInt();
           
            if (numFalado != 0)
                stack.push(numFalado);
            else    
                stack.pop(); 
        }
       
        int soma = 0;
        
        while (!stack.empty())
        {
            soma += stack.pop();
        }
        
        System.out.println("Soma final: " + soma);
    }
    
}
