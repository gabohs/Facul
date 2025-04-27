import java.util.Scanner;

/*

Vanderson trabalha num laboratório químico e analisa experimentos com diferentes substâncias. 
Ele precisa medir a temperatura atual da substância que está num recipiente opaco e hermeticamente fechado. 
A partir desse valor, considerando a tabela abaixo, deve informar em que estado (sólido, liquido ou gasoso) 
se encontra a substância. A temperatura de fusão é aquela em que muda de sólido para liquido. 
A temperatura de ebulição é aquela em que muda de líquido para gasoso. 
Entre as temperaturas de fusão e ebulição, a substância está sempre no estado líquido. 
Escreva um programa para, baseado no código da substância e sua atual temperatura, informar o estado.

CODIGO     SUBSTANCIA          T. DE FUSAO      T. DE EBULICAO     
1          cloroformio         -63.5            61,2
2          proprano            -190             -45
3          eter etilico        -116             35

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
