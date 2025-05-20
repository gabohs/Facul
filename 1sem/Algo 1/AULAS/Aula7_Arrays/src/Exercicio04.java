import java.util.Scanner;

/* EXERCICIO 04
Faca um programa que possua um vetor denominado A que armazene 6 numeros inteiros, lidos pelo teclado. O algoritmo deve executar
os seguintes passos:

a) Atribua os seguintes valores a esse vetor: 1, 0, 5, -2, -5, 7

b) Armazene em uma variavel inteira (simples) a soma dos valores das posicoes A[0], A[1] e A[5] do vetor e mostre na tela essa soma.

c) Modifique o vetor na posicao 4, atribuindo a esta posicao o valor 100
 */

public class Exercicio04
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        int[] A = new int[6];
        
        for (int i = 0; i < A.length; i++)
        {
            A[i] = leitor.nextInt();
        }
        
        A[0] = 1;
        A[1] = 0;
        A[2] = 5;
        A[3] = -2;
        A[4] = -5;
        A[5] = 7;
        
        int somaPos = A[0] + A[1] + A[5];
        A[4] = 100;
        
        for (int i = 0; i < A.length; i++)
        {
            System.out.println(A[i]);
        }  
    } 
}
