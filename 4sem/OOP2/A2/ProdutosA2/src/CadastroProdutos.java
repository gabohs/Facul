public class CadastroProdutos extends javax.swing.JInternalFrame
{
    ServicoProduto servico = new ServicoProduto();
    
    
    public CadastroProdutos() 
    {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfdNome = new javax.swing.JTextField();
        tfdPreco = new javax.swing.JTextField();
        btnGravar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaResultado = new javax.swing.JTextArea();
        btnMostrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfdPos = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

        jLabel1.setText("Nome");

        jLabel2.setText("Preco ");

        tfdNome.addActionListener(this::tfdNomeActionPerformed);

        tfdPreco.addActionListener(this::tfdPrecoActionPerformed);

        btnGravar.setText("Inserir");
        btnGravar.addActionListener(this::btnGravarActionPerformed);

        txaResultado.setColumns(20);
        txaResultado.setRows(5);
        jScrollPane1.setViewportView(txaResultado);

        btnMostrar.setText("Mostrar Produtos");
        btnMostrar.addActionListener(this::btnMostrarActionPerformed);

        jLabel3.setText("Pos");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnRemover.setText("Remover");
        btnRemover.addActionListener(this::btnRemoverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGravar)
                                .addGap(0, 0, 0)
                                .addComponent(btnMostrar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(tfdPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(tfdPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnRemover)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfdPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfdPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemover))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnMostrar))
                .addGap(89, 89, 89)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) 
    {//GEN-FIRST:event_btnGravarActionPerformed
        String nome = tfdNome.getText();
        double preco = Double.parseDouble(tfdPreco.getText());
        
        Produto produto = new Produto(nome, preco);
        servico.adicionarProduto(produto);
        
        limparCampos();
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) 
    {//GEN-FIRST:event_btnMostrarActionPerformed
        atualizarLista();
    }//GEN-LAST:event_btnMostrarActionPerformed

    public void limparCampos()
    {
        tfdNome.setText("");
        tfdPreco.setText("");
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) 
    {//GEN-FIRST:event_btnBuscarActionPerformed
        int posicao = Integer.parseInt(tfdPos.getText());
        StringBuilder sb = new StringBuilder();
        
        Produto p = servico.buscarProduto(posicao);
        sb.append(p.toString());
        txaResultado.setText(sb.toString());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int posicao = Integer.parseInt(tfdPos.getText());
 
        servico.removerProduto(posicao);
        atualizarLista();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void atualizarLista()
    {
        StringBuilder sb = new StringBuilder();
        for (Produto p : servico.listarProduto())
        {
            sb.append( p.toString() + "\n" );
        }
        
        txaResultado.setText("");
        txaResultado.setText(sb.toString());
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JTextField tfdPos;
    private javax.swing.JTextField tfdPreco;
    private javax.swing.JTextArea txaResultado;
    // End of variables declaration//GEN-END:variables
}
