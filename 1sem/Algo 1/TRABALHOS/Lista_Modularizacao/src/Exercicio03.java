import java.util.Scanner;

/*
Em Java, implemente um método com a seguinte assinatura:
public static String numeroPorExtenso(int numero)
O método deve:
● Retornar o número por extenso para valores entre 1 e 999. (Exemplo: 305 → "trezentos e
cinco", 720 → "setecentos e vinte").
● Retornar a string "inválido" caso o número seja menor que 1 ou maior que 999.
 */

public class Exercicio03
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
    
    public static final String[] centenas = {
        "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos",
        "seiscentos", "setecentos", "oitocentos", "novecentos"
    };

    public static String numeroPorExtenso(int numero)
    {
        if (numero < 1 || numero > 999)
            return "inválido";
        
        if (numero < 10)
            return unidades[numero - 1];
        
        if (numero > 10 && numero < 20)
            return dez_dezenove[numero - 10];
        
        if (numero == 100)
            return "cem";
        
        int centena = numero / 100;
        int resto = numero % 100;
        
        int dezena = resto / 10;
        int unidade = numero % 10;

        String resultado = "";
        
        if (centena > 0)
            resultado += centenas[centena - 1];
            
        if (resto > 0)
        {
            if (resultado != "")
                resultado += " e ";
            
            if (resto < 10)
                resultado += unidades[resto - 1];
            else if (resto >= 10 && resto < 20)
                resultado += dez_dezenove[resto - 10];
            else
            {
                resultado += dezenas[dezena - 2];
                if (unidade > 0)
                    resultado += " e " + unidades[unidade - 1];
            }
        }
        
        return resultado;
    }
    
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite um numero de 1 a 999:");
        System.out.println("Digite 0 para finalizar o programa.");
        System.out.println("====================================\n");
        
        int num;
        while ( ( num = leitor.nextInt() ) != 0)
        {
            System.out.println( numeroPorExtenso(num) );
        }
    }
}
