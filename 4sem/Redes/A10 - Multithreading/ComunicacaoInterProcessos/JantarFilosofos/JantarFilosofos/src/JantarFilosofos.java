/*
 * JantarFilosofos.java
 *
 * Created on 16 de Abril de 2007, 10:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author adario
 */
public class JantarFilosofos extends JPanel {

   private int convidados;
   private String nomes[];
   private ArrayList<Garfo> garfos;
   private ArrayList<Filosofo> filosofos;

   /** Creates a new instance of JantarFilosofos */
   public JantarFilosofos(int convidados, String[] nomes) {
      setSize(300, 300);
      garfos = new ArrayList<Garfo>();
      filosofos = new ArrayList<Filosofo>();
      this.convidados = convidados;
      if (nomes != null) {
         if (nomes.length != convidados) {
            throw new IllegalArgumentException("numero de nomes invalido");
         } else {
            this.nomes = nomes;
         }
      }
      int esq, dir;
      for (int i = 0; i < this.convidados; i++) {
         this.garfos.add(new Garfo());
      }
      for (int i = 0; i < this.convidados; i++) {
         if (i % 2 == 0) {
            esq = (i + 1) % convidados;
            dir = i % convidados;
         } else {
            dir = (i + 1) % convidados;
            esq = i % convidados;
         }
         if (nomes == null) {
            System.out.println("FilosofoNovo " + i + " com esquerda " + esq +
                    " e direita " + dir);
            filosofos.add(new Filosofo(this));
         } else {
            System.out.println("FilosofoNovo " + nomes[i] + " com esquerda " +
                    esq + " e direita " + dir);
            filosofos.add(new Filosofo(this, nomes[i]));
         }
      }
   }

   public JantarFilosofos(int convidados) {
      this(convidados, null);
   }

   public int getConvidados() {
      return convidados;
   }

   public String[] getNomes() {
      return nomes;
   }

   public ArrayList<Filosofo> getFilosofos() {
      return filosofos;
   }

   public void iniciaJanta() {
      for (Filosofo f : filosofos) {
         new Thread(f).start();
      }
   }

   public void encerraJanta() {
      for (Filosofo f : filosofos) {
         f.paraExecucao();
      }
   }

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      int centroY = this.getHeight() / 2;
      int centroX = this.getWidth() / 2;
      double rMesa = Math.min(centroY, centroX) / 1.4;
      double rF = rMesa * 2 / this.convidados;
      centroX -= rF / 2;
      centroY -= rF / 2;
      double divMesa = Math.PI * 2 / this.convidados;
      int i = 0;
      for (Filosofo f : filosofos) {
         Filosofo.Estados temp = f.getEstado();
         if (temp == Filosofo.Estados.COMENDO) {
            g2d.setColor(Color.GREEN);
         } else {
            if (temp == Filosofo.Estados.FAMINTO) {
               g2d.setColor(Color.RED);
            } else {
               g2d.setColor(Color.YELLOW);
            }
         }
         double cantoX = centroX + Math.cos(divMesa * i) * rMesa;
         double cantoY = centroY + Math.sin(divMesa * i) * rMesa;
         g2d.fill(new Ellipse2D.Double(cantoX, cantoY, rF, rF));
         g2d.setColor(Color.BLACK);
         Font novaFonte = new Font("Minha", Font.BOLD, (int) (rF/2.5));
         g2d.setFont(novaFonte);
         g2d.drawString(f.getNome(), (float) cantoX, (float) cantoY);
         i++;
      }
   }

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      String nomes[] = {"Danton", "Robespierre", "Socrates", "Platao", "Aristoteles", "Assis", "Ronaldo"};
      final JantarFilosofos novaJanta = new JantarFilosofos(7, nomes);
      JFrame janela = new JFrame("Jantar dos Filosofos!");
      janela.add(novaJanta, BorderLayout.CENTER);
      janela.setSize(300, 300);
      janela.addWindowListener(new WindowAdapter() {

         @Override
         public void windowClosing(WindowEvent e) {
            novaJanta.encerraJanta();
            System.exit(0);
         }
      });
      janela.setVisible(true);
      novaJanta.iniciaJanta();
   }
}
