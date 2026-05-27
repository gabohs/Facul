package exercicioexcessaostring;

public class ExercicioExcessaoString 
{
    public static void main(String[] args) 
    {
        // ex1_converter();
        try
        {
            ex2_converter();
        }
        catch(NullPointerException e)
        {
            System.out.println("Nao eh possivel converter uma string nula");
        }
        
    }
    
    private static void ex1_converter()
    {
        String frase = "teste";
        String novaFrase = null;
        
        try
        {
            novaFrase = frase.toUpperCase();
        }
        catch (NullPointerException e)
        {
            System.out.println("Nao eh possivel converter uma string nula");
        }
        
        System.out.println("Frase antiga: "+ frase);
        System.out.println("Frase nova: "+ novaFrase);
    }
    
    // --------------------------------------------------------------------
    
    private static void ex2_converter() throws NullPointerException
    {
        String frase = null;
        String novaFrase = null;
        
        novaFrase = frase.toUpperCase();
        
        System.out.println("Frase antiga: "+ frase);
        System.out.println("Frase nova: "+ novaFrase);
    }
    
    // ---------------------------------------------------------------------
}
