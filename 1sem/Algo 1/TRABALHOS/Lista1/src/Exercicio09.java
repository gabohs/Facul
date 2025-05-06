import java.util.Scanner;

/* EX. 9
O piloto de uma aeronave conduz os passageiros e tripulantes por uma rota fixa cuja distância é
sabida. Quando o avião está em controle manual, o piloto define a velocidade média de
cruzeiro e a mantém aproximadamente constante. Eventualmente, durante uma parte da viagem
(em geral no início), ele coloca o sistema no piloto automático, o qual estabelece uma
velocidade média automática, durante um intervalo de tempo fixo. Escreva um algoritmo que
leia a extensão da rota, a velocidade média de cruzeiro, a velocidade média automática e o
intervalo de piloto automático. Em seguida calcule e exiba:

a) O tempo previsto para completar a viagem, considerando a extensão da rota e a velocidade
média de cruzeiro;
b) A extensão do trecho voado em piloto automático, considerando a velocidade média
automática e o intervalo informado;
c) A diferença entre a extensão da rota e a extensão do trecho de piloto automático;
d) O tempo restante para a viagem, considerando o tempo previsto e o intervalo em piloto
automático;
e) A velocidade média necessária para completar a extensão do trecho que ainda falta, dentro
do tempo restante previsto.
f) O tempo que seria completada toda a extensão da rota, caso fosse toda feita com piloto
automático (considerando a velocidade média automática);
 */

public class Exercicio09 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Extensao da rota (km): ");
        double extRota = leitor.nextDouble();
        
        System.out.println("Velocidade media de cruzeiro (km/h):");
        double vM_Cruzeiro = leitor.nextDouble();
        
        System.out.println("Velocidade media automatica (km/h):");
        double vM_Auto = leitor.nextDouble();
        
        System.out.println("Tempo de piloto automatico (h): ");
        double intAuto = leitor.nextDouble();
        
        double tTotal = extRota / vM_Cruzeiro;
        double distEmAuto = vM_Auto * intAuto;
        double difRotaAuto = extRota - distEmAuto;
        double tRestante = Math.abs(tTotal - intAuto);
        double vM_Restante = difRotaAuto / tRestante;
        double tComAuto = extRota / vM_Auto;
        
        System.out.println("Tempo previsto para completar a viagem:                     " + tTotal + "h");
        System.out.println("Trecho em piloto automatico:                                " + distEmAuto + "km");
        System.out.println("Diferenca entre ext. da Rota e trecho em piloto Automatico: " + difRotaAuto + "km");
        System.out.println("Tempo restante de viagem:                                   " + tRestante + "h");
        System.out.println("Velocidade media necessaria p completar o  trecho restante: " + vM_Restante + "km/h");
        System.out.println("Tempo em caso de piloto automatico constante:               " + tComAuto + "h");
    }
    
}
