import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;

public class Tela extends javax.swing.JFrame 
{
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Tela.class.getName());

    private JDesktopPane desktop = new JDesktopPane(); 
    
    private void abre_calculadora()
    {
        Calculadora frame_calc = new Calculadora();
        frame_calc.setVisible(true);
        
        desktop.add(frame_calc);
        
        try
        {
            frame_calc.setSelected(true);
            frame_calc.setEnabled(true);
        }
        catch (PropertyVetoException e) { }
    }
    
    private void abre_temperatura() 
    {
        Temperaturas frame_temp = new Temperaturas();
        frame_temp.setVisible(true);
        
        desktop.add(frame_temp);
        
        try
        {
            frame_temp.setSelected(true);
            frame_temp.setEnabled(true);
        }
        catch (PropertyVetoException e) { }
    }
    
    public Tela() 
    {
        initComponents();
        
        this.setContentPane(desktop);
        
        MenuHandler mh = new MenuHandler();
        miCalculadora.addActionListener(mh);
        miTemperatura.addActionListener(mh);
        miSair.addActionListener(mh);
    }
    
    private class MenuHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if (e.getSource() == miCalculadora)
                abre_calculadora();
            
            if (e.getSource() == miTemperatura)
                abre_temperatura();
            
            if (e.getSource() == miSair)
                System.exit(0);
        }  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miCalculadora = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miTemperatura = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miSair = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Calculadora");

        miCalculadora.setText("Realizar Calculos");
        jMenu1.add(miCalculadora);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Temperatura");

        miTemperatura.setText("Converter Temperaturas");
        jMenu2.add(miTemperatura);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Sair");

        miSair.setText("Sair do Sistema");
        jMenu3.add(miSair);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) 
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Tela().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem miCalculadora;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuItem miTemperatura;
    // End of variables declaration//GEN-END:variables
}
