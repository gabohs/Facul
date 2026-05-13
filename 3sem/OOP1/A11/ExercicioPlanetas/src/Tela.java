
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author gabo
 */
public class Tela extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Tela.class.getName());
    
    private String[] planetas = {"Mercurio", "Venus", "Marte", "Jupiter", "Saturno", "Urano"};
    private double[] gravidades = {0.37, 0.88, 0.38, 2.64, 1.15, 1.17};
    
    private int index = 0;

    public Tela() 
    {
        initComponents();
        
        RadioButtonHandler rBtnHandler = new RadioButtonHandler();
        ButtonHandler btnHandler = new ButtonHandler();
        
        rbMercurio.addItemListener(rBtnHandler);
        rbVenus.addItemListener(rBtnHandler);
        rbMarte.addItemListener(rBtnHandler);
        rbJupiter.addItemListener(rBtnHandler);
        rbSaturno.addItemListener(rBtnHandler);
        rbUrano.addItemListener(rBtnHandler);
        
        btnCalcular.addActionListener(btnHandler);
    }
    
    double calcula_peso_planeta(int index)
    {
        double peso_terra = Double.parseDouble(tfdPesoTerra.getText());
        
        return (peso_terra / 10) * gravidades[index];
    }
    
    public class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if (tfdPesoTerra.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Digite o peso na terra");
                return;
            }
            
            if (e.getSource() == btnCalcular)
            {
                double peso_planeta = calcula_peso_planeta(index);
                lblResultado.setText("Peso em " + planetas[index] + ": " + String.format("%.2f", peso_planeta) + "kg");
            }
        }
    }
    
    public class RadioButtonHandler implements ItemListener
    {
        @Override
        public void itemStateChanged(ItemEvent e) 
        {
            // if (e.getSource() == rbMercurio) index = 0;
            
            if (e.getSource() == rbVenus)
                index = 1;            
            
            if (e.getSource() == rbMarte)
                index = 2;
           
            if (e.getSource() == rbJupiter)
                index = 3;
            
            if (e.getSource() == rbSaturno)
                index = 4;
            
            if (e.getSource() == rbUrano)
                index = 5;   
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Planetas = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tfdPesoTerra = new javax.swing.JTextField();
        rbMercurio = new javax.swing.JRadioButton();
        rbVenus = new javax.swing.JRadioButton();
        rbMarte = new javax.swing.JRadioButton();
        rbJupiter = new javax.swing.JRadioButton();
        rbSaturno = new javax.swing.JRadioButton();
        rbUrano = new javax.swing.JRadioButton();
        lblResultado = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Peso na Terra (kg):");

        Planetas.add(rbMercurio);
        rbMercurio.setText("Mercurio");

        Planetas.add(rbVenus);
        rbVenus.setText("Venus");

        Planetas.add(rbMarte);
        rbMarte.setText("Marte");

        Planetas.add(rbJupiter);
        rbJupiter.setText("Jupiter");

        Planetas.add(rbSaturno);
        rbSaturno.setText("Saturno");

        Planetas.add(rbUrano);
        rbUrano.setText("Urano");

        lblResultado.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        lblResultado.setText("Resultado aparecera aqui");

        btnCalcular.setText("Calcular");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdPesoTerra, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbMercurio)
                                .addGap(18, 18, 18)
                                .addComponent(rbVenus)
                                .addGap(18, 18, 18)
                                .addComponent(rbMarte)
                                .addGap(18, 18, 18)
                                .addComponent(rbJupiter)
                                .addGap(18, 18, 18)
                                .addComponent(rbSaturno)))
                        .addGap(18, 18, 18)
                        .addComponent(rbUrano))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(lblResultado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(432, 432, 432)
                        .addComponent(btnCalcular)))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdPesoTerra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMercurio)
                    .addComponent(rbVenus)
                    .addComponent(rbMarte)
                    .addComponent(rbJupiter)
                    .addComponent(rbSaturno)
                    .addComponent(rbUrano))
                .addGap(18, 18, 18)
                .addComponent(btnCalcular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(() -> new Tela().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Planetas;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JRadioButton rbJupiter;
    private javax.swing.JRadioButton rbMarte;
    private javax.swing.JRadioButton rbMercurio;
    private javax.swing.JRadioButton rbSaturno;
    private javax.swing.JRadioButton rbUrano;
    private javax.swing.JRadioButton rbVenus;
    private javax.swing.JTextField tfdPesoTerra;
    // End of variables declaration//GEN-END:variables
}
