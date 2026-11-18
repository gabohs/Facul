import java.io.*;

public class Produtor extends Thread {
   LimitedLineBuffer meuBuffer;
   private boolean mustFinish = false;
   
   public Produtor(LimitedLineBuffer b) {
      meuBuffer = b;
   }

   public void stopRunning() {
      mustFinish = true;
   }
   
   public void run() {
      int i = 0;
      while(!mustFinish && !isInterrupted()) {
         meuBuffer.put("Linha " + i++);
         System.out.println("PROD: Armazenada Linha"+ i);
      }
      return;
   }
   
}
