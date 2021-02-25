/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luke
 */
public class DatabaseClass {
    protected static Connection initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 
        // Initialize all the information regarding 
        // Database Connection 
        String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
        String dbURL = "jdbc:sqlserver://supplyme.database.windows.net:1433;database=Supplyme;user=DBAdmin@supplyme;password=@lphadot60;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    Class.forName(dbDriver); 
        Connection con = DriverManager.getConnection(dbURL); 
        return con; 
        
    }
    
}
