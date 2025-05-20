import java.util.Scanner;

/* EXERCICIO 03
Escreva um programa que leia 10 numeros inteiros, e armazene num vetor. Em seguida, leia mais um numero e verifique se ele eh
igual a um dos 10 numeros armazenados no vetor
 */

public class Exercicio03
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        int[] nums1 = new int[10];
        
        for (int i = 0; i < nums1.length; i++)
        {
            nums1[i] = leitor.nextInt();
        }
        
        System.out.println("Digite um numero: ");
        int num = leitor.nextInt();
        int ocorrencias = 0;
        
        for(int i = 0; i < nums1.length; i++)
        {
            if (num == nums1[i])
            {
                ocorrencias++;
            }
        }
        
        System.out.printf("O numero %d aparece %d vezes no array", num, ocorrencias);
    }
    
}
