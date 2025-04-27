import java.util.Scanner;

/* EX 21
 Leia um valor inteiro, que é o tempo de duração em segundos de um determinado evento em um
laboratório, e informe-o expresso no formato dias-horas:minutos:segundos.
 */

public class Exercicio21 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
         
        System.out.println("Tempo de duracao do evento (segundos): ");
        int duracao = leitor.nextInt(); 
        
        int dias     = (duracao / 86400);         // dividir por 86400 converte de segundos para dias
        int horas    = (duracao / 3600) % 24;     // dividir por 3600 converte de segundos para horas
        int minutos  = (duracao / 60) % 60;       // dividir por 60 converte de segundos para minutos
        int segundos = (duracao % 60);     
        
        System.out.println(dias + "d-" + horas + "h:" + minutos + "m:" + segundos + "s");
    }
}
