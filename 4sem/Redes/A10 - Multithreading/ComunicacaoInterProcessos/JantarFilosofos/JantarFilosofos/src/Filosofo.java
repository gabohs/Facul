/*
 * Filosofo.java
 *
 * Created on 16 de Abril de 2007, 10:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import javax.swing.JPanel;
import java.util.ArrayList;

/**
 *
 * @author adario
 */
public class Filosofo implements Runnable {

    private static int N = 0;

    public static enum Estados {

        PENSANDO, COMENDO, FAMINTO
    };
    
    private static ArrayList<Estados> situacao = new ArrayList<Estados>();
    private static ArrayList<Filosofo> convidados = new ArrayList<Filosofo>();
    private JPanel painel;
    private String nome;
    private int meuNumero;
    private boolean executar = true;
    private static final Object mutex = new Object();

    /** Creates a new instance of Filosofo */
    public Filosofo(JPanel painel, String nome) {
        this.painel = painel;
        this.nome = nome;
        Estados meuEstado = Estados.PENSANDO;
        situacao.add(meuEstado);
        meuNumero = Filosofo.N;
        Filosofo.N++;
        convidados.add(this);
    }

    public Filosofo(JPanel painel) {
        this(painel, "");
    }

    private void setEstado(Estados e) {
        situacao.set(meuNumero, e);
        painel.repaint();
    }

    public void pensar() {
        setEstado(Estados.PENSANDO);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public void comer() {
        setEstado(Estados.COMENDO);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
/*
    public void pegaGarfos() {
        synchronized (this) {
            setEstado(Estados.FAMINTO);
            testa(getMeuNumero());
        }
        try {
            this.wait();
        } catch (InterruptedException e) {
        }
    }

    public synchronized void deixaGarfos() {
        situacao.set(meuNumero, Estados.PENSANDO);
        testa(getNumeroEsquerda(meuNumero));
        testa(getNumeroDireita(meuNumero));
    }
*/
    public void pegaGarfos() {
    synchronized (mutex) {
        setEstado(Estados.FAMINTO);
        testa(meuNumero);
        while (getEstado() != Estados.COMENDO) {
            try {
                mutex.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public void deixaGarfos() {
    synchronized (mutex) {
        setEstado(Estados.PENSANDO);
        testa(getNumeroEsquerda(meuNumero));
        testa(getNumeroDireita(meuNumero));
    }
}


    public Estados getEstado() {
        return situacao.get(meuNumero);
    }

    public String getNome() {
        return nome;
    }

    public int getMeuNumero() {
        return meuNumero;
    }

    public static int getNumeroEsquerda(int i) {
        return (i + N - 1) % N;
    }

    public static int getNumeroDireita(int i) {
        return (i + 1) % N;
    }
/*
    public static void testa(int i) {
        if (convidados.get(i).getEstado() == Estados.FAMINTO &&
                convidados.get(getNumeroEsquerda(i)).getEstado() != Estados.COMENDO &&
                convidados.get(getNumeroDireita(i)).getEstado() != Estados.COMENDO) {
            convidados.get(i).setEstado(Estados.COMENDO);
            convidados.get(i).notify();
        }
    }
*/
    private static void testa(int i) {
    if (convidados.get(i).getEstado() == Estados.FAMINTO &&
            convidados.get(getNumeroEsquerda(i)).getEstado() != Estados.COMENDO &&
            convidados.get(getNumeroDireita(i)).getEstado() != Estados.COMENDO) {
        convidados.get(i).setEstado(Estados.COMENDO);
        mutex.notifyAll();
    }
}
    public void paraExecucao() {
        this.executar = false;
    }

    @Override
    public void run() {
        while (executar) {
            pensar();
            pegaGarfos();
            comer();
            deixaGarfos();
        }
    }
}
