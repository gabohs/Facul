/* Exercicio 7
calcule e imprima a soma dos inversos de todos os numeros de 2 ate 10 ( 1/2 + 1/3 + 1/4 + ... + 1/10 )
*/

public class Exercicio7
{
    public static void main(String[] args)
    {
        double soma = 0;
        
        for (int i = 2; i <= 10; i++)
        {
            soma += 1.0 / i;
        }
        System.out.println("Soma: " + soma);
    }
}
