import java.io.*;

public class Consumidor extends Thread {
   private LimitedLineBuffer meuBuffer;
   private boolean mustFinish = false;
   
   public Consumidor(LimitedLineBuffer b) {
      meuBuffer = b;
   }

   public void stopRunning() {
      mustFinish = true;
   }
   
   public void run() {
      String novaLinha = new String();
      while(!mustFinish  && !isInterrupted()) {
         novaLinha = meuBuffer.get();
         if (!mustFinish)
            System.out.println("CONS: "+novaLinha);
      }
      return;
   }
}