import java.util.Scanner;

/* Exemplo 2
Imprima o inverso dos numeros digitados pelo usuario enquanto forem diferentes de 0
*/

public class Ex02
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        
        double x;
        while ( (x = s.nextDouble()) != 0 )
        {
            double inverso = 1 / x;
            System.out.printf("O inverso de %f e %f\n", x, inverso);
        }
    }
    
}
