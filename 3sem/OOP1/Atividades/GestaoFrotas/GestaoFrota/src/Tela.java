import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Tela extends javax.swing.JFrame 
{
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Tela.class.getName());
    
    private String veiculos[] = {"Carro", "Caminhao"};
    
    public Tela() 
    {
        initComponents();
        
        setTitle("Sistema de Gestao de Frota");
        
        // setup do combo box
        DefaultComboBoxModel<String> lm = new DefaultComboBoxModel<>();
        
        for (String v : veiculos)
            lm.addElement(v);
        
        cbTVeiculo.setModel(lm);
        
        // setup do botao
        ButtonHandler btnHandler = new ButtonHandler();
        btnCalcular.addActionListener(btnHandler);
    }
    
    public class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            int veiculo_selecionado = cbTVeiculo.getSelectedIndex();
            
            double custo;
            
            try
            {
                double distancia = Double.parseDouble(tfdDistancia.getText());
                double preco     = Double.parseDouble(tfdPrecoC.getText());
                
                if (distancia < 0 || preco < 0)
                    throw new Exception("Distancia e/ou o preco precisam ser positivos!");
                
                if (veiculo_selecionado == 0)
                    custo = (distancia / 12) * preco;
                else
                    custo = (distancia / 4) * preco + 50;
                
                tfdResultado.setText( String.format("Custo Estimado: R$ %.2f", custo) );
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "A distancia e/ou o preco nao podem ser campos nulos");
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

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfdPrecoC = new javax.swing.JTextField();
        tfdDistancia = new javax.swing.JTextField();
        cbTVeiculo = new javax.swing.JComboBox<>();
        btnCalcular = new javax.swing.JButton();
        tfdResultado = new javax.swing.JTextField();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Distancia da viagem (km):");

        jLabel2.setText("Preco do combustivel (R$/L):");

        jLabel3.setText("Tipo de veiculo:");

        cbTVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCalcular.setBackground(new java.awt.Color(136, 192, 208));
        btnCalcular.setForeground(new java.awt.Color(46, 52, 64));
        btnCalcular.setText("Calcular");

        tfdResultado.setEditable(false);
        tfdResultado.setText("Custo Estimado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfdDistancia)
                            .addComponent(tfdPrecoC)
                            .addComponent(cbTVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tfdResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)))
                .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfdPrecoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbTVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btnCalcular)
                .addGap(33, 33, 33)
                .addComponent(tfdResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(() -> new Tela().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JComboBox<String> cbTVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tfdDistancia;
    private javax.swing.JTextField tfdPrecoC;
    private javax.swing.JTextField tfdResultado;
    // End of variables declaration//GEN-END:variables
}
