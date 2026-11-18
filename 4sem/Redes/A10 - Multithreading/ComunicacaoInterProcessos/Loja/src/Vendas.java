/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandro
 */
public class Vendas implements Runnable {

   private Estoque estoque;

   public Vendas(Estoque estoque) {
      this.estoque = estoque;
   }

   @Override
   public void run() {
      int codProduto;
      while (true) {
         codProduto = (int) Math.floor(Math.random() * 5);
         estoque.vende(codProduto);
         try {
            Thread.sleep((int) Math.floor(Math.random() * 2000));
         } catch (InterruptedException exc) {
         }
      }
   }
}
