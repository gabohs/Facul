import java.util.Scanner;

/* EX 18
Vladislau quer calcular o frete de uma encomenda, após informar o valor total comprado. Se o
valor for inferior a R$120,00, o frete será igual a R$15,00; do contrário, está isento do valor do
frete. Informe o valor total a ser cobrado, incluindo o frete.
 */

public class Exercicio18 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        final int frete = 15; 
        
        System.out.println("Valor da encomenda: ");
        double valEnc = leitor.nextDouble();
        
        if (valEnc < 120)
        {
            System.out.println("Sua compra nao eh elegivel para frete gratis.");
            System.out.println("FRETE: " + frete + "   TOTAL A PAGAR: " + (valEnc + frete) );
        }
        else
        {
            System.out.println("Sua compra eh elegivel para frete gratis!");
            System.out.println("TOTAL A PAGAR: " + valEnc);
        }
    }
}
