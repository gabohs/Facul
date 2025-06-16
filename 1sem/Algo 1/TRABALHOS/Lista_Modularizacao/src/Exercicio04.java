import java.util.Scanner;

/*
Em Java, implemente um método com a seguinte assinatura:
public static String numeroPorExtenso(int numero)
O método deve:
● Retornar o número por extenso para valores entre 1 e 99.999. (Exemplo: 12345 → "doze mil
trezentos e quarenta e cinco").
● Retornar a string "inválido" caso o número seja menor que 1 ou maior que 99.999.
 */

public class Exercicio04
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
        if (numero < 1 || numero > 99999)
            return "invalido";
        
        if (numero == 100)
            return "cem";
        
        String resultado = "";
        
        int milhar = numero / 1000;
        int resto = numero % 1000;
        
        if (milhar > 0)
        {
            if (milhar < 10)
                resultado += unidades[milhar - 1] + " mil";
        
            else if (milhar < 20)
                resultado += dez_dezenove[milhar - 10] + " mil";
            
            else if (milhar < 100)
            {
                int dezenaM = milhar / 10;
                int unidadeM = milhar % 10;
                
                resultado += dezenas[dezenaM - 2];
                if (unidadeM != 0)
                    resultado += " e " + unidades[unidadeM - 1];
                resultado += " mil";
            }
            else
            {
                int centenaM = milhar / 100;
                int restoM = milhar % 100;
                
                if (milhar == 100)
                    resultado += "cem mil";
                else
                {
                    resultado += centenas[centenaM - 1];
                    if (restoM != 0)
                    {
                        resultado += " e " + numeroPorExtenso(restoM) + " mil";
                        return resultado;
                    }
                    else
                        resultado += "mil";
                }
            }
            
            if (resto != 0)
                if (resto < 100)
                    resultado += " e ";
                else
                    resultado += " ";
        }
        
        if (resto > 0)
        {
            if (resto < 10)
                resultado += unidades[resto - 1];
            
            else if (resto < 20)
                resultado += dez_dezenove[resto - 10];
            
            else if (resto < 100)
            {
                int dezena = resto / 10;
                int unidade = resto % 10;
                
                resultado += dezenas[dezena - 2];
                if (unidade != 0)
                    resultado += " e " + unidades[unidade - 1];
            }
            else
            {
                int centena = resto / 100;
                int restoC = resto % 100;
                
                if (resto == 100)
                    resultado += "cem";
                else 
                {
                    resultado += centenas[centena - 1];
                    if (restoC != 0)
                        resultado += " e " + numeroPorExtenso(restoC);
                }   
            }
        }
        
        return resultado;
    }
    
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite um numero de 1 a 99999:");
        System.out.println("Digite 0 para finalizar o programa.");
        System.out.println("====================================\n");
        
        int num;
        while ( ( num = leitor.nextInt() ) != 0)
        {
            System.out.println( numeroPorExtenso(num) );
        }
    }
}

