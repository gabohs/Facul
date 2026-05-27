package criarexcecao;

public class SemLetraBException extends Exception 
{
    @Override
    public String getMessage()
    {
        return "Nao existe letra B em sua frase";   
    }
}
