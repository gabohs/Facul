import java.util.Scanner;

/* EX 14
Um topógrafo precisa calcular a altura real de um edifício. Ele define a distância do teodolito ao
edifício, e o teodolito tem uma altura de 1,70 m. A cada medida, o teodolito informa o ângulo (em
graus) de observação da extremidade superior do edifício. Escreva um algoritmo que,
conhecendo a distância do teodolito e o ângulo de observação, calcule a altura do edifício. (É
possível resolver conhecendo as relações trigonométricas.
 */

public class Exercicio14 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        final double altTeodolito = 1.7;
        
        System.out.println("Distancia entre o teodolito e o predio");
        double distTeod = leitor.nextDouble();
        
        System.out.println("Angulo de observacao");
        double angulo = leitor.nextDouble() * Math.PI / 180;
        
        double hipotenusa = distTeod / Math.cos(angulo);
       
        double altPredio = ( Math.sin(angulo) * hipotenusa ) + altTeodolito;
        
        System.out.println("A altura do predio eh " + altPredio);
    }   
}
