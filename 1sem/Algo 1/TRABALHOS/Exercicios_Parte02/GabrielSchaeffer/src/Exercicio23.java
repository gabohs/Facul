import java.util.Scanner;

/* EX 23
Leia 3 valores reais (real) A, B e C, que correspondem aos coeficientes de uma equação do 2º
grau. Em seguida, realize as seguintes verificações e cálculos dos itens abaixo:

( A ) Se o valor de A for zero, exiba a mensagem “Nao e uma equacao do 2o grau” e encerre
o programa.
( B ) Se o valor de B ou C for zero, exiba a mensagem “Equacao incompleta”, do contrário,
exiba “Equacao completa”.
( C ) Calcule e exiba o valor do “delta” (Δ), cuja fórmula é ∆ = 𝑏 .
2 − 4 • 𝑎 • 𝑐
( D ) Se o delta for negativo, exiba a mensagem “Nao ha raízes reais para a equacao”.
( E ) Se o delta for zero, exiba a mensagem “Ha uma raiz real para a equacao”.
( F ) Se o delta for positivo, exiba a mensagem “Ha duas raízes reais para a equacao”.
( G ) Se for possível, conforme os itens anteriores, calcule e exiba as raízes da equação
 */

public class Exercicio23
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite os 3 coeficientes da equacao:");
        
        double a = leitor.nextDouble();
        double b = leitor.nextDouble();
        double c = leitor.nextDouble();
       
        // ( A )
        if (a == 0) 
        {
            System.out.println("Nao e uma equacao do 2o grau.");
            return;
        }   
              
        // ( B )
        if (b == 0 || c == 0)
        {
            System.out.println("Equacao incompleta.");
        }
        else
        {
            System.out.println("Equacao completa.");
        }
        
        // ( C )
        double delta = Math.pow(b, 2) - 4 * a * c;
        System.out.println("DELTA: " + delta);
        
        // ( D ), ( E ) , ( F ) e ( G ) 
        if (delta < 0)
        {
            System.out.println("Nao ha raizes reais para a equacao");
        } 
        else if (delta == 0)
        {   
            double x = -b / (2 * a); 
            System.out.println("Ha uma raiz real para a equacao: " + x);
            
        }
        else
        {   
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            
            System.out.println("Ha duas raizes reais para a equacao: " + x1 + " e " + x2);
        }   
    }
}
