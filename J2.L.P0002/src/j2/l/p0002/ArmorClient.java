/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2.l.p0002;

import InforAmorDTO.ArmorDTO;
import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cutay
 */
public class ArmorClient extends javax.swing.JFrame {
    String serviceName = "rmi://localhost:1098/ArmorService";
    AmorInterface server = null;
    Vector<ArmorDTO> data = null;
    DefaultTableModel model = null;
    boolean checkData = true;
    /**
     * Creates new form ArmorClient
     */
    public ArmorClient() {
        initComponents();
        txtTimeOfCreate.setEnabled(false);
        
        try {
            server = (AmorInterface) Naming.lookup(serviceName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadData(){
        if (server != null) {
            Vector<String> headerTable = new Vector<>();
            headerTable.add("ID");
            headerTable.add("Classification");
            headerTable.add("TimeOfCreate");
            headerTable.add("Defense");
            Vector dataTable = new Vector();
            
            try {
                data = (Vector<ArmorDTO>) server.findAllArmor();

            } catch (Exception e) {
                e.printStackTrace();
            }
            for (ArmorDTO armorDTO : data) {
                Vector row = new Vector();
                row.add(armorDTO.getArmorId());
                row.add(armorDTO.getClassification());
                row.add(convertDateToString(armorDTO.getTimeOfCreate()));
                row.add(armorDTO.getDefense());
                dataTable.add(row);
            }
            model = (DefaultTableModel) tbArmor.getModel();
            model.setDataVector(dataTable, headerTable);
        }else{
            JOptionPane.showMessageDialog(this, "Server not founded");
        }
            

    }
    
    private String convertDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }
    
    private Date convertStringToDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(date);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
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
        tbArmor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btCreate = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        txtArmorID = new javax.swing.JTextField();
        txtClassification = new javax.swing.JTextField();
        txtTimeOfCreate = new javax.swing.JTextField();
        txtDefense = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        txtStatus = new javax.swing.JTextField();
        btRemove = new javax.swing.JButton();
        javax.swing.JButton btFindByArmorID = new javax.swing.JButton();
        btNew = new javax.swing.JButton();
        btGetAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbArmor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbArmor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbArmorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbArmor);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(29, 78, 230));
        jLabel1.setText("Armor Client");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Armor's Detail:"));

        jLabel2.setText("ArmorID:");

        jLabel3.setText("Classification:");

        jLabel4.setText("TimeOfCreate:");

        jLabel5.setText("Defense:");

        jLabel6.setText("Description:");

        jLabel7.setText("Status:");

