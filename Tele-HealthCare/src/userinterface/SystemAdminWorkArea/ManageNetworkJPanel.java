/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Network.Network;
import Business.NetworkDAO.NetworkDAO;
import Business.NetworkDAO.iNetworkDAO;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Neelu
 */
public class ManageNetworkJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private EcoSystem system;
    private iNetworkDAO networkDAO;

   
    
    /**
     * Creates new form ManageNetworkJPanel
     */
    public ManageNetworkJPanel(JPanel upc, EcoSystem sys) {
        initComponents();
        userProcessContainer = upc;
        system = sys;
        networkDAO = new NetworkDAO();
        
        populateNetworkTable();
    }
    
     private void populateNetworkTable() {
        DefaultTableModel model = (DefaultTableModel) networkJTable.getModel();

        model.setRowCount(0);
        
        List<Network> networkList = new ArrayList<>();
        try {
            networkList = networkDAO.findAll();
        } catch (Exception ex) {
            Logger.getLogger(ManageNetworkJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //old code 
        //for (Network network : system.getNetworkList()) {
        for (Network network : networkList) {
            Object[] row = new Object[1];
            row[0] = network.getName();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        networkJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        submitJButton = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        networkJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        networkJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "State "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(networkJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 404, 91));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Add A State To The Network");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        submitJButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, -1, -1));

        nameJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJTextFieldActionPerformed(evt);
            }
        });
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("View The Existing States in the EcoSystem");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setText("Manage Networks");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed

       try{
           
           String name = nameJTextField.getText();
           if(name.trim().isEmpty()){
               JOptionPane.showMessageDialog(null,"Network field is empty");
               return;
           }
           
            //old code
            //Network network = system.createAndAddNetwork();
            Network network = new Network(0, name);            
            networkDAO.insertNetwork(network);
            populateNetworkTable();
       
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,"Please enter a vaild string: " + e);
           return;
       }
        
        
    }//GEN-LAST:event_submitJButtonActionPerformed

    public void refresh(){
        int index= userProcessContainer.getComponentCount() -1;
        SystemAdminWorkAreaJPanel panel = (SystemAdminWorkAreaJPanel)userProcessContainer.getComponent(index);
        
        
        panel.populateTree();
        
        
    }
    private void nameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTable networkJTable;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
