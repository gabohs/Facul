/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Vector;

/**
 *
 * @author Alexandro
 */
public class Estoque {

   private Vector<Produto> produtos = new Vector<Produto>();

   public Estoque() {
      for (int i = 0; i < 5; i++) {
         produtos.add(
               new Produto(
               Math.round((float) Math.random() * 10)));
         System.out.print("Prod: " + i + " Quant:");
         System.out.println(produtos.get(i).getQuantidade());
      }
   }

   public void vende(int codProduto) {
      Produto produto = produtos.get(codProduto);
//      synchronized (produto) {
      synchronized (this) {
         int quantidade = produto.getQuantidade();
         while (quantidade == 0) {
            System.out.print("FALTA Prod "+codProduto+" - ");
            for(Produto item : produtos)
               System.out.print(" "+item.getQuantidade());
            System.out.println("");
            try {
//               produto.wait();
               wait();
            } catch (InterruptedException exc) {
            }
            quantidade = produto.getQuantidade();
         }
         produto.setQuantidade(quantidade - 1);
         System.out.println("Venda - Prod: "+codProduto);
//         produto.notify();
         notify();
      }
   }

   public void compra(int codProduto) {
      Produto produto = produtos.get(codProduto);
//      synchronized (produto) {
      synchronized (this) {
         int quantidade = produto.getQuantidade();
         while (quantidade == 10) {
            System.out.print("EXCESSO Prod "+codProduto+" - ");
            for(Produto item : produtos)
               System.out.print(" "+item.getQuantidade());
            System.out.println("");
            try {
//               produto.wait();
               wait();
            } catch (InterruptedException exc) {
            }
            quantidade = produto.getQuantidade();
         }
         produto.setQuantidade(quantidade + 1);
         System.out.println("Compra - Prod: "+codProduto);
//         produto.notify();
         notify();
      }
   }
}
