import java.util.Scanner;

/* EX. 10
Josevaldo divide seu salário sempre em 11 partes iguais, e a primeira despesa que paga é o
aluguel de seu apartamento. Escreva um algoritmo que solicite o valor do salário de Josevaldo
(em reais) e quantas partes usa para pagar o aluguel num dado mês. Em seguida, calcule:

a) O valor pago (em reais) pelo aluguel.
b) O percentual de seu salário utilizado para pagar o aluguel.
 */

public class Exercicio10 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Salario do Josevaldo (reais): ");
        double salario = leitor.nextDouble();
        double salarioPartes = salario / 11;
        
        System.out.println("Quantas das 11 partes do salario foram destinadas ao aluguel: ");
        double partesAluguel = leitor.nextDouble();
        
        double valorAluguel = salarioPartes * partesAluguel;
        double percentualAluguel = (partesAluguel / 11) * 100;
        
        System.out.println("Valor em reais do aluguel: " + valorAluguel);
        System.out.println("Porcentagem do salario destinada ao aluguel: " + percentualAluguel + "%");
    }
    
}
