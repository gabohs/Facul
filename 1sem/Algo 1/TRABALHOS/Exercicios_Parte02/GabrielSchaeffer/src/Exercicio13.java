import java.util.Scanner;

/* EX 13
Um barqueiro navega diariamente entre dois píeres (considerando apenas a viagem de ida) e
sabe a extensão do trajeto linear que o barco faz. Ele também conhece a distância relativa entre
os dois píeres. Com essas informações, ele gostaria de ter um algoritmo para calcular a largura
do rio.
 */

public class Exercicio13 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Trajeto linear do barco:");
        double trajBarco = leitor.nextDouble();
        
        System.out.println("Distancia relativa entre os pieres:");
        double distPiers = leitor.nextDouble();
        
        double larguraRio = Math.sqrt(
                Math.pow(trajBarco, 2) - Math.pow(distPiers, 2)
        );
        
        System.out.println("A largura do rio e " + larguraRio + "m");
    }
}
