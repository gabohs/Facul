/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuário
 */
public class Cliente extends Thread {

   private Barbearia barbearia;
   private boolean cortando = true;

   public Cliente(Barbearia barbearia) {
      this.barbearia = barbearia;
   }

   @Override
   public void run() {
      while (cortando) {

         barbearia.aguardaVez();
         try {
            sleep((int) (Math.random() * 3000));
         } catch (Exception e) {
         }
      }

   }
}
