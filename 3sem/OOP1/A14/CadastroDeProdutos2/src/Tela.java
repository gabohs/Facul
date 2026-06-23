import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Tela extends javax.swing.JFrame 
{
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Tela.class.getName());

    //Produto produtos[] = new Produto[10];
    
    ArrayList<Produto> produtos = new ArrayList<Produto>();
    
    public Tela() 
    {
        initComponents();
        
        btnCadastrar.addActionListener( new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try
                {
                    String nome = tfdNome.getText();
                    
                    if (nome.isEmpty())
                        throw new Exception("Campo `Nome` vazio");
                    
                    double preco = Double.parseDouble(tfdPreco.getText());
                    
                    if (preco <= 0)
                        throw new Exception("O preco deve ser maior que 0");

                    Produto p = new Produto(nome, preco);
                    produtos.add(p);

                    JOptionPane.showMessageDialog(null, "Produto Cadastrado!");
                    tfdNome.setText("");
                    tfdPreco.setText("");
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
                for (int i = 0; i < produtos.size(); i++)
                {
                    txaLista.append(produtos.get(i).mostrarDados() + "\n");
                }
            }    
        });
        
        btnPesquisar.addActionListener( new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String nomeBusca = tfdNome.getText();
                boolean encontrado = false;
                
                String resultado = "";
                
                for (int i = 0; i < produtos.size(); i++)
                {
                    if (produtos.get(i).getNome().contains(nomeBusca))
                    {
                        resultado += produtos.get(i).mostrarDados() + "\n";
                        encontrado = true;
                    }
                }
                
                if (encontrado)
                    JOptionPane.showMessageDialog(null, resultado);
                else
                    JOptionPane.showMessageDialog(null, "Nenhum produto encontrado");
            }    
        });
        
        btnRemover.addActionListener( new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String nomeRemover = tfdNome.getText();
                
                for (int i = 0; i < produtos.size(); i++)
                {
                    if (produtos.get(i).getNome().contains(nomeRemover))
                    {
                        produtos.remove(i);
                    }
                    JOptionPane.showMessageDialog(null, "Produto removido");
                    return;
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
        btnPesquisar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

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

        btnPesquisar.setText("Pesquisar");

        btnRemover.setBackground(new java.awt.Color(255, 86, 86));
        btnRemover.setText("Remover");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCadastrar)
                                .addGap(138, 138, 138))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnListar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnPesquisar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRemover))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(163, 163, 163))
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
                .addGap(45, 45, 45)
                .addComponent(btnCadastrar)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListar)
                    .addComponent(btnPesquisar)
                    .addComponent(btnRemover))
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
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JTextField tfdPreco;
    private javax.swing.JTextArea txaLista;
    // End of variables declaration//GEN-END:variables
}
