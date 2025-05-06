import java.util.Scanner;

/* EX 16
Godofredo ficou muito impressionado com o poder das funções exponenciais e deseja fazer um
experimento. Antes de iniciá-lo, ele quer calcular algumas simulações. A ideia é fazer uma
“corrente do bem”. Ele vai ajudar uma quantidade N de pessoas, sem interesses e sem
retribuições para si mesmo. A única condição é que, no dia seguinte, cada pessoa auxiliada deve
auxiliar outras N pessoas e “repassar a corrente”. Ele observará o experimento por 10 dias na
sua cidade, sendo que o dia 1 é o dia em que ele auxilia as N primeiras pessoas. Escreva um
algoritmo para calcular o total de pessoas auxiliadas, caso o N seja 2, 3 ou 4.
*/

public class Exercicio16 
{
    public static void main(String[] args) 
    {   
        Scanner leitor = new Scanner(System.in);
        final int totalDias = 10;
        
        System.out.println("Numero de pessoas ajudadas inicialmente: ");
        int pessoas = leitor.nextInt();
        
        if (pessoas > 1 && pessoas < 5)
        {
            int totalCorrente = (int) (pessoas *  Math.pow(pessoas, totalDias) - 1) / (pessoas - 1);
            System.out.println(totalCorrente + " pessoas serao ajudadas");
        }
        else
        {
            System.out.println("N deve ser 2, 3 ou 4");
        }   
    }
}
