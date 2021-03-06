/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

/**
 *
 * @author Codification
 */
public class TelaConta extends javax.swing.JFrame {

    /**
     * Creates new form TelaConta
     */
    DAO dao;
    Cliente cliente;

    TelaConta(Cliente c) {
        super("Nova Conta - " + c.getNome() + " " + c.getSobrenome() + " (" + c.getCPF() + ")");
        cliente = c;
        dao = new DAO();
        try {
            if (dao.carregaConta(c.getCodigo()) != null) {
                JOptionPane.showMessageDialog(null, "Cliente ja possui uma conta");
                dispose();
            } else {
                initComponents();
                setVisible(true);
            }
        } catch (HeadlessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jComboBoxTipoConta = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDepositoInicial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldLimite = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldMontanteMinimo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDepositoMinimo = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBoxTipoConta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Conta Corrente", "Conta Investimento" }));
        jComboBoxTipoConta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                esconderCampos(evt);
            }
        });
        jComboBoxTipoConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoContaActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo da conta");

        jLabel2.setText("DepÃ³sito Inicial");

        jLabel3.setText("Limite");

        jLabel4.setText("Montante MÃ­nimo");

        jTextFieldMontanteMinimo.setEnabled(false);

        jLabel5.setText("DepÃ³sito MÃ­nimo ");

        jTextFieldDepositoMinimo.setEnabled(false);
        jTextFieldDepositoMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDepositoMinimoActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(25, 25, 25))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(9, 9, 9)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 102, Short.MAX_VALUE))
                            .addComponent(jTextFieldDepositoInicial, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jTextFieldLimite))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDepositoMinimo)
                            .addComponent(jTextFieldMontanteMinimo)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSalvar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDepositoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMontanteMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDepositoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalvar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxTipoContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoContaActionPerformed

    private void jTextFieldDepositoMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDepositoMinimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDepositoMinimoActionPerformed

    private void esconderCampos(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_esconderCampos
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            if (evt.getItem().toString().equalsIgnoreCase("Conta Corrente")) {
                jTextFieldMontanteMinimo.setEnabled(false);
                jTextFieldDepositoMinimo.setEnabled(false);
                jTextFieldLimite.setEnabled(true);
            } else {
                jTextFieldLimite.setEnabled(false);
                jTextFieldMontanteMinimo.setEnabled(true);
                jTextFieldDepositoMinimo.setEnabled(true);
            }
        }
    }//GEN-LAST:event_esconderCampos

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed

        try {
            if (jComboBoxTipoConta.getSelectedItem().toString().equalsIgnoreCase("Conta Corrente")) {
                ContaCorrente c = new ContaCorrente();
                c.setLimite(Double.valueOf(jTextFieldLimite.getText()));
                c.setDono(cliente.getCodigo());
                c.setDepositoInicial(Double.valueOf(jTextFieldDepositoInicial.getText()));
                c.setSaldo(Double.valueOf(jTextFieldDepositoInicial.getText()));
                dao.criaContaCorrente(c);
                JOptionPane.showMessageDialog(null, "Conta Corrente criada");
                this.dispose();
            } else {
                ContaInvestimento c = new ContaInvestimento();
                c.setDepositoMinimo(Double.valueOf(jTextFieldDepositoMinimo.getText()));
                c.setMontanteMinimo(Double.valueOf(jTextFieldMontanteMinimo.getText()));
                c.setDono(cliente.getCodigo());
                c.setDepositoInicial(Double.valueOf(jTextFieldDepositoInicial.getText()));
                c.setSaldo(Double.valueOf(jTextFieldDepositoInicial.getText()));
                dao.criaContaInvestimento(c);
                JOptionPane.showMessageDialog(null, "Conta Investimento criada");
                this.dispose();
            }
        } catch (NumberFormatException ex1) {
            //Se alguma string estiver vazia não realiza nenhuma ação
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButtonSalvarActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox jComboBoxTipoConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldDepositoInicial;
    private javax.swing.JTextField jTextFieldDepositoMinimo;
    private javax.swing.JTextField jTextFieldLimite;
    private javax.swing.JTextField jTextFieldMontanteMinimo;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
