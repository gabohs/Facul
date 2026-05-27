package testethread;

public class TesteThread 
{
    public static void main(String[] args) 
    {
        MinhaThread mt1 = new MinhaThread("#1", 500);
        MinhaThread mt2 = new MinhaThread("#2", 1000);
        MinhaThread mt3 = new MinhaThread("#3", 700);
        
        Thread t1 = new Thread(mt1);
        t1.start();
        Thread t2 = new Thread(mt2);
        t2.start();
        Thread t3 = new Thread(mt3);
        t3.start();
        
        while (t1.isAlive() || t2.isAlive() || t3.isAlive())
        {
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        
        System.out.println("Programa finalizado");
    }
}
