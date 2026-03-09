package matematica;

public class Matematica 
{
    public static void main(String[] args) 
    {
        Media m = new Media();
        
        System.out.println(m.calcular_media_1());
        m.calcular_media_2(4, 9);
        m.calcular_media_3();
        System.out.println(m.calcular_media_4(5, 13));
    }
    
}
