package criarexcecao;

public class CriarExcecao 
{
    public static void main(String[] args)
    {
        String frase = "Eu sou um teste b!";
        
        try
        {
            if (!frase.contains("b") && !frase.contains("B"))
                throw new SemLetraBException();
        } 
        catch(SemLetraBException e)
        {
            System.out.println("Sem B na frase");
        }      
    }
    
}
