import java.util.Scanner;

/* EX 12
Uma empresa de produtos esportivos realizará uma ação de marketing que consiste em instalar
uma tirolesa entre os dois prédios do centro da cidade. Conhecendo a altura (em metros) dos
prédios e a distância entre eles, escreva um algoritmo para calcular a extensão da tirolesa. (É
possível resolver utilizando o teorema de Pitágoras
 */

public class Exercicio12 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Altura Predio 1:");
        double aP1 = leitor.nextDouble();
        
        System.out.println("Altura Predio 2:");
        double aP2 = leitor.nextDouble();
        
        System.out.println("Distancia entre os predios:");
        double distP = leitor.nextDouble();
        
        double extTirolesa = Math.sqrt(
            Math.pow(distP, 2) + Math.pow(Math.abs(aP1 - aP2), 2)
        );
        
        System.out.println("A extensao da tirolesa eh " + extTirolesa + "m");
    }
    
}
