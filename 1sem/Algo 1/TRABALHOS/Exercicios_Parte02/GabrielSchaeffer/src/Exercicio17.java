import java.util.Scanner;

/* EX 17
Um congresso vai emitir certificado para um participante se ele estiver presente pelo menos 75%
das horas. O usuário vai informar quantas horas tem o congresso no total e quantas horas o
participante compareceu. O número de horas é sempre inteiro.
*/

public class Exercicio17 
{

    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Total de horas do congresso: ");
        int tHorasCongresso = leitor.nextInt();
        
        System.out.println("Total de horas em que o participante esteve presente: ");
        int horasPart = leitor.nextInt();
        
        double frequencia = (double) horasPart / tHorasCongresso * 100; 
        System.out.print("A frequencia do usuario foi de " + frequencia + "%, portanto ");
                
        boolean recebeCertificado = horasPart >= (0.75 * tHorasCongresso);
        if (recebeCertificado)
        {
            System.out.println("recebe o certificado");
        }
        else
        {
            System.out.println("nao recebe o certificado");
        }
        
    }
}
