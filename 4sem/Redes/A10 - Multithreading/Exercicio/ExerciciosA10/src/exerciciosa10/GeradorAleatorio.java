package exerciciosa10;

public class GeradorAleatorio 
{
    public static int gerar_aleatorio(int min, int max)
    {
        return (int) (min + Math.random() * (max - min));
    }
}
