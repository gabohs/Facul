/*
 * Garfo.java
 *
 * Created on 16 de Abril de 2007, 16:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandro
 */
public class Garfo {

   private boolean esta_livre;

   /** Creates a new instance of Garfo */
   public Garfo() {
      esta_livre = true;
   }

   public synchronized void pegar() throws InterruptedException {
      while (!esta_livre) {
         wait();
      }
      esta_livre = false;
   }

   public synchronized void largar() {
      esta_livre = true;
      notify();
   }
}
