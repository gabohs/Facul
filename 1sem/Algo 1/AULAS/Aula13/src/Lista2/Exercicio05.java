package Lista2;

import java.util.Scanner;
import java.util.Stack;

/*
Escreva um programa para converter um número inteiro decimal para binário. Leia um número
inteiro decimal do usuário. Enquanto o quociente da divisão for maior que zero, calcule o resto da
divisão por 2 e empilhe esse resto. Use o novo quociente como divisor e prossiga. Ao final,
Desempilhe os elementos e concatene-os para formar o número binário. Na figura abaixo é
demonstrado um exemplo da primeira etapa, que é o cálculo e empilhamento.
 */

public class Exercicio05
{   
    public static void main(String[] args)
    {   
        Scanner leitor = new Scanner(System.in);
        
        int num = leitor.nextInt();
        
        Stack<Integer> pilha = new Stack();
        
        while (num > 0)
        {   
            pilha.push(num % 2);
            num /= 2;
        }
        
        while (!pilha.empty())
        {
            System.out.print(pilha.pop());
        }
        System.out.print("\n");  
    }
    
}
