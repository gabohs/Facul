package psiquiatria;

public class Humor 
{
    protected String getHumor()
    {
        return "Mal-Humorado";
    }
    
    // escreve na tela como o objeto se sente
    public void escreveHumor()
    {
        System.out.println("Eu me sinto " +  getHumor() + " hoje!");
    }
}
