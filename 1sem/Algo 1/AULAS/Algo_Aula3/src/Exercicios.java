import java.util.Scanner;

public class Exercicios 
{   
    public static void Ex_01()
    {
        /*
        Dado o lado de um quadrado calcule a medida da diagonal. 
        Em seguida, calcule o comprimento da circunferencia  na qual o quadrado esteja inscrito
        */
        
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Lado do quadrado: ");
        double lado = leitor.nextDouble();
        
        double diagonal = lado * Math.sqrt(2);
        double circunferencia = Math.PI * diagonal;
        
        System.out.println("A diagonal do quadrado eh: " + diagonal);
        System.out.println("A circunferencia na qual o quadrado esta inscrito eh: " + circunferencia);    
    }
    
    public static void main(String[] args) 
    {
        Ex_01();
    }
    
}
