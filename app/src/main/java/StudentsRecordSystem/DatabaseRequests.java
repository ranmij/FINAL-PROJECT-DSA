/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentsRecordSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Clancy Sanchez
 */
public class DatabaseRequests extends DatabaseUtility {    
    DatabaseRequests(String databaseName) {
        String defaultPath = System.getProperty("user.home") + "\\SchoolRecordSystem\\";
        if (!Files.exists(Paths.get((databaseName.endsWith(".db"))? defaultPath+databaseName : defaultPath+databaseName+".db"))) {
            try {
                Files.createDirectories(Paths.get(System.getProperty("user.home") + "\\SchoolRecordSystem"));
                this.setDatabaseName(System.getProperty("user.home") + "\\SchoolRecordSystem\\" + databaseName);
                if (!initTables()) {
                    System.exit(1);
                }
            } catch (IOException ex) {
                Logger.getLogger(DatabaseRequests.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.setDatabaseName(System.getProperty("user.home") + "\\SchoolRecordSystem\\" + databaseName);
        }
    }
    
    private boolean initTables(){
        String sqlQuery = "CREATE TABLE students_tbl (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + "first_name VARCHAR(50) NOT NULL, last_name VARCHAR(50) NOT NULL,"
                + "age INT NOT NULL, phone VARCHAR(20) NOT NULL, course VARHCAR(10) NOT NULL,"
                + "student_no VARHCAR(6) NOT NULL)";
        if (ExecuteQuery("DROP TABLE IF EXISTS students_tbl")) {
            return ExecuteQuery(sqlQuery);
        }
        return false;
    }
    
    private void fillColumnHeaders(DefaultTableModel tableModel) {
        String[] columnNames = getColumnNames();
        if (columnNames != null) {
            for(String columName : columnNames) {
                tableModel.addColumn(columName.replace("_", " ").toUpperCase());
            }
        }
    }
    
    private boolean fillDataRows(DefaultTableModel tableModel, JTable table, ResultSet resData) {
        if (resData != null) {
            
            try {
                fillColumnHeaders(tableModel);
                String[] columns = {"id", "first_name", "last_name", "age", "phone", "course", "student_no"};
                if (resData.next()) {
                    do {
                        Object[] data = new Object[7];
                        for (int i = 0; i < columns.length; i++) {
                            data[i] = (Object)resData.getString(columns[i]);
                        }
                        tableModel.addRow(data);
                    } while(resData.next());
                    table.setModel(tableModel);
                    TableColumn tableColumn = table.getColumnModel().getColumn(0);
                    tableColumn.setPreferredWidth(0);
                    tableColumn.setMinWidth(0);
                    tableColumn.setMaxWidth(0);
                    return true;
                } else {
                    table.setModel(tableModel);
                    return false;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseRequests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public String[] getColumnNames() {
        String[] columns = new String[7];
        ResultSet columnNames = RetrieveQuery("SELECT name FROM PRAGMA_TABLE_INFO('students_tbl');");
        try {
           if (columnNames != null) {
               int index = 0;
               while(columnNames.next()) {
                    columns[index++] = columnNames.getString("name");
               }
               return columns;
           } else {
               return null;
           }
        }catch(SQLException e) {
            return null;
        }
    }
    
    public void getData(DefaultTableModel tableModel) {
        ResultSet rawData = RetrieveQuery("SELECT first_name, last_name, age, phone, course, student_no, id FROM students_tbl;");
        if (rawData != null) {
            try {
                String[] columns = {"id", "first_name", "last_name", "age", "phone", "course", "student_no"};
                while(rawData.next()){
                    Object[] data = new Object[7];
                    for (int i = 0; i < columns.length; i++) {
                        data[i] = (Object)rawData.getString(columns[i]);
                    }
                    tableModel.addRow(data);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseRequests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean searchData(DefaultTableModel tableModel, JTable table, String searchQuery) {
        ResultSet rawData;
        if (!searchQuery.isBlank() || searchQuery.isEmpty())
            rawData = RetrieveQuery("SELECT id, first_name, last_name, age, phone, course, student_no FROM students_tbl WHERE " +
                String.format("first_name LIKE '%s%%' OR last_name LIKE '%s%%' OR age LIKE '%s%%' OR phone LIKE '%s%%' OR course LIKE '%s%%' OR student_no LIKE '%s%%';", searchQuery,
                            searchQuery, searchQuery, searchQuery, searchQuery, searchQuery));
        else 
            rawData = RetrieveQuery("SELECT id, first_name, last_name, age, phone, course, student_no FROM students_tbl;");
        return fillDataRows(tableModel, table, rawData);
    }
    
    public boolean insertData(String[] data, JTable table) {
        if (ExecuteQuery(String.format("INSERT INTO students_tbl (first_name, last_name, age, phone,course, student_no) VALUES ('%s', '%s', %d , '%s', '%s', '%s');", data[0], data[1], Integer.parseInt(data[2]), data[3], data[4], data[5]))) {
            DefaultTableModel tableModel = new DefaultTableModel();
            ResultSet rawData = RetrieveQuery("SELECT id, first_name, last_name, age, phone, course, student_no FROM students_tbl;");
            fillDataRows(tableModel, table, rawData);
            return true;
        }
        return false;
    }
    
    public boolean updateData(String[] data, JTable table, String id) {
        if(ExecuteQuery(String.format("UPDATE students_tbl SET first_name = '%s',"
                + "last_name = '%s', age = %s, phone = '%s', course = '%s', student_no = '%s'"+
                " WHERE id = %s;", data[0],data[1],data[2],data[3],data[4],data[5], id))){
            DefaultTableModel tableModel = new DefaultTableModel();
            ResultSet rawData = RetrieveQuery("SELECT id, first_name, last_name, age, phone, course, student_no FROM students_tbl;");
            return fillDataRows(tableModel, table, rawData);

        }
        return false;
    }
    
    public boolean deleteData(JTable table, String id) {
        if(ExecuteQuery(String.format("DELETE FROM students_tbl WHERE id = %s", id))) {
            DefaultTableModel tableModel = new DefaultTableModel();
            ResultSet rawData = RetrieveQuery("SELECT id, first_name, last_name, age, phone, course, student_no FROM students_tbl;");
            fillDataRows(tableModel, table, rawData);
            return true;
        }
        return false;
    }
}
