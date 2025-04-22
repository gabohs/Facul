import java.util.Scanner;

/* EX. 5
Um ciclista precisa percorrer uma distância, em quilômetros, e sabe qual velocidade média vai
empreender nesse trecho. Escreva um algoritmo que solicite esses dois valores e calcule o
tempo necessário (em horas) para esse deslocamento.
 */

public class Exercicio05 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Distancia (km): ");
        double dS = leitor.nextDouble();
        
        System.out.println("Velocidade media (km/h): ");
        double vM = leitor.nextDouble();
        
        double dT = dS / vM;
        System.out.println("A distancia foi percorrida em " + dT + " horas");
    }
    
}
