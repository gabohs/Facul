
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alexandro
 */
public class MinhaThread implements Runnable {

    private static int NUMERO;
    public static final int LIMITE = 100000;
    private boolean incrementador = true;

    public MinhaThread(boolean incrementa) {
        this.incrementador = incrementa;
    }

    public void incrementa() {
        if (NUMERO < LIMITE) {
            this.NUMERO++;
            for(int i=0; i<10;i++);
      }
    }

    public void decrementa() {
        if (NUMERO > 0) {
            this.NUMERO--;
            for(int i=0; i<10000;i++);
}
    }

    public void run() {
        while (true) {
            synchronized (this) {
                System.out.print("N=" + NUMERO);
                if (incrementador) {
                    this.incrementa();
                } else {
                    this.decrementa();
                }
                System.out.println(" N=" + NUMERO + " ");
            }
        }
    }
}
