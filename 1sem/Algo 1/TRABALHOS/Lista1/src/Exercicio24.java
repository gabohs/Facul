import java.util.Scanner;

/* EX 24
Escreva um algoritmo que leia um valor real qualquer e apresente uma mensagem dizendo em
qual dos seguintes intervalos ([0,25], (25,50], (50,75], (75,100]) este valor se encontra. Caso o
valor não esteja em nenhum destes intervalos, deve ser impressa a mensagem “Fora de
intervalo”. Na descrição dos intervalos, um colchetes (“[” ou “]”) indica a extremidade de um
intervalo fechado (inclui o valor extremo, é “maior ou igual” ou “menor ou igual”), e um
parênteses (“(” ou “)”) indica a extremidade de um intervalo aberto (não inclui o valor extremo, é
“maior que” ou “menor que”).
 */

public class Exercicio24
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite um valor real qualquer:");
        double a = leitor.nextDouble();
        
        if (a > 0 && a <= 25)
        {
            System.out.println(a + " esta no intervalo [0, 25]");
        }
        
        else if (a > 25 && a <= 50)
        {
            System.out.println(a + " esta no intervalo (25, 25]");
        }
        else if (a > 50 && a <= 75)
        {
            System.out.println(a + " esta no intervalo (50, 75]");
        }
        else if (a > 75 && a <= 100)
        {
            System.out.println(a + " esta no intervalo (75, 100]");
        }
        else
        {
            System.out.println("Fora de intervalo.");
        }
    }  
}
