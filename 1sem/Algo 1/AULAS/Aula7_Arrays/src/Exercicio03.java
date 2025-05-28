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
        
        int[] nums = new int[10];
        
        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = leitor.nextInt();
        }
        
        System.out.println("Digite um numero: ");
        int n = leitor.nextInt();

        int i;
        for (i = 0; i < nums.length; i++)
        {
            if (n == nums[i])
                break;
        }
        
        if (i < nums.length)
        {
            System.out.printf("Numero %d encontrado no indice %d", n, i);
        }
        else 
        {
            System.out.println("Elemento nao encontrado no array");
        }
        


//        int ocorrencias = 0;
//        
//        for(int i = 0; i < nums.length; i++)
//        {
//            if (n == nums[i])
//            {
//                ocorrencias++;
//            }
//        }
//        
//        System.out.printf("O numero %d aparece %d vezes no array", n, ocorrencias);
    }
}
