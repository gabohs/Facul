import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Temperaturas extends javax.swing.JInternalFrame 
{
    private final int tam = 6;
    private int[] fahrenheit = new int[tam];
    
    private double[] celsius = new double[tam];
    
    public Temperaturas() 
    {
        initComponents();
        
        tfdSoma.setEditable(false);
        tfdMedia.setEditable(false);
        
        btnCalcular.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JTextField[] inputs = {tfdTemp1, tfdTemp2, tfdTemp3, tfdTemp4, tfdTemp5, tfdTemp6};
                
                try
                {
                    for (JTextField in : inputs)
                    {
                        if (in.getText().isEmpty())
                            throw new Exception("Preencha todos os campos de entrada!");
                    }
                        
                    for (int i = 0; i < tam; i++)
                    {
                        fahrenheit[i] = Integer.parseInt(inputs[i].getText());
                    }
                    
                    for (int i = 0; i < tam; i++)
                    {
                        celsius[i] = ( (double)fahrenheit[i] - 32.0f ) / 1.8f; 
                    }    
                    
                    double soma = 0;
                    
                    for (double tc : celsius)
                        soma += tc;
                    
                    double media = soma / tam;
                    
                    tfdSoma.setText(String.format("%.2f", soma));
                    tfdMedia.setText(String.format("%.2f", media));
                    
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        
        btnFechar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfdTemp1 = new javax.swing.JTextField();
        tfdTemp2 = new javax.swing.JTextField();
        tfdTemp3 = new javax.swing.JTextField();
        tfdTemp4 = new javax.swing.JTextField();
        tfdTemp5 = new javax.swing.JTextField();
        tfdTemp6 = new javax.swing.JTextField();
        btnFechar = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfdMedia = new javax.swing.JTextField();
        tfdSoma = new javax.swing.JTextField();

        jLabel1.setText("Cidade 1");

        jLabel2.setText("Cidade 2");

        jLabel3.setText("Cidade 4");

        jLabel4.setText("Cidade 3");

        jLabel5.setText("Cidade 6");

        jLabel6.setText("Cidade 5");

        tfdTemp3.addActionListener(this::tfdTemp3ActionPerformed);

        tfdTemp4.addActionListener(this::tfdTemp4ActionPerformed);

        tfdTemp5.addActionListener(this::tfdTemp5ActionPerformed);

        tfdTemp6.addActionListener(this::tfdTemp6ActionPerformed);

        btnFechar.setText("Fechar");

        btnCalcular.setText("Calcular Informacoes");

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel7.setText("Soma:");

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel8.setText("Media:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdTemp1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(tfdTemp2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(tfdTemp4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(tfdTemp5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(tfdTemp3, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(tfdTemp6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnFechar)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCalcular)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdSoma, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdTemp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdTemp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdTemp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdTemp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdTemp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdTemp6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCalcular)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfdSoma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfdMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfdTemp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdTemp3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdTemp3ActionPerformed

    private void tfdTemp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdTemp4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdTemp4ActionPerformed

    private void tfdTemp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdTemp5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdTemp5ActionPerformed

    private void tfdTemp6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdTemp6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdTemp6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tfdMedia;
    private javax.swing.JTextField tfdSoma;
    private javax.swing.JTextField tfdTemp1;
    private javax.swing.JTextField tfdTemp2;
    private javax.swing.JTextField tfdTemp3;
    private javax.swing.JTextField tfdTemp4;
    private javax.swing.JTextField tfdTemp5;
    private javax.swing.JTextField tfdTemp6;
    // End of variables declaration//GEN-END:variables
}
