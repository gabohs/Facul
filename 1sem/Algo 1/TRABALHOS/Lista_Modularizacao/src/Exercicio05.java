import java.util.Scanner;

/*
Em Java, implemente um método com a seguinte assinatura:
public static boolean ehPar(int numero)
O método deve:
● Retornar true se o número for par.
● Retornar false se o número for ímpar.
● Exemplos: ehPar(4) deve retornar true.
            ehPar(7) deve retornar false.
*/

public class Exercicio05
{   
    public static boolean ehPar(int numero)
    {
        if (numero % 2 == 0)
            return true;
        
        return false;
    }
    
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite um numero:");
        System.out.println("Digite 0 para finalizar o programa.");
        System.out.println("====================================\n");
        
        int num;
        while ( (num = leitor.nextInt()) != 0 )
        {
            if (ehPar(num))
                System.out.printf("%d eh par!\n", num);
            else
                System.out.printf("%d nao eh par!\n", num);
        }
    }
    
}
