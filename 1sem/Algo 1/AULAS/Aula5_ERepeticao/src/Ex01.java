/* Exemplo 1
Imprima a tabuada do 7 (de 1 a 10) no formato "7 x 1 = 7"
 */

public class Ex01
{
    public static void main(String[] args)
    {
        for (int i = 1; i <= 10; i++)
        {
            System.out.printf("7 x %d = %d\n", i, 7 * i);   
        }
    }
}
