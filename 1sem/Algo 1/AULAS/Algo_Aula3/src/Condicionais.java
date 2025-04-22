import java.util.Scanner;

public class Condicionais 
{   
    public static void calculoRaiz()
    {
        Scanner leitor = new Scanner(System.in);
        double valor = leitor.nextDouble();
        
        if (valor >= 0)
        {
            double raiz = Math.sqrt(valor);
            System.out.println("A raiz quadrada de " + valor + " eh " + raiz);
        }
        System.out.println("Fim");
    }
    
    public static void parOuImpar()
    {
        Scanner leitor = new Scanner(System.in);
        int valor = leitor.nextInt();
        int resto = valor % 2;
        
        if (resto == 0)
        {
            System.out.println(valor + " eh par!");
        }
        else
        {
            System.out.println(valor + " eh impar!"); 
        }
    }
    
    public static void positivoZeroNegativo()
    {
        Scanner leitor = new Scanner(System.in);
        int valor = leitor.nextInt();
        
        if (valor > 0)
        {
            System.out.println("Positivo!");
        }
        else
        {
            if (valor < 0)
            {
                System.out.println("Negativo!");
            }
            else
            {
                System.out.println("O numero eh 0");
            }
        }
    }
    
    public static void categoriaAtleta()
    {   
        System.out.println("Ano de nascimento do atleta: ");
        Scanner leitor = new Scanner(System.in);
        int ano = leitor.nextInt();
        
        switch (ano)
        {   
            case 2018:
            case 2017:
                System.out.println("Categoria Mirim");
                break;
                
            case 2016:
            case 2015:
                System.out.println("Categoria Infantil");
                break;
                
            case 2014:  
            case 2013:
            case 2012:
                System.out.println("Categoria Pre-Juvenil");
                break;
                
            case 2011:
            case 2010:
            case 2009:
                System.out.println("Categoria Juvenil");
                
            default:
                System.out.println("Ano de nascimento invalido");
        }
    }
    
    public static void main(String[] args) 
    {
        // calculoRaiz();
        // parOuImpar();
        // positivoZeroNegativo();
        categoriaAtleta();
    }
    
}
