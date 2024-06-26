import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author cjrea
 */
public class gwaCalculatorGUI extends javax.swing.JFrame {

    /**
     * Creates new form gwaCalculatorGUI
     */
    public gwaCalculatorGUI() {
        initComponents();
        initGenerator();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SUBJECT");
        jLabel1.setMaximumSize(new java.awt.Dimension(150, 50));
        jLabel1.setMinimumSize(new java.awt.Dimension(150, 50));
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel1.add(jLabel1);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("UNITS");
        jLabel2.setMaximumSize(new java.awt.Dimension(150, 50));
        jLabel2.setMinimumSize(new java.awt.Dimension(150, 50));
        jLabel2.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel1.add(jLabel2);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FINAL");
        jLabel3.setMaximumSize(new java.awt.Dimension(150, 50));
        jLabel3.setMinimumSize(new java.awt.Dimension(150, 50));
        jLabel3.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel1.add(jLabel3);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
private void initGenerator() {
         // Ask for number of text fields
         String numText = JOptionPane.showInputDialog(null, "Enter the number of text fields:");
         int numFields;
         try {
                  numFields = Integer.parseInt(numText); // Gets the value entered
         } catch (NumberFormatException ex) {
         // Executes when user inputs a non-integer
                  JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                  System.exit(0);
                  return;
         }
         // Adds Spinners and Text Fields based on the amount the user inputted
         for (int i = 0; i < numFields; i++) {
         JTextField subjectName = new JTextField();
         JSpinner units = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 10.0, 1.0));
         JSpinner finalGrade = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 4.0, 0.1));
         subjectName.setPreferredSize(new Dimension(150, 50));
         subjectName.setMinimumSize(new Dimension(150, 50));
         subjectName.setMaximumSize(new Dimension(150, 50));
         
         units.setPreferredSize(new Dimension(150, 50));
         units.setMinimumSize(new Dimension(150, 50));
         units.setMaximumSize(new Dimension(150, 50));
         
         finalGrade.setPreferredSize(new Dimension(150, 50));
         finalGrade.setMinimumSize(new Dimension(150, 50));
         finalGrade.setMaximumSize(new Dimension(150, 50));
         jPanel1.add(subjectName);
         subjectName.setName("subject");
         jPanel1.add(units);
         units.setName("units");
         jPanel1.add(finalGrade);
         finalGrade.setName("finalGrade");
         pack();
         
}
         // Adds the button that allows the user to calculate the GWA
         JButton calculateGWA = new JButton("Calculate GWA");
         calculateGWA.setPreferredSize(new Dimension(150, 50));
         calculateGWA.setMinimumSize(new Dimension(150, 50));
         calculateGWA.setMaximumSize(new Dimension(150, 50));
         jPanel1.add(calculateGWA);
         JLabel GWA = new JLabel("", SwingConstants.CENTER);
         GWA.setPreferredSize(new Dimension(500, 50));
         GWA.setMinimumSize(new Dimension(500, 50));
         GWA.setMaximumSize(new Dimension(500, 50));
         jPanel1.add(GWA);
         pack();

// Action Listener for when the button is pressed
calculateGWA.addActionListener((ActionEvent e) -> {
         double totalUnits = 0; // Initialize totalUnits
         LinkedList<Double> units = new LinkedList<>(); 
         LinkedList<Double> finalGrades = new LinkedList<>();
         double grade = 0;
         double finalGrade = 0;
         // Gets all components; gets all units, adds them all, stores them in an array; also gets all grades and stores them on an array individually
         for (Component component1 : jPanel1.getComponents()) {
                  if (component1 instanceof JSpinner currentSpinner) {
                           if (currentSpinner.getName().contains("units")) {
                                    totalUnits += (double) currentSpinner.getValue();
                                    double toAdd = (double) currentSpinner.getValue();
                                    units.add(toAdd);
                           }
                  if (currentSpinner.getName().contains("finalGrade")) {
                           double toAdd = (double) currentSpinner.getValue();
                           finalGrades.add(toAdd);
                           }
                  }
         }
         // Calculates the final GWA
         for (int i = 0; i < units.size(); i++) {
                  grade += (finalGrades.get(i) * units.get(i));
        }
         finalGrade = grade / totalUnits;
         // Displays the final GWA
         GWA.setText(String.format("GWA: %.2f", finalGrade));
         pack();
        });

}                                   
    
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
            java.util.logging.Logger.getLogger(gwaCalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gwaCalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gwaCalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gwaCalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gwaCalculatorGUI().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
