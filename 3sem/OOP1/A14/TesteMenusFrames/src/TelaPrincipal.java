import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;


public class TelaPrincipal extends javax.swing.JFrame 
{
    private JDesktopPane desktop = new JDesktopPane();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPrincipal.class.getName());

    public TelaPrincipal() 
    {
        initComponents();
        
        this.setContentPane(desktop);
    } 
    
    private void criarFrameCadastroClientes()
    {
        CadastroClientes frame1 = new CadastroClientes();
        frame1.setVisible(true);
        
        desktop.add(frame1);
        
        try
        {
            frame1.setSelected(true);
            frame1.setEnabled(true);
        }
        catch (PropertyVetoException e)
        {
            
        }
    }
    
    private void criarFrameCadastroProdutos()
    {
        CadastroProdutos frame2 = new CadastroProdutos();
        frame2.setVisible(true);
        
        desktop.add(frame2);
        
        try
        {
            frame2.setSelected(true);
            frame2.setEnabled(true);
        }
        catch (PropertyVetoException e)
        {
            
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Cadastros");

        jMenuItem1.setText("Clientes");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Produtos");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Fornecedores");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Nota Fiscal");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Relatorios");

        jMenuItem5.setText("Clientes");
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Produtos");
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Fornecedores");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Nota Fiscal");
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Sair");

        jMenuItem9.setText("Sair do sistema");
        jMenuItem9.addActionListener(this::jMenuItem9ActionPerformed);
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1004, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        criarFrameCadastroClientes();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal().setVisible(true));
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
