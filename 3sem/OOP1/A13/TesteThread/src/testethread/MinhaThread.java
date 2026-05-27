package testethread;

public class MinhaThread implements Runnable
{
    private String nome;
    private int tempo;
    
    public MinhaThread(String nome, int tempo)
    {
        this.nome = nome;
        this.tempo = tempo;
        
        //Thread t = new Thread();
        //t.start();
    }
    
    @Override
    public void run()
    {
        try
        {
            for (int i = 0; i < 6; i++)
            {
                System.out.println(this.nome + "    Contador: " + i);
                Thread.sleep(tempo);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
        System.out.println(this.nome + " TERMINOU!");
        
    }
}
