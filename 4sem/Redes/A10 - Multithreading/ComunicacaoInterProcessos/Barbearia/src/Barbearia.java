/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuário
 */
public class Barbearia {

   private static int MAXCADEIRAS = 5;
   private int totalClientes = 0;
   //private int cadeirasEspera = MAXCADEIRAS;
   private boolean dormindo = true;

   public synchronized void cortarCabelo() {
      try {
         while (totalClientes == 0) {
            System.out.println("*** Nao tem clientes para atender. Vou dormir!");
            dormindo = true;
            wait();
            dormindo = false;
         }
         System.out.println("*** Mais um cliente satisfeito!");
         totalClientes--;
         notifyAll();
      } catch (InterruptedException e) {
      }

   }

   public synchronized void aguardaVez() {
      try {
         while (totalClientes < MAXCADEIRAS) {
            if (dormindo == true) {
         System.out.println("### Vou Acordar esse barbeiro pra trabalhar!");
               
               notify();
//               dormindo = false;
            }
            wait();
         }
         totalClientes++;
         notifyAll();
      } catch (InterruptedException e) {
      }
   }

   public int getQuantidadeCliente() {
      return totalClientes;
   }
}
