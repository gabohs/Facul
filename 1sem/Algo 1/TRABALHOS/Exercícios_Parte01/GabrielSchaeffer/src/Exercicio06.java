import java.util.Scanner;

/* Ex. 6
Uma patrulha de escoteiros anda numa trilha com uma velocidade aproximadamente constante
durante um dado intervalo de tempo. Escreva um algoritmo que, conhecendo a velocidade e o
tempo, calcule a distância percorrida pela patrulha.
 */

public class Exercicio06 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Velocidade Media da patrulha (km/h): ");
        double vM = leitor.nextDouble();
        
        System.out.println("Intervalo de tempo (h): ");
        double dT = leitor.nextDouble();
        
        double distancia = vM * dT;
        
        System.out.println("A distancia percorrida pela patrulha foi de " + distancia + " km");
    }
    
}
