package psiquiatria;

public class Psiquiatra 
{
    public void examinar(Humor humor)
    {
        System.out.println("Fale-me objeto, como vc se sente hoje?");
        humor.escreveHumor();
        System.out.println("");
    }
    
    
    // Tipo 2 de polimorfismo: polimorfismo de sobrecarga (function overloading), estatico (tempo de compilacao)
    public void observar(Triste t)
    {
        t.chorar();
        System.out.println("Mas bah, o cara ta triste\n");
    }
    
    public void observar(Feliz f)
    {
        f.rir();
        System.out.println("Uau, vc esta feliz hoje!");
    }
}
