/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentsRecordSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Clancy Sanchez
 */
public class DatabaseUtility {
    private String databaseName;
    
    public DatabaseUtility(){
        
    }
    
    public DatabaseUtility(String databaseName) {
        if (databaseName.endsWith(".db")) {
            this.databaseName = databaseName;
        } else {
            this.databaseName = databaseName + ".db";
        }
    }
    
    public void setDatabaseName(String databaseName) {
        if (databaseName.endsWith(".db")) {
            this.databaseName = databaseName;
        } else {
            this.databaseName = databaseName + ".db";
        }
    }
    
  
    // since we are only dealing with simple project let's leave it unprotected
    // no password or username
    private Connection CreateDatabaseConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + this.databaseName);
            if (connection != null) {
                return connection;
            } else {
                return null;
            }
        } catch (SQLException e) {
            Logger.getLogger(DatabaseRequests.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    // closes the connection
    public void Close(Connection connection) {
        try {
            if(connection != null)
                connection.close();
        } catch(SQLException e) {
            Logger.getLogger(DatabaseRequests.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // executes query that doen't retrieve data.
    public boolean ExecuteQuery(String query) {
        Connection connection = CreateDatabaseConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.setQueryTimeout(30);
                statement.executeUpdate(query);
                return true;
            } catch (SQLException e) {
                Logger.getLogger(DatabaseRequests.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return false;
    }

    // executes query that returns data
    public ResultSet RetrieveQuery(String query) {
        Connection connection = CreateDatabaseConnection();
        if(connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.setQueryTimeout(30);
                return statement.executeQuery(query);
            } catch (SQLException e) {
                Logger.getLogger(DatabaseRequests.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
}
