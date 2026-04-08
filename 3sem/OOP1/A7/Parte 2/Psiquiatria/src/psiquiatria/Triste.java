package psiquiatria;

public class Triste extends Humor
{
    @Override
    protected String getHumor()
    {
        return "Triste";
    }
    
    public void chorar()
    {
        System.out.println("BUUUUUAAAAAAAA");
    }
           
    
}
