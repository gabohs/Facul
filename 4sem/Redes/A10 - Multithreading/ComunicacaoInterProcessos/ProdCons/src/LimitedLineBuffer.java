import java.util.*;

public class LimitedLineBuffer {
   private LinkedList<String> queue;
   private int tamanho;

   public LimitedLineBuffer(int size) {
      queue = new LinkedList<String>();
      tamanho = size;
   }

   public synchronized void put(String line) {
      while(queue.size() == tamanho) {
         System.out.println("Buffer cheio!!!");
         try {
            this.wait();
         } catch (InterruptedException e) {
            this.notify();
            return;
         }
      }
      queue.add(new String(line));
      this.notify();
  }

   public synchronized String get() {
      while(queue.size() == 0) {
         System.out.println("Buffer vazio!!!");
         try {
            this.wait();
         } catch (InterruptedException e) {
            this.notify();
            return null;
         }
      }
      String item = queue.removeFirst();
      this.notify();
      return item;
   }
}
