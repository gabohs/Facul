import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Calculadora extends javax.swing.JInternalFrame {

    private final String operacoes[] = {"Somar", "Subtrair", "Multiplicar", "Dividir"};
    
    public Calculadora() 
    {
        initComponents();
        
        DefaultComboBoxModel cb_model = new DefaultComboBoxModel();
        for (String op : operacoes)
            cb_model.addElement(op);
        cbOperacao.setModel(cb_model);
        
        tfdResultado.setEditable(false);
        
        btnCalcular.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try
                {
                    if (tfdNum1.getText().isEmpty() || tfdNum2.getText().isEmpty())
                        throw new Exception("Preencha ambos os campos de entrada");
                    
                    double num1 = Double.parseDouble(tfdNum1.getText());
                    double num2 = Double.parseDouble(tfdNum2.getText());
                    
                    double resultado = 0;
                    switch (cbOperacao.getSelectedIndex())
                    {
                        case 0:
                            resultado = num1 + num2;
                            break;
                           
                        case 1:
                            resultado = num1 - num2;
                            break;
                            
                        case 2:
                            resultado = num1 * num2;
                            break;
                            
                        case 3:
                            resultado = num1 / num2;
                            break;
                    }
                    
                    String resultado_txt = String.format("%.2f", resultado);
                    tfdResultado.setText(resultado_txt);
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }  
        });
        
        btnFechar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    setClosed(true);
                }
                catch (PropertyVetoException ex) { }
            }
            
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfdNum1 = new javax.swing.JTextField();
        tfdNum2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfdResultado = new javax.swing.JTextField();
        cbOperacao = new javax.swing.JComboBox<>();
        btnCalcular = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        jLabel1.setText("1o Numero");

        jLabel2.setText("2o Numero");

        jLabel3.setText("Valores");

        cbOperacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCalcular.setText("Calcular");

        btnFechar.setText("Fechar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbOperacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfdNum2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(tfdResultado))
                        .addGap(18, 18, 18)
                        .addComponent(btnCalcular)
                        .addContainerGap(267, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tfdNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdNum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfdNum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfdResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnFechar;
    private javax.swing.JComboBox<String> cbOperacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tfdNum1;
    private javax.swing.JTextField tfdNum2;
    private javax.swing.JTextField tfdResultado;
    // End of variables declaration//GEN-END:variables
}
