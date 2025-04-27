import java.util.Scanner;

/*

O Grupo Escoteiro Francisco de Assis vai participar de um evento externo. Para essa participação, 
o número de chefes adultos necessários depende do número de jovens que irão participar. 
Inicialmente é preciso saber o número de escoteiros e escoteiras. A cada 6 jovens, é preciso haver um adulto. 
Sempre deve haver mais 1 chefe extra no total de chefes. 
Se houver alguma escoteira participando, ao menos 1 dos chefes deve ser do sexo feminino. 
Se houver algum escoteiro participando, ao menos 1 dos chefes deve ser do sexo masculino.


ex: 
1 escoteiro e 1 escoteira - total de 2 chefes, sendo que 1 deve ser homem e 1 mulher 
2 escoteiros - total de 2 chefes, ao menos 1 deve ser homem.
2 escoteiras - total de 2 chefes, ao menos 1 deve ser mulher 
6 escoteiros - total de 2 chefes, ao menos 1 deve ser homem
13 escoteiras e 6 escoteiros - total de 5 chefes, é preciso haver ao menos 1 homem e 1 mulher.

*/

public class GrupoEscoteiro 
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Quantos escoteiros vao participar:");
        int escoteiros = leitor.nextInt();
        
        System.out.println("Quantas escoteiras vao participar:");
        int escoteiras = leitor.nextInt();
        
        int totalParticipantes = escoteiros + escoteiras;
        
        int numChefes = (int) ( Math.ceil(totalParticipantes / 6.0) ) + 1; // + 1 chefe extra
        
        System.out.println("Numero de chefes: " + numChefes);
        
        if (escoteiros > 0)
        {
            System.out.println("Eh preciso ter pelo menos 1 chefe homem");
        }
        if (escoteiras > 0)
        {
            System.out.println("Eh preciso ter pelo menos 1 chefe mulher");
        }
    }
}
