import java.util.Scanner;

/* Ex. 8
O sistema de metrô de uma cidade possui diversas linhas com trajeto fixo. Os trens do metrô são
automáticos e podem ser configurados com uma velocidade média padrão. Em algumas
situações, é preciso alterar essa velocidade padrão, seja por questões de segurança, tráfego
intenso ou redução no número de viagens. Escreva um algoritmo que leia a extensão total do
trajeto de uma linha, a velocidade média padrão para essa linha e a velocidade média
ajustada (quando ocorrem as alterações mencionadas). Em seguida calcule e exiba:
a) O tempo previsto para completar a viagem, considerando a extensão total e a velocidade
média padrão;
b) O tempo efetivo para completar a viagem, considerando a extensão total e a velocidade
média ajustada;
c) A diferença de tempo entre as duas situações;
d) A distância que é possível percorrer considerando a velocidade média ajustada e o tempo
previsto original;
e) A diferença entre a extensão total e a distância possível com a velocidade média ajustada.
 */

public class Exercicio08 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Extensao total da linha (km): ");
        double extTotal = leitor.nextDouble();
        
        System.out.println("Velocidade media padrao da linha (km/h): ");
        double vM_Padrao = leitor.nextDouble();
        
        System.out.println("Velocidade media ajustada (em caso de emergencia): ");
        double vM_Ajustada = leitor.nextDouble();
        
        double tempoTotal = extTotal / vM_Padrao;
        double tempoEfetivo = extTotal / vM_Ajustada;
        double difTempo = Math.abs(tempoTotal - tempoEfetivo);
        double distanciaPossivel = tempoTotal * vM_Ajustada;
        double difDistancias = extTotal - distanciaPossivel;
        
        System.out.println("Tempo previsto de viagem:               " + tempoTotal + "h");
        System.out.println("Tempo efetivo de viagem:                " + tempoEfetivo + "h");
        System.out.println("Diferenca de tempo:                     " + difTempo + "h");
        System.out.println("Distancia Possivel:                     " + distanciaPossivel + "km");
        System.out.println("Dif. entre ext. total e dist. possivel: " + difDistancias + "km");
        
    }
    
}
