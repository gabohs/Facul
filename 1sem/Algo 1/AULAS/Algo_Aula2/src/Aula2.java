import java.util.Scanner;

public class Aula2 
{
    public static void TiposDivisao()
    {
        double x = 1 / 2;
        System.out.println("1 / 2 = " + x);
        
        x = 1.0 / 2;
        System.out.println("1.0 / 2 = " + x);
        
        int a = 7, b = 2;
        x = a / b;
        System.out.println("a / b = " + x);
        
        x = a / (double) b;
        System.out.println("a / (double) b = " + x);
        
        x = ( (double) a ) / b;
        System.out.println("(double) a / b = " + x);
    }
    
    // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    
    public static void main(String[] args) 
    {
        TiposDivisao();
    }
    
}
