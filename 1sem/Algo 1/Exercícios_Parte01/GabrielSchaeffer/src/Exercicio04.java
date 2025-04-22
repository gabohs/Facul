import java.util.Scanner;

/* EX. 4
Um motorista dirigiu uma distância, em quilômetros, durante um período de alguns minutos.
Escreva um algoritmo que solicite esses dois valores e calcule a velocidade média do
deslocamento em km/h
 */
public class Exercicio04 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Distancia (km): ");
        double dS = leitor.nextDouble();
        
        System.out.println("Tempo (minutos): ");
        double dT = leitor.nextDouble();
        
        double vM = dS / (dT / 60);
        
        System.out.println("A velocidade media foi de " + vM + " km/h");
        
    } 
}
