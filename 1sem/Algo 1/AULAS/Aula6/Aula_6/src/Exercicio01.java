/*
Apresente as tabuadas do 2 ao 10, no formato "2 x 1 = 2"
 */

public class Exercicio01
{
    public static void main(String[] args)
    {
        for (int i = 2; i < 11; i++)
        {   
            System.out.printf("\n=== TABUADA DO %d ===\n", i);
            for (int j = 1; j < 11; j++)
            {
                System.out.printf("%d x %d = %d\n", i, j, i * j);
            }
        }
    }
}
