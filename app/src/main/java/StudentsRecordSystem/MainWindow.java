/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package StudentsRecordSystem;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Clancy Sanchez
 */
public class MainWindow extends javax.swing.JFrame {

    private final DatabaseRequests databaseHandler;
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        databaseHandler = new DatabaseRequests("database.db");
        initComponents();
    }

    public DefaultTableModel updateData(){
        DefaultTableModel tableModel = (DefaultTableModel) studentsDataView.getModel();
        String[] columnNames = databaseHandler.getColumnNames();
        if (columnNames != null) {
            for(String columName : columnNames) {
                tableModel.addColumn(columName.replace("_", " ").toUpperCase());
            }
            databaseHandler.getData(tableModel);
            TableColumn tableColumn = studentsDataView.getColumnModel().getColumn(0);
            tableColumn.setPreferredWidth(0);
            tableColumn.setMinWidth(0);
            tableColumn.setMaxWidth(0);
        }
        return tableModel;
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
        searchQuery = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        addStudentBtn = new javax.swing.JButton();
        windowAppLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        studentsDataView.setModel(updateData());
        studentsDataView.getTableHeader().setReorderingAllowed(false);
        studentsDataView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsDataViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentsDataView);

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        addStudentBtn.setText("Add Student");
        addStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentBtnActionPerformed(evt);
            }
        });

        windowAppLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        windowAppLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        windowAppLabel.setText("STUDENTS RECORD SYSTEM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(windowAppLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(searchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchBtn)
                        .addGap(314, 314, 314)
                        .addComponent(addStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(windowAppLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn)
                    .addComponent(addStudentBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        String searchString = searchQuery.getText();
        DefaultTableModel tableModel = new DefaultTableModel();
        if(!databaseHandler.searchData(tableModel, studentsDataView,searchString)){
            JOptionPane.showMessageDialog(this, "No result");
        }
        
    }//GEN-LAST:event_searchBtnActionPerformed

    private void addStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentBtnActionPerformed
        // TODO add your handling code here:
        ModalWindow modalDialog = new ModalWindow(this, true);
        ModalWindow.updateBtn.setVisible(false);
        ModalWindow.deleteBtn.setVisible(false);
        ModalWindow.addBtn.setVisible(true);
        modalDialog.setVisible(true);
    }//GEN-LAST:event_addStudentBtnActionPerformed

    private void studentsDataViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsDataViewMouseClicked
        // TODO add your handling code here:
        ModalWindow modalDialog = new ModalWindow(this, true);
        ModalWindow.addBtn.setVisible(false);
        ModalWindow.updateBtn.setVisible(true);
        ModalWindow.deleteBtn.setVisible(true);
        JTextField[] textFields = {ModalWindow.firstNameTextField, ModalWindow.lastNameTextField,
                        ModalWindow.ageTextField, ModalWindow.phoneTextField, ModalWindow.courseTextField,
                        ModalWindow.studentNoTextField};
        for(int i = 0; i < textFields.length; i++) {
            textFields[i].setText(studentsDataView.getValueAt(studentsDataView.getSelectedRow(), i+1).toString());
        }
        
        modalDialog.setVisible(true);
    }//GEN-LAST:event_studentsDataViewMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStudentBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchQuery;
    public static final javax.swing.JTable studentsDataView = new javax.swing.JTable();
    private javax.swing.JLabel windowAppLabel;
    // End of variables declaration//GEN-END:variables
}
