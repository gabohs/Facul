import java.util.Scanner;

/* EX 30
A nota final de um estudante é calculada a partir de três notas atribuídas, respectivamente, a um
trabalho de laboratório, a uma avaliação semestral e a um exame final. A média ponderada das
três notas mencionadas obedece aos pesos fixos a seguir.

NOTA                        PESO
Trabalho de Laboratório     2
Avaliação Semestral         3
Exame Final                 5

Faça um algoritmo que receba as três notas, calcule e exiba a média ponderada e o conceito
final (em letra), que segue a tabela abaixo.

MÉDIA PONDERADA      CONCEITO
9,0 a 10,0           A
7,5 a 8,9            B
5,0 a 7,4            C
3,0 a 4,9            D            
0,0 a 2,9            E 

 */

public class Exercicio30
{
    public static void main(String[] args)
    {   
        Scanner leitor = new Scanner(System.in);
        // pesos
        final int p1 = 2; 
        final int p2 = 5; 
        final int p3 = 3; 
        
        System.out.println("Digite as notas do estudante: ");
        
        System.out.print("Trabalho de laboratorio: ");
        double tLab = leitor.nextDouble();
        
        System.out.print("Avaliacao semestral: ");
        double aSem = leitor.nextDouble();
        
        System.out.print("Exame final: ");
        double eF = leitor.nextDouble();
        
        double mediaP = ((tLab * p1) + (aSem * p2) + (eF * p3)) / (p1 + p2 + p3);
        System.out.println("\nMedia Ponderada: " + mediaP);
        
        String conceito = "";
        
        if (mediaP >= 9.0)
        {
            conceito = "A";
        }
        else if (mediaP >= 7.5)
        {
            conceito = "B";
        }
        else if (mediaP >= 5.0)
        {
            conceito = "C";
        }
        else if (mediaP >= 3.0)
        {
            conceito = "D";
        }
        else
        {
            conceito = "E";
        }
        
        System.out.println("CONCEITO: " + conceito);
    } 
}
