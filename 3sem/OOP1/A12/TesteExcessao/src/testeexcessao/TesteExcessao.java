package testeexcessao;

import java.io.FileNotFoundException;

public class TesteExcessao 
{   
    public static void main(String[] args) 
    {
        System.out.println("Inicio do main");
        metodo1();
        
        teste_arquivo();
        System.out.println("Fim do main");
    }
    
    public static void metodo1()
    {
        System.out.println("Inicio do metodo 1");
        metodo2();
        System.out.println("Fim do metodo 1");
    }
    
    public static void metodo2()
    {
        System.out.println("Inicio do metodo 2");
        
        int[] array = new int[10];
        
        try
        {
            for (int i = 0; i < 15; i++)
            {
                array[i] = i;
                System.out.println(i);
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ERRO: " + e);
        }
        
        System.out.println("----");
        
        for (int i = 0; i < 15; i++)
        {
            try 
            {
                array[i] = i;
                System.out.println(i);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("ERRO: " + e);
            }
        }
        
        System.out.println("Fim do metodo 2");
    }
    
    public static void teste_divisao()
    {
        int i = 5571;
        i = i / 0; // ArithmeticException
        System.out.println("O resultado " + i);
    }
    
    public static void teste_null()
    {
        // Conta c = null;
        // System.out.println("Saldo atual " + c.getSaldo()); -> NullPointerException
    }
    
    public static void teste_arquivo()
    {
        try
        {
            new java.io.FileInputStream("arquivo.txt");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Arquivo nao encontrado: " + e);
        }
        
        
    }
}
