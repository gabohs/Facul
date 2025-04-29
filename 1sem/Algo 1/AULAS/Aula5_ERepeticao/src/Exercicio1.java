/* Exercicio 1
Numeros pares de 1 a 1000
*/

public class Exercicio1
{
    public static void main(String[] args)
    {
        for (int n = 1; n <= 1000; n++)
        {
            if (n % 2 == 0) System.out.println(n);
        }
        
        for (int n = 2; n <= 1000; n += 2)
        {
            System.out.println(n);
        }
    }
    
}
