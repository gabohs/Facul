import java.util.Scanner;

public class Exercicios 
{ 
    final static double Peso1 = 2.5;
    final static double Peso2 = 3.5;
    
    public static void Ex01_Media(int a, int b)
    {         
        System.out.println("\n-=-= EX. 01 - MEDIA =-=-\n");
        
        double media = (a + b) / 2;
        System.out.println("A media entre os numeros eh: " + media);
    }
    
    public static void Ex02_MediaPond(int a, int b)
    {   
        System.out.println("\n-=-= EX. 02 - MEDIA PONDERADA =-=-\n");
        
        System.out.println("Peso valor 1: " + Peso1);
        System.out.println("Peso valor 2: " + Peso2);
        
        double mediaP = ( a * Peso1 + b * Peso2  ) / Peso1 + Peso2;
        System.out.println("A media ponderada entre os numeros considerando seus respectivos pesos eh: " + mediaP);
    }
    
    public static void Ex03_Vendedor()
    {   
        System.out.println("\n-=-= EX. 03 - VENDEDOR =-=-\n");
        /*
        Leia o salario base de um vendedor e o valor total de suas vendas no mes. Calcule o salario final,
        sabendo que ele eh igual a soma do base a uma comissao de 15% sobre as vendas.
        */
        
        Scanner leitor = new Scanner(System.in);
        final double bonusPorVenda = 0.15;
        
        System.out.println("Salario base do vendedor: ");
        double salBase = leitor.nextDouble();
        
        System.out.println("Total de vendas no mes: ");
        double vendasMes = leitor.nextDouble();
        
        double salFinal = salBase + ( bonusPorVenda * vendasMes );
        
        System.out.println("O salario final do vendedor e: " + salFinal);
    }
    
    public static void Ex04_Josevaldo()
    {   
        System.out.println("\n-=-= EX. 04 - JOSEVALDO =-=-\n");
        /*
        Josevaldo tem uma rotina peculiar: divide seus salario em 11 partes iguais e paga primeiro o aluguel do apartamento.
        Crie um programa que leia o valor do salario e quantas partes usa para pagar o aluguel. Calcule:
        a) O valor em reais do aluguel
        b) O percentual do salario destinado ao aluguel
        */
        
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Salario do Josevaldo: ");
        double salario = leitor.nextDouble();
        double salarioPartes = salario / 11;
        
        System.out.println("Quantas partes do salario foram usadas para o aluguel: ");
        double partesAluguel = leitor.nextDouble();
        
        double valorAluguel = salarioPartes * partesAluguel;
        System.out.println("Valor em reais do aluguel: " + valorAluguel);
        
        double percentualAluguel = (partesAluguel / 11) * 100;
        System.out.println("Porcentagem do salario destinada ao aluguel: " + percentualAluguel + "%");
        
    }

    public static void main(String[] args) 
    {   
        /*
        * Exercicios 1 e 2 -> medias entre valores
        
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite o primero valor: ");
        int val1 = leitor.nextInt();
        
        System.out.println("Digite o segundo valor: ");
        int val2 = leitor.nextInt();
        
        Ex01_Media(val1, val2);
        Ex02_MediaPond(val1, val2); 
        */
        
        // Ex03_Vendedor();
        Ex04_Josevaldo();
    }
    
}
