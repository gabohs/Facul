import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;


public class TelaPrincipal extends javax.swing.JFrame 
{
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPrincipal.class.getName());
    
    private final JDesktopPane desktop = new JDesktopPane();
    
    private CriadorBD cbd = new CriadorBD();

    public TelaPrincipal() 
    {
        initComponents();
        
        this.setContentPane(desktop);
    }
    
    private void criarFrameFornecedor()
    {
        final CadastroFornecedor frameCF = new CadastroFornecedor();
        
        frameCF.setVisible(true);
        desktop.add(frameCF);
        
        try 
        {
            frameCF.setSelected(true);
            frameCF.setEnabled(true);
        } 
        catch (final PropertyVetoException e) {}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miCadastrarFornecedor = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miCriarBD = new javax.swing.JMenuItem();
        miCriarTabelas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Cadastro");

        miCadastrarFornecedor.setText("Cadastrar Fornecedor");
        miCadastrarFornecedor.addActionListener(this::miCadastrarFornecedorActionPerformed);
        jMenu1.add(miCadastrarFornecedor);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("BD");

        miCriarBD.setText("Criar BD");
        miCriarBD.addActionListener(this::miCriarBDActionPerformed);
        jMenu2.add(miCriarBD);

        miCriarTabelas.setText("Criar Tabelas");
        miCriarTabelas.addActionListener(this::miCriarTabelasActionPerformed);
        jMenu2.add(miCriarTabelas);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 763, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCadastrarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastrarFornecedorActionPerformed
        this.criarFrameFornecedor();
    }//GEN-LAST:event_miCadastrarFornecedorActionPerformed

    private void miCriarTabelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCriarTabelasActionPerformed
        cbd.criarTabelaFornecedor();
    }//GEN-LAST:event_miCriarTabelasActionPerformed

    private void miCriarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCriarBDActionPerformed
        cbd.geraBD();
    }//GEN-LAST:event_miCriarBDActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem miCadastrarFornecedor;
    private javax.swing.JMenuItem miCriarBD;
    private javax.swing.JMenuItem miCriarTabelas;
    // End of variables declaration//GEN-END:variables
}
