import java.util.Scanner;

/*
Implemente uma funcao recursiva que calcule a multiplicacao de 2 numeros inteiros.
 */

public class Exercicio01
{   
//    public static int calculaMultIt(int a, int b)
//    {   
//        int result = 0;
//        for (int i = 0; i < b; i++)
//        {
//            result += a;
//        }
//        
//        return result;
//    }
    
    public static int calculaMultRec(int a, int b)
    {   
        //System.out.println("Chamando funcao para a = " + a + " b = " + b);
        if (b > 0)
            return a + calculaMultRec(a, b - 1); 
        else
            return 0;
    }
              
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int a = leitor.nextInt();
        int b = leitor.nextInt();
        
        int result = calculaMultRec(a, b);
        
        System.out.println(result);
    }  
}
