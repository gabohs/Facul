import java.util.Scanner;

/* EX 31

Faça um algoritmo que receba o salário de um funcionário, calcule e mostre o novo salário,
acrescendo a bonificação, e adicionando o auxílio escola, baseado no salário já com bonificação.

SALÁRIO                         BONIFICAÇÃO
Até R$ 500,00                   12% do salário
Entre R$ 500,00 e R$ 1.200,00   5% do salário
Acima de R$ 1.200,00            Sem bonificação


SALÁRIO              AUXÍLIO ESCOLA
Até R$ 600,00        R$ 150,00
Mais que R$ 600,00   R$ 100,00

 */


public class Exercicio31
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Salario do Funcionario:");
        double salario = leitor.nextDouble();
        
        // bonificacao
        if (salario <= 500)
        {
            salario += salario * .12;
        }
        else if (salario <= 1200)
        {
            salario += salario * .05;
        }
        
        // auxilio escola
        if (salario <= 600)
        {
            salario += 150;
        }
        else
        {
            salario += 100;
        }
        
        System.out.println("Salario reajustado: " + salario);
    }
}
