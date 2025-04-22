import java.util.Scanner;

/* EX. 11
Neusimaria comprou uma certa quantidade de carne para fazer um churrasco com a família.
Contudo ela esqueceu de verificar o preço do quilograma, e sabe apenas o quanto pagou pelo
total da quantidade comprada. Escreva um algoritmo que solicite a quantidade (em quilogramas)
comprada, e o valor pago, informando qual é o valor por quilo.
 */

public class Exercicio11 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Quantidade de carne comprada (kG): ");
        double quantComprada = leitor.nextDouble();
        
        System.out.println("Valor total pago (reais): ");
        double valPago = leitor.nextDouble();
        
        double valKG = valPago / quantComprada;
        
        System.out.println("O valor do kG da carne eh " + valKG + " reais");
    }
    
}
