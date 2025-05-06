import java.util.Scanner;

/* EX 26
 Leia 3 valores inteiros e ordene-os em ordem crescente. No final, mostre os 3 valores em ordem
crescente, separados por espaço em branco, e na linha seguinte, os valores na sequência como
foram lidos
 */

public class Exercicio26
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite 3 valores inteiros:");
        
        int[] valores = new int[3];
        
        valores[0] = leitor.nextInt();
        valores[1] = leitor.nextInt();
        valores[2] = leitor.nextInt();
        
        System.out.println("ORIGINAL: " + valores[0] + " " + valores[1] + " " + valores[2]);
        
        for (int i = 0; i < 2; i++) 
        {
            for (int j = 0; j < 2 - i; j++) 
            {
                if (valores[j] > valores[j + 1]) 
                {
                    int temp = valores[j];
                    valores[j] = valores[j + 1];
                    valores[j + 1] = temp;
                }
            }
        }
        
        System.out.println("O. CRESCENTE: " + valores[0] + " " + valores[1] + " " + valores[2]); 
    } 
}
