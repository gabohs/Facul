import java.util.Scanner;

/* EX 15
Vanicléia deseja pintar seu apartamento, e quer um algoritmo que calcule tudo que ela precisa.
Ela vai informar a área total do apartamento (em m2), o preço da lata de tinta (em reais, podendo
haver centavos) e o rendimento de uma lata (em m2). Não se preocupe com a altura das paredes
(tecnicamente chamada de “pé direito"), pois ela vai considerar uma medida padrão que não vem
ao caso. Ela quer saber quantas latas de tinta precisa comprar e quanto vai gastar no total. Note
que só é possível comprar latas inteiras e nunca uma fração de lata.
 */

public class Exercicio15 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Area total do apartamento (m2):");
        double areaAp = leitor.nextDouble();
        
        System.out.println("Preco da tinta (reais):");
        double precoTinta = leitor.nextDouble();
        
        System.out.println("Rendimento de uma lata de tinta (m2):");
        double rendTinta = leitor.nextDouble();
        
        int latasNecessarias = (int) Math.ceil(areaAp / rendTinta);
        double gastoTotal = latasNecessarias * precoTinta;
        
        System.out.println(
                "Voce precisara de " + latasNecessarias + " latas e gastara " + gastoTotal + " reais"
        );  
    }
}
