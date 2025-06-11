public class Potencia
{
    public static int potencia_it(int base, int expoente)
    {
        int result = 1;
        for (int i = expoente; i > 0; i--)
        {
            result *= base;
        }
        
        return result;
    }
    
    public static int potencia_rec(int base, int expoente)
    {
        if (expoente > 0)
            return base * potencia_rec(base, expoente - 1);
        else
            return 1;
    }

    public static void main(String[] args)
    {
        System.out.println("Potencia iterativa:");
        System.out.printf("5^5 = %d\n10^4 = %d\n", potencia_it(5, 5), potencia_it(10, 4));
        
        System.out.println("\n=======================================================\n");
        
        System.out.println("Potencia recursiva:");
        System.out.printf("5^5 = %d\n", potencia_rec(5, 5));
    }  
}
