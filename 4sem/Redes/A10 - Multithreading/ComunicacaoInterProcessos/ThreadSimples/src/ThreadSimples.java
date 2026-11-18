/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandro
 */
public class ThreadSimples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MinhaThread t1 = new MinhaThread(true);
       MinhaThread t2 = new MinhaThread(false);
       
       Thread exec1 = new Thread(t1);
       Thread exec2 = new Thread(t2);
       
       exec1.start();
       exec2.start();
    }

}
