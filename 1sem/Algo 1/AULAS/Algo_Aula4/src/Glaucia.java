import java.util.Scanner;

/*

Glaucia Gonçalo está projetando aquários praticamente esféricos. Com base na largura (em centímetros, cm) 
do aquário, que também é o diâmetro da esfera, ela vai definir a área superficial da esfera 
(em cm2, que corresponde ao quanto de vidro ela irá necessitar) e calcular o volume 
(em cm3, que vai indicar a capacidade em litros, L)


AreaSuperficialEsfera  = 4 * PI * raio^2
VolumeEsfera           = 4/3 * PI * raio^3 
1cm3                   = 0.001L

*/

public class Glaucia 
{
    public static void main(String[] args) 
    {   
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Largura do Aquario (cm): ");
        double largura = leitor.nextDouble(); // largura eh igual ao diametro da esfera
        
        double raioEsfera = largura / 2;
        
        double areaSuperficial = 4 * Math.PI * Math.pow(raioEsfera, 2); 
        double volumeEsfera = (4 * Math.PI * Math.pow(raioEsfera, 3)) / 3;
        
        System.out.println("Area superficial da esfera: " + areaSuperficial + " cm2");
        System.out.println("Volume da esfera: " + volumeEsfera / 1000 + " L");
    } 
}
