import java.util.Scanner;

/* EX 25
Leia 2 valores reais X e Y, que devem representar as coordenadas de um ponto em um plano
cartesiano. A seguir, determine em qual o quadrante está localizado o ponto, ou se está sobre
um dos eixos cartesianos (“eixo Y”, se X =0, ou “eixo X”, se Y = 0) ou se está na “origem” (X
= Y = 0).
 */

public class Exercicio25
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Coordenada X:");
        double x = leitor.nextDouble();
        
        System.out.println("Coordenada Y:");
        double y = leitor.nextDouble();
        
        if (x == 0 && y == 0) 
        {
            System.out.printf("(%.2f, %.2f) esta na origem\n", x, y);
        } 
        else if (y == 0) 
        {
            System.out.printf("(%.2f, %.2f) esta sobre o eixo X\n", x, y);
        } 
        else if (x == 0) 
        {
            System.out.printf("(%.2f, %.2f) esta sobre o eixo Y\n", x, y);
        } 
        else if (y > 0 && x > 0) 
        {
            System.out.printf("(%.2f, %.2f) esta no 1 quadrante\n", x, y);
        } 
        else if (y > 0 && x < 0) 
        {
            System.out.printf("(%.2f, %.2f) esta no 2 quadrante\n", x, y);
        } 
        else if (y < 0 && x < 0) 
        {
            System.out.printf("(%.2f, %.2f) esta no 3 quadrante\n", x, y);
        } 
        else if (y < 0 && x > 0) 
        {
            System.out.printf("(%.2f, %.2f) esta no 4 quadrante\n", x, y);
        }
    }
}
