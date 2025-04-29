import java.util.Scanner;

/*
Escreva um programa que leia 10 numeros quaisquer. Mostre quantos estao dentro do intervalo [10, 20] e os quantos nao
 */

public class Exercicio5
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        int contador = 0;
        
        for (int i = 0; i < 10; i++)
        {
            double valor = leitor.nextDouble();
            
            if (valor >= 10 && valor <= 20)
            {
                contador++;
            }
        }
        System.out.println(contador + " valores estao dentro do intervalo");
        System.out.println(10 - contador + " valores estao fora do intervalo");
    }
}
