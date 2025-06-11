public class Fatorial
{   
    // Fatorial iterativo
    public static int fatorial_it(int n)
    {   
        int result = 1;
        for (int i = n; i > 1; i--)
        {
            result *= i;
        }
        
        return result;
    }
    
    // Fatorial recursivo
    public static int fatorial_rec(int n)
    {   
        // System.out.print("Invocando fatorial para " + n + "  ");
        if (n > 1)
            return n * fatorial_rec(n - 1);
        else
            return 1;
    }
    
    public static void main(String[] args)
    {
        System.out.println("Fatorial iterativo:");
        System.out.printf("5! = %d\n10! = %d\n", fatorial_it(5), fatorial_it(10));
        
        System.out.println("\n=======================================================\n");
        
        System.out.println("Fatorial recursivo:");
        System.out.printf("5! = %d\n", fatorial_rec(5));
        
    }
    
}
