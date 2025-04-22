import java.util.Scanner;

/* EX. 3
Leia o salário base de um vendedor e o valor total de suas vendas no mês. Calcule o salário
final, sabendo que é igual ao valor do salário base adicionado de uma comissão de 15% sobre o
valor total de suas vendas.
 */

public class Exercicio03 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        final double bonusPorVenda = 0.15;
        
        System.out.println("Salario base do vendedor: ");
        double salBase = leitor.nextDouble();
        
        System.out.println("Total de vendas no mes: ");
        double vendasMes = leitor.nextDouble();
        
        double salFinal = salBase + ( bonusPorVenda * vendasMes );
        
        System.out.println("O salario final do vendedor e: " + salFinal);
    }
    
}
