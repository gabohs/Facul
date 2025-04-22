import java.util.Scanner;

public class LeituraTeclado 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite o primero valor: ");
        int a = leitor.nextInt();
        
        System.out.println("Digite o segundo valor: ");
        int b = leitor.nextInt();
        
        int soma = a + b;
        
        System.out.println("Soma entre os valores: " + soma);
    }
    
}
