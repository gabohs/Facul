/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuário
 */
public class Barbeiro extends Thread {

   private Barbearia barbearia;
   private boolean cortando = true;

   public Barbeiro(Barbearia barbearia) {
      this.barbearia = barbearia;
      System.out.println("*** Barbeiro criado.");
   }

   @Override
   public void run() {
      while (cortando) {
         barbearia.cortarCabelo();
         try {
            sleep((int) (Math.random() * 3000));
         } catch (Exception e) {
         }
      }
   }
}
