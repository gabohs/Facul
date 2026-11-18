
import java.io.*;

public class TestThreads_1 {

    public static void main(String[] args) {
        LimitedLineBuffer meuBuffer = new LimitedLineBuffer(10);

        Produtor P1 = new Produtor(meuBuffer);
        Consumidor C1 = new Consumidor(meuBuffer);
        Thread tp = new Thread(P1, "Produtor de linhas");
        Thread tp2 = new Thread(P1, "Outro Produtor");
        Thread tc = new Thread(C1, "Consumidor de Linhas");
        Thread tc2 = new Thread(C1, "Outro Consumidor");

        //try {
            tp.start();
            tp2.start();
            tc.start();
            tc2.start();
            /*tp.join();
        } catch (InterruptedException e) {
            P1.stopRunning();
            C1.stopRunning();
            e.printStackTrace();
        } finally {*/
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
            C1.stopRunning();
            P1.stopRunning();
            tc.interrupt();
            tp.interrupt();
            tp2.interrupt();
            tc2.interrupt();
        //}
        return;
    }
}
