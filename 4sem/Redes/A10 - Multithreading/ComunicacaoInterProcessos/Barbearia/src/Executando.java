/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuário
 */
public class Executando {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      Barbearia barbearia = new Barbearia();
      
      new Thread(new Barbeiro(barbearia)).start();
      
      
      
   }
}
