import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import javax.swing.JOptionPane;

public class CadastroNotaFiscal extends javax.swing.JInternalFrame 
{
    ArrayList<ItemNota> itens = new ArrayList<ItemNota>();
    
    DefaultTableModel model = new DefaultTableModel();
    
    private int idItem = 1;
    
    public CadastroNotaFiscal() 
    {
        initComponents();
        
        String[] colunas = {"ID Item", "Descricao do produto", "Quantidade", "Preco Unitario", "Valor Total"};
        for (String col : colunas) 
            model.addColumn(col);
        
        tblItens.setModel(model);
        
        tfdIDItemNota.setText(String.valueOf(idItem));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        labelAAAAa = new javax.swing.JLabel();
        tfdIDNota = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfdDataEmissao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfdIDCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfdValorTotalNota = new javax.swing.JTextField();
        btnInserirNota = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfdIDItemNota = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfdDescricao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfdQuantidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfdPrecoUnitario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfdValorTotalItem = new javax.swing.JTextField();
        btnInserirItem = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();

        jMenuItem1.setText("jMenuItem1");

        jPanel1.setBackground(new java.awt.Color(204, 0, 153));

        labelAAAAa.setText("ID Nota: ");

        tfdIDNota.setText(" ");

        jLabel1.setText("Data da Emissao: ");

        jLabel2.setText("ID Cliente: ");

        jLabel3.setText("Valor total da nota");

        btnInserirNota.setText("Inserir nota");
        btnInserirNota.addActionListener(this::btnInserirNotaActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfdValorTotalNota, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(labelAAAAa))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfdDataEmissao, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(tfdIDNota)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btnInserirNota)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAAAAa)
                    .addComponent(tfdIDNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfdIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfdValorTotalNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnInserirNota)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 51, 255));

        jLabel4.setText("ID Item da Nota:");

        jLabel5.setText("Descricao:");

        jLabel6.setText("Quantidade:");

        jLabel7.setText("Valor unitario:");

        tfdPrecoUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdPrecoUnitarioFocusLost(evt);
            }
        });

        jLabel8.setText("Valor total do item:");

        btnInserirItem.setText("Inserir Item");
        btnInserirItem.addActionListener(this::btnInserirItemActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdIDItemNota, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInserirItem)
                            .addComponent(tfdValorTotalItem))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfdIDItemNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfdQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfdPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(tfdValorTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnInserirItem)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 102));

        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblItens);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(454, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfdPrecoUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdPrecoUnitarioFocusLost
        int quantidade = Integer.parseInt(tfdQuantidade.getText());
        double precoUnitario = Double.parseDouble(tfdPrecoUnitario.getText());
        
        double valorTotal = quantidade * precoUnitario;
        tfdValorTotalItem.setText(String.valueOf(valorTotal));
    }//GEN-LAST:event_tfdPrecoUnitarioFocusLost

    private void btnInserirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirItemActionPerformed

        String descricao = tfdDescricao.getText();
        int quantidade = Integer.parseInt(tfdQuantidade.getText());
        double precoUnitario = Double.parseDouble(tfdPrecoUnitario.getText());
        
        double valorTotal = quantidade * precoUnitario;
        tfdValorTotalItem.setText(String.valueOf(valorTotal));
        
        ItemNota item = new ItemNota(idItem, descricao, quantidade, precoUnitario);
        itens.add(item);
        model.addRow(new Object[]{idItem, descricao, quantidade, precoUnitario, valorTotal});
        
        idItem++;
        limparItens();
        tfdIDItemNota.setText(String.valueOf(idItem));
    }//GEN-LAST:event_btnInserirItemActionPerformed

    private void btnInserirNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirNotaActionPerformed
        try
        {
            if (BD.getConnection())
            {
                Connection conn = BD.getConn();
                
                double valorTotalNota = 0;
                for (ItemNota item : itens)
                    valorTotalNota += (item.getQuantidade() * item.getPrecoUnitario());
                
                tfdValorTotalNota.setText(String.valueOf(valorTotalNota));
                
                // gravar a nota fiscal no BD
                String sql = "INSERT INTO NotaFiscal (dataEmissao, idCliente, valorTotal) VALUES (?, ?, ?)";
                PreparedStatement pstNota = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                pstNota.setString(1, tfdDataEmissao.getText());
                pstNota.setInt(2, Integer.parseInt(tfdIDCliente.getText()));
                pstNota.setDouble(3, valorTotalNota);
                
                int resultNota = pstNota.executeUpdate();
                
                if (resultNota > 0) 
                {
                    ResultSet rs = pstNota.getGeneratedKeys();
                    int idNotaFiscalGerada = 0;
                    
                    if (rs.next())
                    {
                        idNotaFiscalGerada = rs.getInt(1);
                        tfdIDNota.setText(String.valueOf(idNotaFiscalGerada));
                    }
                    
                    // gravar os itens da nota fiscal
                    String sql2 = "INSERT INTO itemNotaFiscal (idNotaFiscal, descricao, quantidade, precoUnitario) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstItem = conn.prepareStatement(sql2);
                    
                    for (ItemNota item : itens)
                    {
                        pstItem.setInt(1, idNotaFiscalGerada);
                        pstItem.setString(2, item.getDescricao());
                        pstItem.setInt(3, item.getQuantidade());
                        pstItem.setDouble(4, item.getPrecoUnitario());
                        
                        pstItem.executeUpdate();
                    }
                    
                    JOptionPane.showMessageDialog(null, "Nota fiscal e itens inseridos com sucesso na Nota: " + idNotaFiscalGerada);
                }
                    
                else
                    JOptionPane.showMessageDialog(null, "Erro ao inserir a nota fiscal");
                
                conn.close();
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnInserirNotaActionPerformed

    
    public void limparCampos()
    {
        // limpar campos nota
        tfdDataEmissao.setText("");
        tfdIDCliente.setText("");
        tfdValorTotalNota.setText("");
        
        // limparTabela
        model.setRowCount(0);
        
        // limpar a lista de itens
        itens.clear();
        
        // reiniciar ID do item
        idItem = 1;
        tfdIDItemNota.setText(String.valueOf(idItem)); 
    }
    
    public void limparItens()
    {
         // limpar campos item
        tfdDescricao.setText("");
        tfdQuantidade.setText("");
        tfdPrecoUnitario.setText("");
        tfdValorTotalItem.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInserirItem;
    private javax.swing.JButton btnInserirNota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAAAAa;
    private javax.swing.JTable tblItens;
    private javax.swing.JTextField tfdDataEmissao;
    private javax.swing.JTextField tfdDescricao;
    private javax.swing.JTextField tfdIDCliente;
    private javax.swing.JTextField tfdIDItemNota;
    private javax.swing.JTextField tfdIDNota;
    private javax.swing.JTextField tfdPrecoUnitario;
    private javax.swing.JTextField tfdQuantidade;
    private javax.swing.JTextField tfdValorTotalItem;
    private javax.swing.JTextField tfdValorTotalNota;
    // End of variables declaration//GEN-END:variables
}
