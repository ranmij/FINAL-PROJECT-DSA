/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package StudentsRecordSystem;

import javax.swing.JTextField;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Jomari Tenorio
 */
public class ModalWindow extends javax.swing.JDialog {

    private final DatabaseRequests databaseHandler;
    /**
     * Creates new form ModalWindow
     * @param parent
     * @param modal
     */
    public ModalWindow(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        databaseHandler = new DatabaseRequests("database.db");
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

        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        courseLabel = new javax.swing.JLabel();
        studentNoLabel = new javax.swing.JLabel();
        modalWindowLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        firstNameLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        firstNameLabel.setText("First Name:");

        lastNameLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lastNameLabel.setText("Last Name:");

        ageLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        ageLabel.setText("Age:");

        phoneLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        phoneLabel.setText("Phone:");

        courseLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        courseLabel.setText("Course:");

        studentNoLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        studentNoLabel.setText("Student No:");

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        modalWindowLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        modalWindowLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        modalWindowLabel.setText("Students Information");

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modalWindowLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(firstNameLabel)
                                                    .addGap(33, 33, 33))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(lastNameLabel)
                                                    .addGap(35, 35, 35)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(ageLabel)
                                                .addGap(73, 73, 73)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(phoneLabel)
                                            .addGap(58, 58, 58)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(courseLabel)
                                        .addGap(55, 55, 55)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(studentNoLabel)
                                    .addGap(29, 29, 29)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deleteBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(updateBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addBtn))
                            .addComponent(courseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(modalWindowLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLabel)
                    .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseLabel)
                    .addComponent(courseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentNoLabel)
                    .addComponent(studentNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateBtn))
                .addGap(22, 22, 22))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
    // Click event
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        JTextField[] textFields = {
            firstNameTextField, lastNameTextField, ageTextField, phoneTextField, courseTextField, studentNoTextField
        };
        String[] data = {firstNameTextField.getText(), lastNameTextField.getText(), 
                ageTextField.getText(), phoneTextField.getText(), courseTextField.getText(),
                studentNoTextField.getText()};
        
        if (Arrays.asList(data).stream().allMatch((x) -> !x.isBlank() && !x.isEmpty()) && databaseHandler.insertData(data, MainWindow.studentsDataView)) {
            this.setVisible(false);
            for(JTextField textField : textFields) {
               textField.setText("");
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    // Click event
    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String id = null;
        if(MainWindow.studentsDataView.getRowCount() > 0) {
            id = MainWindow.studentsDataView.getValueAt(MainWindow.studentsDataView.getSelectedRow(), 0).toString();
            String[] data = {firstNameTextField.getText(), lastNameTextField.getText(),
                        ageTextField.getText(), phoneTextField.getText(), courseTextField.getText(),
                        studentNoTextField.getText()};
            JTextField[] textFields = {
                firstNameTextField, lastNameTextField, ageTextField, phoneTextField, courseTextField, studentNoTextField
            };
            if(Arrays.asList(textFields).stream().allMatch((x) -> !x.getText().isBlank() && !x.getText().isEmpty())) {
                if(databaseHandler.updateData(data, MainWindow.studentsDataView, id)) {
                    JOptionPane.showMessageDialog(this, "Updated Successfully.");
                    this.setVisible(false);
                    MainWindow.studentsDataView.setRowSelectionInterval(0, 0);
                }
            }
            for (JTextField textField : textFields)
                textField.setText("");
        }
        
    }//GEN-LAST:event_updateBtnActionPerformed

    // Click event
    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        String id = null;
        if(MainWindow.studentsDataView.getSelectedRow() > -1) {
            id = MainWindow.studentsDataView.getValueAt(MainWindow.studentsDataView.getSelectedRow(), 0).toString();
            if(databaseHandler.deleteData(MainWindow.studentsDataView, id)) {
                JOptionPane.showMessageDialog(this, "Deleted successfully.");
                this.setVisible(false);
                MainWindow.studentsDataView.clearSelection();
            }
            JTextField[] textFields = {
                firstNameTextField, lastNameTextField, ageTextField, phoneTextField, courseTextField, studentNoTextField
            };
            for (JTextField textField : textFields)
                textField.setText("");
        }
        

    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JButton addBtn = new javax.swing.JButton();
    private javax.swing.JLabel ageLabel;
    public static final javax.swing.JTextField ageTextField = new javax.swing.JTextField();
    private javax.swing.JLabel courseLabel;
    public static final javax.swing.JTextField courseTextField = new javax.swing.JTextField();
    public static final javax.swing.JButton deleteBtn = new javax.swing.JButton();
    private javax.swing.JLabel firstNameLabel;
    public static final javax.swing.JTextField firstNameTextField = new javax.swing.JTextField();
    private javax.swing.JLabel lastNameLabel;
    public static final javax.swing.JTextField lastNameTextField = new javax.swing.JTextField();
    private javax.swing.JLabel modalWindowLabel;
    private javax.swing.JLabel phoneLabel;
    public static final javax.swing.JTextField phoneTextField = new javax.swing.JTextField();
    private javax.swing.JLabel studentNoLabel;
    public static final javax.swing.JTextField studentNoTextField = new javax.swing.JTextField();
    public static final javax.swing.JButton updateBtn = new javax.swing.JButton();
    // End of variables declaration//GEN-END:variables
}
