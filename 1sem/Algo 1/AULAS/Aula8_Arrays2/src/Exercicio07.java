import java.util.Scanner;

/*
Na mega sena, sao sempre sorteados 6 numeros. Alfredo aposta 1 cartao com 7 dezenas. Faca um programa que conte o numero de
acertos de Alfredo
*/

public class Exercicio07
{

    public static void main(String[] args)
    {   
        Scanner leitor = new Scanner(System.in);
        
        int[] numsCorretos = new int[6];
        for (int i = 0; i < numsCorretos.length; i++)
        {
            numsCorretos[i] = (i + 1) + (int) (Math.random() * 60);
        }
        
        int[] cartaoAlfredo = new int[7];
        for (int i = 0; i < cartaoAlfredo.length; i++)
        {
            System.out.print("Numero" + (i + 1) + ": ");
            cartaoAlfredo[i] = leitor.nextInt();
        }
        
        int acertos = 0;
        for (int i = 0; i < cartaoAlfredo.length; i++)
        {
            for (int j = 0; j < numsCorretos.length; j++)
            {
                if (cartaoAlfredo[i] == numsCorretos[j])
                {
                    acertos++;
                    break;
                }
            }
        }  
        
        System.out.println("Seus numeros: ");
        for (int nums : cartaoAlfredo)
        {
            System.out.print(nums + ", ");
        }
        System.out.println("");
        
        System.out.println("Acertos: " + acertos);
        System.out.println("Os corretos eram: ");
        for (int correto : numsCorretos)
        {   
            System.out.print(correto + ", ");
        }
        System.out.println("");
    }
    
}
