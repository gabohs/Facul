/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandro
 */
public class Compras implements Runnable {

   private Estoque estoque;
   private int instancia;

   public Compras(Estoque estoque) {
      this.estoque = estoque;
   }

   @Override
   public void run() {
      int codProduto = instancia;
      instancia++;
      while (true) {
         estoque.compra(codProduto);
         try {
            Thread.sleep((int) Math.floor(Math.random() * 2000));
         } catch (InterruptedException exc) {
         }
      }
   }
}
