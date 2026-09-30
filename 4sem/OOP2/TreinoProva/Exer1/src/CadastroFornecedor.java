import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class CadastroFornecedor extends javax.swing.JInternalFrame implements ActionListener
{
    private String[] estados = {"RS", "SC", "PR", "SP", "RJ"};
    DefaultComboBoxModel cbmEstados = new DefaultComboBoxModel();
    
    private String[] categorias = {"Materia Prima", "Servicos", "Logistica"};
    DefaultComboBoxModel cbmCategorias = new DefaultComboBoxModel();
    
    private String status = "Ativo";
    
    private String tipo_pessoa = "Fisica";
    
    public CadastroFornecedor() 
    {
        initComponents();
        
        for (String e : estados)
            cbmEstados.addElement(e);
        cbEstado.setModel(cbmEstados);
        
        for (String c : categorias)
            cbmCategorias.addElement(c);
        cbMateria.setModel(cbmCategorias);
        
        if (!ConexaoBD.getConnection())
        {
            JOptionPane.showMessageDialog(null, "Falha na Conexao");
            System.exit(0);
        }
        
        btnLimpaCampos.addActionListener(this);
        btnSalvar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnAlterar.addActionListener(this);
        btnExcluir.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // botoes
        if (e.getSource() == btnLimpaCampos)
        {
            limparCampos();
        }
        
        else if (e.getSource() == btnSalvar)
        {
            salvarFornecedor();
        }
        
        else if (e.getSource() == btnConsultar)
        {
            consultarFornecedor();
        }
        
        else if (e.getSource() == btnAlterar)
        {
            this.alterar();
        }
        
        else if (e.getSource() == btnExcluir)
        {
            int confirmacao = JOptionPane.showConfirmDialog(
                null, 
                "Deseja realmente excluir o fornecedor de ID " + tfdID.getText() + "?", 
                "Açao critica!", 
                JOptionPane.YES_NO_OPTION
            );

            if (confirmacao == JOptionPane.YES_OPTION)
            {
                this.excluir();
            }
        }
        
        // checkbox
        atualizarCheckbox();
        
        // radio buttons
        atualizarRadio();
    }
    
    private void limparCampos()
    {
        tfdID.setText("");
        tfdRazaoSocial.setText("");
        tfdTelefone.setText("");
        tfdCidade.setText("");
    }
    
    private void salvarFornecedor()
    {
        atualizarCheckbox();
        atualizarRadio();
        
        String sql = "INSERT INTO fornecedor (id, razao_social, telefone, cidade, estado, categoria, status, tipo_pessoa)"
                     + "VALUES ("
                        + "'" + tfdID.getText() + "',"
                        + "'" + tfdRazaoSocial.getText() + "',"
                        + "'" + tfdTelefone.getText() + "',"
                        + "'" + tfdCidade.getText() + "',"
                        + "'" + estados[cbEstado.getSelectedIndex()] + "'," // comboBox
                        + "'" + categorias[cbMateria.getSelectedIndex()] + "',"
                        + "'" + status + "',"
                        + "'" + tipo_pessoa + "'"
                     + ");"; 
        
        if (ConexaoBD.getConnection())
        {
            if (ConexaoBD.runSQL(sql) == 1)
                JOptionPane.showMessageDialog(null, "Inclusao realizada com sucesso");
            else
                JOptionPane.showMessageDialog(null, "Erro ao realizar a inclusão");
            
            ConexaoBD.close();
        }
        else
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados");
    }
    
    // CONSULTA ------------------------------------------------------------------------------
    
    private void consultarFornecedor()
    {
        try 
        {   
            // consultar por ID ou razao_social:
            String sql;
            
            if (tfdID.getText().equals(""))
                sql = "SELECT * FROM fornecedor WHERE razao_social='" + tfdRazaoSocial.getText() + "'";
            else if (tfdRazaoSocial.getText().equals(""))
                sql = "SELECT * FROM fornecedor WHERE id='" + tfdID.getText() + "'";
            else
            {
                JOptionPane.showMessageDialog(null, "Consulta deve ser feita por ID ou Razao Social");
                return;
            }
            
            if (ConexaoBD.getConnection())
            {
                ConexaoBD.setResultSet(sql);
                
                if (ConexaoBD.resultSet.next())
                    exibeResultado();
                else
                {
                    JOptionPane.showMessageDialog(null,"Fornecedor não encontrado!");
                    ConexaoBD.setResultSet("SELECT * FROM fornecedor");
                }
                
                ConexaoBD.close();
            }
            else
                JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados");
        }
        catch (Exception ex)
        {}
    }
    
    private void exibeResultado()
    {
        try
        {
            if (ConexaoBD.resultSet.isAfterLast())
                ConexaoBD.resultSet.last();
            if (ConexaoBD.resultSet.isBeforeFirst())
                ConexaoBD.resultSet.first();
            
            String valID = String.valueOf(ConexaoBD.resultSet.getInt("id"));
            String valRS = ConexaoBD.resultSet.getString("razao_social");
            String valTF = ConexaoBD.resultSet.getString("telefone");
            String valCI = ConexaoBD.resultSet.getString("cidade");
            String valES = ConexaoBD.resultSet.getString("estado");
            String valCA = ConexaoBD.resultSet.getString("categoria");
            String valAT = ConexaoBD.resultSet.getString("status");
            String valTP = ConexaoBD.resultSet.getString("tipo_pessoa");
            
            // exibe na text area
            taResultado.append(String.format(
                    "------------------------------------------------------------\n" +
                    "ID:\t%s\n"
                    + "Razao Social:\t%s\n"
                    + "Telefone:\t%s\n"
                    + "Cidade: \t%s\n"
                    + "Estado:\t %s\n"
                    + "Cat. Materia:\t%s\n"
                    + "Status:\t%s\n" 
                    + "Tipo Pessoa:\t%s\n",
                    valID, valRS, valTF, valCI, valES, valCA, valAT, valTP)
            );
            
            // altera os campos
            tfdID.setText(valID);
            tfdRazaoSocial.setText(valRS);
            tfdTelefone.setText(valTF);
            tfdCidade.setText(valCI);
                        
            cbEstado.setSelectedItem(valES);
            cbMateria.setSelectedItem(valCA);
            
            if (valAT.equals("Ativo"))
                chbAtivo.setSelected(true);
            else
                chbAtivo.setSelected(false);
            
            if (valTP.equals("Fisica"))
                rbPF.setSelected(true);
            else
                rbPJ.setSelected(true);
            
        }
        catch (SQLException ex)
        {
            
        }
    }
    
    // ------------------------------------------------------------------------------
    // ALTERANDO
    
    private void alterar()
    {
        atualizarCheckbox();
        atualizarRadio();
        
        String sql = "UPDATE fornecedor SET "
                    + "razao_social='" + tfdRazaoSocial.getText() + "',"
                    + "telefone='" + tfdTelefone.getText() + "',"
                    + "cidade='" + tfdCidade.getText() + "',"
                    + "estado='" + estados[cbEstado.getSelectedIndex()] + "',"
                    + "categoria='" + categorias[cbMateria.getSelectedIndex()] + "',"
                    + "status='" + status + "',"
                    + "tipo_pessoa='" + tipo_pessoa + "' "
                    + "WHERE id='" + tfdID.getText() + "'";;
        
        System.out.println("EXECUTANDO: " + sql);
        
        if (ConexaoBD.getConnection())
        {
            if (ConexaoBD.runSQL(sql) == 1)
                JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso!");
            else
                JOptionPane.showMessageDialog(null,"Problemas na Alteração, verifique se você digitou os campos corretamente!");
            
            ConexaoBD.close();
        }
        else
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados");
        
        ConexaoBD.setResultSet("SELECT * FROM fornecedor");
    }
    
    // ------------------------------------------------------------------------------
    // Excluindo
    
    private void excluir()
    {   
        String sql;
            
        if (tfdID.getText().equals(""))
            sql = "DELETE FROM fornecedor WHERE razao_social='" + tfdRazaoSocial.getText() + "'";
        else if (tfdRazaoSocial.getText().equals(""))
            sql = "DELETE FROM fornecedor WHERE id='" + tfdID.getText() + "'";
        else
        {
            JOptionPane.showMessageDialog(null, "A exclusao deve ser feita por ID ou Razao Social. Cancelando...");
            return;
        }

        System.out.println("EXECUTANDO: " + sql);
        
        if (ConexaoBD.getConnection())
        {
            if (ConexaoBD.runSQL(sql) == 1) 
            {
                JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!");

                ConexaoBD.setResultSet("SELECT * FROM fornecedor");
                limparCampos(); 
            } 
            else 
                JOptionPane.showMessageDialog(null, "Problemas na exclusão. Verifique se o ID existe!");
            
            ConexaoBD.close();
        }
        else
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados");
    }
    
    // ------------------------------------------------------------------------------
    
    private void atualizarCheckbox()
    {
        if (chbAtivo.isSelected())
            status = "Ativo";
        else
            status = "Inativo";
    }
    
    private void atualizarRadio()
    {
        if (rbPF.isSelected())
            tipo_pessoa = "Fisica";
        else if (rbPJ.isSelected())
            tipo_pessoa = "Juridica";
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipoPessoa = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfdID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfdRazaoSocial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfdTelefone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfdCidade = new javax.swing.JTextField();
        cbEstado = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbMateria = new javax.swing.JComboBox<>();
        chbAtivo = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rbPF = new javax.swing.JRadioButton();
        rbPJ = new javax.swing.JRadioButton();
        btnLimpaCampos = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taResultado = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        btnLimparResultados = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Identificaçao");

        jLabel2.setText("id:");

        jLabel3.setText("Razao Social:");

        jLabel4.setText("Telefone:");

        jLabel5.setText("Cidade:");

        jLabel6.setText("Estado:");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tfdID, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfdCidade))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfdTelefone))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbEstado, 0, 186, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(tfdRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfdID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfdRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfdTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Informaçoes Comerciais");

        jLabel8.setText("Categoria da Materia Prima");

        cbMateria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        chbAtivo.setSelected(true);
        chbAtivo.setText("Ativo?");

        jLabel10.setText("Status");

        jLabel11.setText("Tipo Pessoa");

        buttonGroupTipoPessoa.add(rbPF);
        rbPF.setSelected(true);
        rbPF.setText("Fisica");

        buttonGroupTipoPessoa.add(rbPJ);
        rbPJ.setText("Juridica");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(chbAtivo)
                                        .addComponent(cbMateria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jLabel11)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(rbPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbPJ))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbAtivo)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPF)
                    .addComponent(rbPJ))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnLimpaCampos.setText("Limpar Campos");

        btnSalvar.setText("Salvar");

        btnConsultar.setText("Consultar");

        btnAlterar.setText("Alterar");

        btnExcluir.setText("Excluir");

        taResultado.setEditable(false);
        taResultado.setColumns(20);
        taResultado.setRows(5);
        jScrollPane1.setViewportView(taResultado);

        jLabel9.setText("Resultados Consulta");

        btnLimparResultados.setText("Limpar Consulta");
        btnLimparResultados.addActionListener(this::btnLimparResultadosActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(209, 209, 209))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimpaCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnLimparResultados))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLimpaCampos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnConsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluir)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimparResultados)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparResultadosActionPerformed
        taResultado.setText("");
    }//GEN-LAST:event_btnLimparResultadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpaCampos;
    private javax.swing.JButton btnLimparResultados;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroupTipoPessoa;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbMateria;
    private javax.swing.JCheckBox chbAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbPF;
    private javax.swing.JRadioButton rbPJ;
    private javax.swing.JTextArea taResultado;
    private javax.swing.JTextField tfdCidade;
    private javax.swing.JTextField tfdID;
    private javax.swing.JTextField tfdRazaoSocial;
    private javax.swing.JTextField tfdTelefone;
    // End of variables declaration//GEN-END:variables

}
