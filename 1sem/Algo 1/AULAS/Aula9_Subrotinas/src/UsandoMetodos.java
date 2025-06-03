import java.util.Scanner;

public class UsandoMetodos
{   
    static Scanner leitor = new Scanner(System.in);
    
    public static int soma(int valor1, int valor2)
    {
        return valor1 + valor2;
    }
    
    public static double nextDoubleA(String mensagem)
    {
        System.out.print(mensagem);
        return leitor.nextDouble();
    }
    
    public static void main(String[] args)
    {
        int a = 10;
        int b = 23;
        
        System.out.printf("(%d + %d) = %d\n", a, b, soma(a, b) );
        
        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
        
        System.out.println("Digite um numero: ");
        double valor = leitor.nextDouble(); 
        
        double novo = nextDoubleA("Digite um numero: ");
    }  
}
