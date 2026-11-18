
import java.io.*;

public class TestThreads {

    public static void main(String[] args) {
        LimitedLineBuffer meuBuffer = new LimitedLineBuffer(10);

        Produtor P1 = new Produtor(meuBuffer);
        Consumidor C1 = new Consumidor(meuBuffer);
        
        Thread tp = new Thread(P1, "Produtor de linhas");
        Thread tp2 = new Thread(P1, "Outro Produtor");
        Thread tc = new Thread(C1, "Consumidor de Linhas");
        Thread tc2 = new Thread(C1, "Outro Consumidor");

        tp.start();
        tp2.start();
        tc.start();
        tc2.start();

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

        return;
    }
}
