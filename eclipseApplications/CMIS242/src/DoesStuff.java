/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author Wes
 */
public class DoesStuff extends javax.swing.JFrame {
    private int prodIn1;
    private int prodIn2;
    private double divIn1;
    private double divIn2;
    private String prodAns;
    private String divAns;
    

    /**
     * Creates new form DoesStuff
     */
    public DoesStuff() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        executeMethods = new javax.swing.JButton();
        prodInput = new javax.swing.JTextField();
        divInput = new javax.swing.JTextField();
        prodOutput = new javax.swing.JTextField();
        divOutput = new javax.swing.JTextField();
        prodLabel = new javax.swing.JLabel();
        divLabel = new javax.swing.JLabel();
        result1 = new javax.swing.JLabel();
        result2 = new javax.swing.JLabel();
        prodInput2 = new javax.swing.JTextField();
        divInput2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Matherizer");

        executeMethods.setText("Calculate");
        executeMethods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeMethodsActionPerformed(evt);
            }
        });

        prodInput.setText("Input Integer");
        prodInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prodInputMouseClicked(evt);
            }
        });

        divInput.setText("Input Integer");
        divInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                divInputMouseClicked(evt);
            }
        });

        prodOutput.setText("Result");
        prodOutput.setEditable(false);

        divOutput.setText("Result");
        divOutput.setEditable(false);

        prodLabel.setText("Multiplication");

        divLabel.setText("Division");

        result1.setText("Result");

        result2.setText("Result");

        prodInput2.setText("Input Integer");
        prodInput2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prodInput2MouseClicked(evt);
            }
        });

        divInput2.setText("Input Integer");
        divInput2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                divInput2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addComponent(executeMethods))
                        .addComponent(prodLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(divLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(divInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prodInput, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(prodInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(divInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prodOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(result1)
                    .addComponent(divOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(result2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {divLabel, prodLabel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(executeMethods)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(result1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prodOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prodLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prodInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prodInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(divLabel)
                            .addComponent(result2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(divInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(divOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(divInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void executeMethodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeMethodsActionPerformed
        pullNumbers();
        changeNumbers();
       prodOutput.setText(prodAns);
       divOutput.setText(divAns);
    }//GEN-LAST:event_executeMethodsActionPerformed

    private void prodInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prodInputMouseClicked
        prodInput.setText("");
    }//GEN-LAST:event_prodInputMouseClicked

    private void prodInput2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prodInput2MouseClicked
        prodInput2.setText("");
    }//GEN-LAST:event_prodInput2MouseClicked

    private void divInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_divInputMouseClicked
        divInput.setText("");
    }//GEN-LAST:event_divInputMouseClicked

    private void divInput2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_divInput2MouseClicked
        divInput2.setText("");
    }//GEN-LAST:event_divInput2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoesStuff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoesStuff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoesStuff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoesStuff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoesStuff().setVisible(true);
            }
        });
    }
    
    public void pullNumbers(){
        String field1 = prodInput.getText();
        String field2 = prodInput2.getText();
        String field3 = divInput.getText();
        String field4 = divInput2.getText();
        try {
        prodIn1 = Integer.parseInt(field1);
        prodIn2 = Integer.parseInt(field2);
        
        
        } catch(Exception e){
        
            JOptionPane.showMessageDialog(null, "Please input numbers in all fields", "Invalid Input", JOptionPane.INFORMATION_MESSAGE);
        
        }
        try{
            divIn1 = Double.parseDouble(field3);
            divIn2 = Double.parseDouble(field4);
        } catch(Exception e) {
        
            JOptionPane.showMessageDialog(null, "Please only input numbers", "Invalid Input", JOptionPane.INFORMATION_MESSAGE);
        
        }
        
        
    }
    
    public void changeNumbers(){
        int product = prodIn1 * prodIn2; 
        prodAns = String.valueOf(product);
        
        double dividend = divIn1/divIn2;
        divAns = String.valueOf(dividend);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField divInput;
    private javax.swing.JTextField divInput2;
    private javax.swing.JLabel divLabel;
    private javax.swing.JTextField divOutput;
    private javax.swing.JButton executeMethods;
    private javax.swing.JTextField prodInput;
    private javax.swing.JTextField prodInput2;
    private javax.swing.JLabel prodLabel;
    private javax.swing.JTextField prodOutput;
    private javax.swing.JLabel result1;
    private javax.swing.JLabel result2;
    // End of variables declaration//GEN-END:variables
}
