import java.util.Scanner;

/*
Escreva um programa que leia 10 nums inteiros. Como saida, deve informar se existe algum igual. Nao precisa informar quais sao os 
numeros, apenas se ha duplicatas
 */

public class Exercicio05
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        int[] nums = new int[10];
        
        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = leitor.nextInt();
        }
        
        int i = 0, j = 0;
        for (i = 0; i < nums.length - 1; i ++)
        {
            for (j = i + 1; j < nums.length; j++)
            {
                if (nums[i] == nums[j])
                    break;
            }
            if (j < 10) break;
        }
        if (i < nums.length - 1)
        {
            System.out.printf("Encontrei uma duplicata em %d e %d\n", i, j);
        }
        else
        {
            System.out.println("Nenhuma duplicada encontrada!");
        }
    }  
}
