import java.util.Scanner;

/*
Em Java, implemente um método com a seguinte assinatura:
public static String numeroPorExtenso(int numero)
O método deve:
● Retornar o número por extenso para valores entre 1 e 99. (Ex.: 21 → "vinte e um", 42 →
"quarenta e dois")
● Retornar a string "inválido" caso o número seja menor que 1 ou maior que 99.
 */

public class Exercicio02
{   
    public static final String[] unidades = {
        "um", "dois", "três", "quatro", "cinco", 
        "seis", "sete", "oito", "nove"
    };

    public static final String[] dez_dezenove = {
        "dez", "onze", "doze", "treze", "quatorze",
        "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"
    };

    public static final String[] dezenas = {
        "vinte", "trinta", "quarenta", "cinquenta",
        "sessenta", "setenta", "oitenta", "noventa"
    };

    public static String numeroPorExtenso(int numero)
    {
        if (numero < 1 || numero > 99)
            return "inválido";
        
        if (numero < 10)
            return unidades[numero - 1];
        
        if (numero >= 10 && numero < 20)
            return dez_dezenove[numero - 10];
        
        int dezena = numero / 10; // ex: numero = 30 -> 30 / 10 => 3
        int unidade = numero % 10; // ex: numero = 32 - > 32 % 10 => 2

        if (unidade == 0)
            return dezenas[dezena - 2]; 
        else 
            return dezenas[dezena - 2] + " e " + unidades[unidade - 1];
        
    }
    
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite um numero de 1 a 99:");
        System.out.println("Digite 0 para finalizar o programa.");
        System.out.println("====================================\n");
        
        int num;
        while ( ( num = leitor.nextInt() ) != 0)
        {
            System.out.println( numeroPorExtenso(num) );
        }
    }
}
