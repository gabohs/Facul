/* Exercicio 3
Quadrado de cada um dos pares entre 1 e 1000, inclusive
 */

public class Exercicio3
{
    public static void main(String[] args)
    {
        for (int i = 2; i <= 1000; i += 2)
        {
            System.out.printf("%d^2 = %d\n",i,  i * i );
        }
    }
    
}
