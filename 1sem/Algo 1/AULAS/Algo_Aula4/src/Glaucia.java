import java.util.Scanner;


public class Glaucia 
{
    public static void main(String[] args) 
    {   
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Largura do Aquario: ");
        double largura = leitor.nextDouble(); // largura eh igual ao diametro da esfera
        
        double raioEsfera = largura / 2;
        
        double areaSuperficial = 4 * Math.PI * Math.pow(raioEsfera, 2); 
        double volumeEsfera = (4 * Math.PI * Math.pow(raioEsfera, 3)) / 3;
        
        System.out.println("Area superficial da esfera: " + areaSuperficial + " cm2");
        System.out.println("Volume da esfera: " + volumeEsfera / 1000 + " L");
        
    }
    
}
