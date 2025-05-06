import java.util.Scanner;

/* EX 27
Leia três valores reais, que são as medidas dos lados de um suposto triângulo. Coloque esses
valores em ordem decrescente (A, B e C), verifique se as regras abaixo se aplicam e exiba a
classificação do triângulo quanto aos seus ângulos (regras no pdf).
*/


public class Exercicio27
{
    public static void main(String[] args)
    {   
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Medidas dos 3 lados:");
        
        int[] valores = new int[3];
        
        valores[0] = leitor.nextInt();
        valores[1] = leitor.nextInt();
        valores[2] = leitor.nextInt();
        
        for (int i = 0; i < 2; i++) 
        {
            for (int j = 0; j < 2 - i; j++) 
            {
                if (valores[j] < valores[j + 1]) 
                {
                    int temp = valores[j];
                    valores[j] = valores[j + 1];
                    valores[j + 1] = temp;
                }
            }
        }
        
        int a = valores[0];
        int b = valores[1];
        int c = valores[2];
        
        if (a >= b + c)
        {
            System.out.println("Nao e um triangulo.");
        }
        else
        {
            if (Math.pow(a, 2) < Math.pow(b, 2) + Math.pow(c, 2))
            {
                System.out.println("E um triangulo acutangulo!");
            }
            else if (Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2))
            {
                System.out.println("E um triangulo retangulo!");
            }
            else
            {
                System.out.println("E um triangulo obtusangulo!");
            }
        }
    }
}
