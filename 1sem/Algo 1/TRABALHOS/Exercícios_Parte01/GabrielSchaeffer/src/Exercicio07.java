import java.util.Scanner;

/*  Ex. 7
Um motorista de ônibus sabe a distância total exata, em quilômetros, do trecho que deve
percorrer durante a viagem. Ele também conhece a velocidade média prevista que deve utilizar
durante a viagem. Quando realizou a primeira parada para lanche, ele verificou o intervalo de
tempo que já viajou. Escreva um algoritmo que leia a distância total da viagem, a velocidade
média prevista, o intervalo (em minutos) da primeira etapa da viagem. Em seguida, calcule e
exiba:

a) O tempo previsto para completar toda a viagem, considerando a distância total e a velocidade
média prevista;
b) A distância efetiva percorrida na primeira etapa, considerando o intervalo informado e a
velocidade média prevista;
c) A distância restante que ainda falta percorrer;
d) O tempo necessário para percorrer a distância restante.
 */

public class Exercicio07 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Distancia total (km): ");
        double dTotal = leitor.nextDouble();
        
        System.out.println("Velocidade media (km/h): ");
        double vM = leitor.nextDouble();
        
        System.out.println("Intervalo de tempo ate entao: (minutos): ");
        double dT = leitor.nextDouble();
        
        double tempoTotal = dTotal / vM;
        double dPercorrida = vM * (dT / 60);
        double dRestante = dTotal - dPercorrida;
        double tempoRestante = tempoTotal - (dT /60);
        
        System.out.println("Tempo previsto para completar a viagem: " + tempoTotal + " h");
        System.out.println("Distancia ja percorrida:                " + dPercorrida + " km");
        System.out.println("Distancia restante ate o destino:       " + dRestante + " km");
        System.out.println("Tempo Restante de viagem:               " + tempoRestante + " h");
    }  
}
