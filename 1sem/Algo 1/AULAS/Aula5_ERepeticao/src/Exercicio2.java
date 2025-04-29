/* Exercicio 2
Numeros diviseis por 7 no intervalo de 1000 a 7000, inclusive
 */

public class Exercicio2
{
    public static void main(String[] args)
    {
        for (int i = 1000; i <= 7000; i++)
        {
            if (i % 7 == 0)
            {
                System.out.println(i);  
            }
        }
    }
}
