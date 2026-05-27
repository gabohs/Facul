import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Tela extends javax.swing.JFrame 
{
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Tela.class.getName());

    Produto produtos[] = new Produto[10];
    private int qtd = 0;
    
    public Tela() 
    {
        initComponents();
        
        btnCadastrar.addActionListener( new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try
                {
                    if (qtd >= produtos.length)
                        throw new Exception("Vetor cheio");
                
                    String nome = tfdNome.getText();
                    double preco = Double.parseDouble(tfdPreco.getText());

                    Produto p = new Produto(nome, preco);
                    produtos[qtd] = p;
                    qtd++;

                    JOptionPane.showMessageDialog(null, "Produto Cadastrado!");
                } 
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
            }    
        });
        
        btnListar.addActionListener( new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                txaLista.setText("");
                for (int i = 0; i < qtd; i++)
                {
                    txaLista.append(produtos[i].mostrarDados() + "\n");
                }
            }    
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfdNome = new javax.swing.JTextField();
        tfdPreco = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaLista = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Produtos");

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setText("CADASTRO DE PRODUTOS");

        jLabel2.setText("NOME:");

        jLabel3.setText("PRECO:");

        tfdNome.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        tfdPreco.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        btnCadastrar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnCadastrar.setText("CADASTRAR");

        btnListar.setText("Listar Produtos");

        txaLista.setColumns(20);
        txaLista.setRows(5);
        jScrollPane1.setViewportView(txaLista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(btnCadastrar)))
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListar))
                        .addGap(173, 173, 173))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfdPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(btnCadastrar)
                .addGap(45, 45, 45)
                .addComponent(btnListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
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
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JTextField tfdPreco;
    private javax.swing.JTextArea txaLista;
    // End of variables declaration//GEN-END:variables
}
