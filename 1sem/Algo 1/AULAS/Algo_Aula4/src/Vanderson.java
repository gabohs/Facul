import java.util.Scanner;

/*

*/

public class Vanderson 
{   
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Informe o codigo da substancia: ");
        int codigo = leitor.nextInt();
        
        System.out.println("Informe a temperatura da substancia: ");
        double temperatura = leitor.nextDouble();
        
        double tabelaTemp[][] = { 
            {-63.5, 61.2},                                // subst. 1 -> cloroformio
            {-190, -45},                                  // subst. 2 -> propano
            {-116, 35}                                    // subst. 3 -> eter etilico
        };
        
        if (temperatura < tabelaTemp[codigo - 1][0])      // referente à respectiva temp. de fusão
        {
            System.out.println("Estado solido");
        }
        else if (temperatura < tabelaTemp[codigo - 1][1]) // referente à respectiva temp. de ebulição
        {
            System.out.println("Estado liquido");
        }
        else
        {
            System.out.println("Estado gasoso");
        }
    }
    
}