        btCreate.setText("Create");
        btCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreateActionPerformed(evt);
            }
        });

        btUpdate.setText("Update");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        btRemove.setText("Remove");
        btRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveActionPerformed(evt);
            }
        });

        btFindByArmorID.setText("Find By ArmorID");
        btFindByArmorID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFindByArmorIDActionPerformed(evt);
            }
        });

        btNew.setText("New");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(btNew))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btUpdate)
                        .addGap(29, 29, 29)
                        .addComponent(btRemove)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtArmorID)
                            .addComponent(txtClassification)
                            .addComponent(txtTimeOfCreate)
                            .addComponent(txtDefense)
                            .addComponent(txtStatus)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btFindByArmorID)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtArmorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFindByArmorID))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtClassification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTimeOfCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDefense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCreate)
                    .addComponent(btUpdate)
                    .addComponent(btRemove)
                    .addComponent(btNew))
                .addGap(46, 46, 46))
        );

        btGetAll.setText("Get All");
        btGetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGetAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(btGetAll))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(385, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btGetAll)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbArmorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbArmorMouseClicked
        checkData = false;
        int row = tbArmor.getSelectedRow();
        String armorID = (String) tbArmor.getValueAt(row, 0);
        try {
            ArmorDTO armor = server.findByArmorID(armorID);
            txtArmorID.setText(armor.getArmorId());
            txtArmorID.setEnabled(false);
            txtClassification.setText(armor.getClassification());
            txtTimeOfCreate.setText(convertDateToString(armor.getTimeOfCreate()));
            txtDefense.setText("" + armor.getDefense());
            txtDescription.setText(armor.getDescription());
            txtStatus.setText(armor.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbArmorMouseClicked

    private void btGetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGetAllActionPerformed
        loadData();
    }//GEN-LAST:event_btGetAllActionPerformed

    private boolean validData(){
            String armorID = txtArmorID.getText().trim();
            if(!armorID.matches("^[^@#$]*$") && (armorID.length() <= 10 && armorID.length() > 0)){
                txtArmorID.requestFocus();
                JOptionPane.showMessageDialog(this, "armorID is error.");
                return false;
            }
            
            String classification = txtClassification.getText().trim();
            if (classification.length() < 0 || classification.length() > 30 ) {
                txtClassification.requestFocus();
            JOptionPane.showMessageDialog(this, "classification is error.");
            return false;
        }
            
        String defense = txtDefense.getText().trim();
        if (!defense.matches("^[0-9]") && (Integer.parseInt(defense) < 0)) {
            JOptionPane.showMessageDialog(this, "Address is error.");
            txtDefense.requestFocus();
            return false;
        }
        
        String description = txtDescription.getText().trim();
        if (description.length() < 0 || description.length() > 300) {
            JOptionPane.showMessageDialog(this, "Description is error.");
            txtDescription.requestFocus();
            return false;
        }
        
        String status = txtStatus.getText().trim();
        if (status.matches("[^0-9]")) {
            JOptionPane.showMessageDialog(this, "Status is error.");
            txtStatus.requestFocus();
            return false;
        }
        return true;
    }
    
    private void btCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreateActionPerformed
        
        if (checkData) {
            if (validData()) {
                
            
            String armorID = txtArmorID.getText().trim();
            String classification = txtClassification.getText().trim();
            Date date = new Date();
            String defense = txtDefense.getText().trim();
            String description = txtDescription.getText().trim();
            String status = txtStatus.getText().trim();
            boolean isValid = false;
            ArmorDTO armor = new ArmorDTO(armorID, classification, description,
                    status, date, Integer.parseInt(defense));
            
            ArmorDTO checkArmor = null;
            try {
                checkArmor = server.findByArmorID(armorID);
            } catch (Exception e) {
            e.printStackTrace();
            }
            if (armor != null) {
                JOptionPane.showMessageDialog(this, "Duplicate");
            }
            try {
                isValid = server.createArmor(armor);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (isValid) {
                JOptionPane.showMessageDialog(this, "Create succesful");
                loadData();
                txtArmorID.setText("");
                txtArmorID.setEnabled(true);
                txtClassification.setText("");
                txtTimeOfCreate.setText("");
                txtDefense.setText("");
                txtDescription.setText("");
                txtStatus.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Armor ID already existed");
            }
        }
        }else{
            JOptionPane.showMessageDialog(this, "please click button \"New\"");
        }
    }//GEN-LAST:event_btCreateActionPerformed

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        txtArmorID.setText("");
        txtArmorID.setEnabled(true);
        txtClassification.setText("");
        txtTimeOfCreate.setText("");
        txtDefense.setText("");
        txtDescription.setText("");
        txtStatus.setText("");
        checkData = true;
    }//GEN-LAST:event_btNewActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        if (!checkData) {
            if (validData()) {
            String armorID = txtArmorID.getText().trim();
            String classfication = txtClassification.getText().trim();
            String date = txtTimeOfCreate.getText().trim();
            String defense = txtDefense.getText().trim();
            String description = txtDescription.getText().trim();
            String status = txtStatus.getText().trim();
                ArmorDTO armor = new ArmorDTO(armorID, classfication, description,
                        status, convertStringToDate(date), Integer.parseInt(defense));
                boolean isUpdated = false;
                try {
                    isUpdated = server.updateArmor(armor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (isUpdated) {
                    JOptionPane.showMessageDialog(this, "Update successful");
                    txtArmorID.setText("");
                    txtArmorID.setEnabled(true);
                    txtClassification.setText("");
                    txtTimeOfCreate.setText("");
                    txtDefense.setText("");
                    txtDescription.setText("");
                    txtStatus.setText("");
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(this, "Udpate fail");
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "plese choose row");
        }
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveActionPerformed
        if (!checkData) {
            if (JOptionPane.showConfirmDialog(this, "Do you want to remove?")
                    == JOptionPane.OK_OPTION) {
                String armorID = txtArmorID.getText();
                boolean isRemoved = false;
                try {
                    isRemoved = server.removeArmor(armorID);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (isRemoved) {
                    JOptionPane.showMessageDialog(this, "Remove successful");
                    txtArmorID.setText("");
                    txtArmorID.setEnabled(true);
                    txtClassification.setText("");
                    txtTimeOfCreate.setText("");
                    txtDefense.setText("");
                    txtDescription.setText("");
                    txtStatus.setText("");
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(this, "Remove fail");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "plese choose row");
        }
    }//GEN-LAST:event_btRemoveActionPerformed

    private void btFindByArmorIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFindByArmorIDActionPerformed
        if (checkData) {
        String armorID = txtArmorID.getText();
        ArmorDTO armor = null;
        try {
            armor = server.findByArmorID(armorID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (armor != null) {
            txtArmorID.setText(armor.getArmorId());
            txtArmorID.setEnabled(false);
            txtClassification.setText(armor.getClassification());
            txtTimeOfCreate.setText(convertDateToString(armor.getTimeOfCreate()));
            txtDefense.setText("" + armor.getDefense());
            txtDescription.setText(armor.getDescription());
            txtStatus.setText(armor.getStatus());;
        } else {
            JOptionPane.showMessageDialog(this, "Armor ID not founded");
        }
        }else{
            JOptionPane.showMessageDialog(this, "please type Button \"New\"");
        }
    }//GEN-LAST:event_btFindByArmorIDActionPerformed

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
            java.util.logging.Logger.getLogger(ArmorClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArmorClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArmorClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArmorClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArmorClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCreate;
    private javax.swing.JButton btGetAll;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btRemove;
    private javax.swing.JButton btUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbArmor;
    private javax.swing.JTextField txtArmorID;
    private javax.swing.JTextField txtClassification;
    private javax.swing.JTextField txtDefense;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTimeOfCreate;
    // End of variables declaration//GEN-END:variables
}
