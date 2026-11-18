package semsincronizacao;

public class SemSincronizacao 
{
    public static int contador = 0;
    public static final int n_somas = 1000;
    
    public static class Somador extends Thread
    {
        @Override
        public void run()
        {
            for (int i = 0; i < n_somas; i++)
                contador++;
        }
    }
    
    public static void main(String[] args) 
    {
        Somador thread1 = new Somador();
        Somador thread2 = new Somador();
        
        thread1.start();
        thread2.start();
        
        try
        {
           thread1.join();
           thread2.join(); 
        }
        catch (InterruptedException ex) 
        {
            System.out.println("InterruptedException");
        }
        
        System.out.println("Valor do contador depois das somas: " + contador);
    }
}
