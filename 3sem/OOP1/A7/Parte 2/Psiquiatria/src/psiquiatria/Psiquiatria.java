package psiquiatria;

public class Psiquiatria 
{
    public static void main(String[] args) 
    {
       Humor h1  = new Humor();
       Feliz f1  = new Feliz();
       Triste t1 = new Triste();
       
       System.out.println("Como vc se sente?");
       
       h1.escreveHumor();
       f1.escreveHumor();
       t1.escreveHumor();
       
       // --------------------------------------------------
       
       System.out.println("");
       
       Psiquiatra p1 = new Psiquiatra();
       p1.examinar(h1);
       p1.examinar(f1);
       p1.examinar(t1);
       
       p1.observar(f1);
       p1.observar(t1);
    }
    
}
