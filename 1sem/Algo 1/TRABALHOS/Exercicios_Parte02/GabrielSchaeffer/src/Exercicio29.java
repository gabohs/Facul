import java.util.Scanner;

/* EX 29
 Escreva um algoritmo que faça um conjunto de perguntas e categorize um animal com base nas
características informadas. O animal pode ser ave ou mamífero, e onívoro ou carnívoro. A
classificação deve ser feita como aparece na figura abaixo (figura no pdf):
 */

public class Exercicio29
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Classifique o animal:");
        
        System.out.println("(1) ave   (2) mamifero: ");
        int e1 = leitor.nextInt(); // escolha 1
        
        System.out.println("(1) onivoro   (2) carnivoro");
        int e2 = leitor.nextInt(); // escolha 2
        
        if (e1 == 1) // ave
        {
            if (e2 == 1) // onivoro
            {
                System.out.println("O animal e um pombo.");
            }
            else // carnivoro
            {
                System.out.println("O animal e uma aguia.");
            }
        }
        
        else if (e1 == 2)
        {
            if (e2 == 1) // onivoro
            {
                System.out.println("O animal e um porco.");
            }
            else // carnivoro
            {
                System.out.println("O animal e uma onca.");
            }
        }
        else
        {
            System.out.println("Classificacao invalida!");
            return;
        }
    }
}
