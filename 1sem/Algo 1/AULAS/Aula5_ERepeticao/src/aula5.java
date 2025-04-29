import java.util.Scanner;

public class aula5
{   
    public static Scanner leitor = new Scanner(System.in);
    
    public static void loopFor()
    {
        for (int i = 1; i <= 10; i++)
        {
            System.out.println(i);  
        }
        
        System.out.println("\n");
        
        for (int i = 10; i > 0; i--)
        {
            System.out.println(i);
        }
        
        System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=");
    }
    
    public static void loopWhile()
    {
       double valor;
       while ( (valor = leitor.nextDouble()) >= 0)
       {   
           double raiz = Math.sqrt(valor);
           System.out.println("Raiz = " + raiz);
       }
    }
    
    public static void doWhile()
    {
        double valor = leitor.nextInt();
        
        do
        {
            double raiz = Math.sqrt(valor);
            System.out.println("Raiz: " + raiz);
        } while (valor >= 0);
    }
    
    public static void main(String[] args)      
    {
        // loopFor();
        //loopWhile();
        doWhile();
    } 
}
