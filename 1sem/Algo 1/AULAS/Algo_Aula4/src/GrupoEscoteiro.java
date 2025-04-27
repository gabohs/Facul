import java.util.Scanner;

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
