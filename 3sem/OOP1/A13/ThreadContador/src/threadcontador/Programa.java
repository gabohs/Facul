package threadcontador;

public class Programa implements Runnable
{
    private int id;
    
    @Override
    public void run()
    {
        for (int i = 0; i < 10000; i++)
        {
            System.out.println("Programa: " + this.id + "   Valor: " + i);
        }
    }
    
    public void setId(int valor)
    {
        this.id = valor;
    }
}
