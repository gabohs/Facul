package testeex3;

public class TesteEx3 
{
   public static void main(String[] args) 
   {
       Thread t = new Thread(() -> {
           try 
           {
               System.out.println("Iniciando...");
               Thread.sleep(2000);
               System.out.println("Fim da tarefa.");
           } 
           catch (InterruptedException e) 
           {
               Thread.currentThread().interrupt();
           }
       });
       
       t.start();
       
       try 
       {
           t.join();
       } 
       catch (InterruptedException e) 
       {
           e.printStackTrace();
       }
       
       System.out.println("Continuando...");
   }
}
