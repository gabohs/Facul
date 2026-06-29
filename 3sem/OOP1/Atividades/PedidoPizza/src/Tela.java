import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Tela extends javax.swing.JFrame 
{
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Tela.class.getName());
    
    private double[] precos = new double[4]; 
    // 0 -> pizza pequena, 1 -> media, 2 -> grande, 3 -> extra
    
    private String tipos_pizza[] = {"Pequena", "Media", "Grande"};
    private int tipo_selecionado = -1;
    
    private boolean temBacon      = false;
    private boolean temQueijo     = false;
    private boolean temChampignon = false;
    private int quant_extras = 0;
    
    private final String tipos_pagamento[] = {"Dinheiro", "Cartao", "Pix"};
    
    private int contador_pedidos = 1;

    public Tela() 
    {
        initComponents();
        
        getContentPane().setBackground(new Color(67, 76, 94));
        
        ButtonGroup tamanhos = new ButtonGroup();
        
        JRadioButton radios[] = {rbTP, rbTM, rbTG};
        for (JRadioButton r : radios)
        {
            tamanhos.add(r);
            
            r.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    if (e.getSource() == rbTP)
                        tipo_selecionado = 0;
                    else if (e.getSource() == rbTM)
                        tipo_selecionado = 1;
                    else if (e.getSource() == rbTG)
                        tipo_selecionado = 2;
                }  
            });
        }
        
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        for (String tp : tipos_pagamento)
            cbm.addElement(tp);
        listaPagamentos.setModel(cbm);
        
        JCheckBox extras[] = {cbBacon, cbQueijo, cbChampignon};
        for (JCheckBox cb : extras)
        {
            cb.addItemListener( new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) 
                {
                    if (e.getSource() == cbBacon)
                    {
                        if (e.getStateChange() == ItemEvent.SELECTED)
                        {
                            temBacon = true;
                            quant_extras++;
                        }
                        else
                        {
                            temBacon = false;
                            quant_extras--;
                        }
                    }
                    
                    if (e.getSource() == cbQueijo)
                    {
                        if (e.getStateChange() == ItemEvent.SELECTED)
                        {
                            temQueijo = true;
                            quant_extras++;
                        }
                        else
                        {
                            temQueijo = false;
                            quant_extras--;
                        }
                    }
                    
                    if (e.getSource() == cbChampignon)
                    {
                        if (e.getStateChange() == ItemEvent.SELECTED)
                        {
                            temChampignon = true;
                            quant_extras++;
                        }
                        else
                        {
                            temChampignon = false;
                            quant_extras--;
                        }
                    }
                }
            });
        }
        
        ButtonConfirmarHandler bch = new ButtonConfirmarHandler();
        btnConfirmar.addActionListener(bch);
    }
    
    private class ButtonConfirmarHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            JTextField inputs[] = {tfdPrecoP, tfdPrecoM, tfdPrecoG, tfdPrecoExtra};
            
            try
            {
                for (JTextField in : inputs)
                {
                    if (in.getText().isEmpty())
                        throw new Exception("Preencha todos os campos de entrada!");
                    
                    if (Double.parseDouble(in.getText()) < 0)
                        throw new Exception("Os campos de preco nao podem conter valores negativos");
                }
                
                for (int i = 0; i < 4; i++)
                {
                    precos[i] = Double.parseDouble(inputs[i].getText());
                }
                
                if (tipo_selecionado == -1)
                    throw new Exception("Voce nao selecionou nenhum tamanho de pizza");
                
                double preco_total = precos[tipo_selecionado] + (quant_extras) * precos[3];
                
                // exibindo no textArea
                String extras = "";
                if (!temBacon && !temQueijo && !temChampignon)
                    extras = "Nenhum";
                
                if (temBacon)
                    extras += "  Bacon  ";
                
                if (temQueijo)
                    extras += "  Queijo  ";
                
                if (temChampignon)
                    extras += "  Champignon  ";
                
                txaPedidos.append(
                        "> PEDIDO: " + contador_pedidos++ + "\n" + 
                        "Tamanho: " + tipos_pizza[tipo_selecionado] + "\n" +
                        "Extras: " + quant_extras + " (" + extras + ")" + "\n" +
                        "Tipo de Pagamento: " + tipos_pagamento[listaPagamentos.getSelectedIndex()] + "\n" +
                        "VALOR TOTAL: " + preco_total + "\n" +
                        "----------------------------------------" + "\n"
                );
                
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rbTP = new javax.swing.JRadioButton();
        rbTM = new javax.swing.JRadioButton();
        rbTG = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        cbBacon = new javax.swing.JCheckBox();
        cbQueijo = new javax.swing.JCheckBox();
        cbChampignon = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfdPrecoP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfdPrecoM = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfdPrecoG = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfdPrecoExtra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        listaPagamentos = new javax.swing.JComboBox<>();
        btnConfirmar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaPedidos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(67, 76, 94));

        jPanel1.setBackground(new java.awt.Color(129, 161, 193));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        jLabel2.setText("Pedido de Pizza");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(512, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(443, 443, 443))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(129, 161, 193));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Escolha as opçoes da Pizza abaixo:");

        jLabel3.setText("Tamanho");

        rbTP.setText("Pequena");

        rbTM.setText("Media");

        rbTG.setText("Grande");

        jLabel4.setText("Ingredientes extras");

        cbBacon.setText("Bacon");

        cbQueijo.setText("Queijo");

        cbChampignon.setText("Champignon");

        jLabel5.setText("Precos");

        jLabel6.setText("Pizza pequena:");

        jLabel7.setText("Pizza media:");

        jLabel8.setText("Pizza grande:");

        jLabel9.setText("Ing. extra:");

        jLabel10.setText("Tipo de Pagamento:");

        listaPagamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnConfirmar.setText("Confirmar Pedido");
        btnConfirmar.addActionListener(this::btnConfirmarActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbTM)
                                            .addComponent(rbTP)
                                            .addComponent(rbTG)
                                            .addComponent(jLabel10))))
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(listaPagamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbQueijo)
                            .addComponent(cbChampignon)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(cbBacon))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfdPrecoM)
                                            .addComponent(tfdPrecoP)
                                            .addComponent(tfdPrecoG)
                                            .addComponent(tfdPrecoExtra, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))))))))
                .addContainerGap(134, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTP)
                    .addComponent(cbBacon)
                    .addComponent(jLabel6)
                    .addComponent(tfdPrecoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTM)
                    .addComponent(cbQueijo)
                    .addComponent(jLabel7)
                    .addComponent(tfdPrecoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTG)
                    .addComponent(cbChampignon)
                    .addComponent(jLabel8)
                    .addComponent(tfdPrecoG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfdPrecoExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaPagamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(129, 161, 193));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txaPedidos.setColumns(20);
        txaPedidos.setRows(5);
        jScrollPane1.setViewportView(txaPedidos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmarActionPerformed


    public static void main(String args[]) 
    {
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

        java.awt.EventQueue.invokeLater(() -> new Tela().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JCheckBox cbBacon;
    private javax.swing.JCheckBox cbChampignon;
    private javax.swing.JCheckBox cbQueijo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listaPagamentos;
    private javax.swing.JRadioButton rbTG;
    private javax.swing.JRadioButton rbTM;
    private javax.swing.JRadioButton rbTP;
    private javax.swing.JTextField tfdPrecoExtra;
    private javax.swing.JTextField tfdPrecoG;
    private javax.swing.JTextField tfdPrecoM;
    private javax.swing.JTextField tfdPrecoP;
    private javax.swing.JTextArea txaPedidos;
    // End of variables declaration//GEN-END:variables
}
