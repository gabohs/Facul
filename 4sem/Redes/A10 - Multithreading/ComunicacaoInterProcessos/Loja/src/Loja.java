/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandro
 */
public class Loja {
   public static void main(String[] args) {
      Estoque meuEstoque = new Estoque();
      Vendas vendedores = new Vendas(meuEstoque);
      Compras compradores = new Compras(meuEstoque);

      Thread comp0 = new Thread(compradores);
      Thread comp1 = new Thread(compradores);
      Thread comp2 = new Thread(compradores);
      Thread comp3 = new Thread(compradores);
      Thread comp4 = new Thread(compradores);

      Thread vend0 = new Thread(vendedores);
      Thread vend1 = new Thread(vendedores);
      Thread vend2 = new Thread(vendedores);
      Thread vend3 = new Thread(vendedores);

      Thread[] vend = new Thread[10];
      for(int i = 0; i<10; i++){
         vend[i] = new Thread(vendedores);
         vend[i].start();
      }

      comp0.start();
      comp1.start();
      comp2.start();
      comp3.start();
      comp4.start();

   }
}
