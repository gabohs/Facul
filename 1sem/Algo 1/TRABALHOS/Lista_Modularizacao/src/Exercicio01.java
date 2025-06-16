import java.util.Scanner;

/*

Em Java, implemente um método com a seguinte assinatura:
public static String numeroPorExtenso(int numero)
O método deve:
● Retornar o número por extenso (ex: 1 → "um", 2 → "dois", ..., 20 → "vinte").
● Retornar "inválido" se o número for menor que 1 ou maior que 20.
 */

public class Exercicio01
{   
    
    public static final String[] strings = {
        "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove",
        "dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove", "vinte"
    };

    public static String numeroPorExtenso(int numero)
    {
        if (numero < 1 || numero > 20)
            return "inválido";
        
        return strings[numero - 1];
    }
    
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite um numero de 1 a 20:");
        System.out.println("Digite 0 para finalizar o programa.");
        System.out.println("====================================\n");
        
        int num;
        while ( ( num = leitor.nextInt() ) != 0)
        {
            System.out.println( numeroPorExtenso(num) );
        }
    }
}
