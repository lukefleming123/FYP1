/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;

/**
 *
 * @author luke
 */
// Part of the following code was taken from https://www.javaguides.net/2019/03/jsp-servlet-jdbc-mysql-crud-example-tutorial.html
public class OrderDAOimpl {
    
   public static ArrayList <Order> getAllOrders() throws SQLException, ClassNotFoundException{
       
      
       //Driver class
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
        Connection con=DriverManager.getConnection(  
            "jdbc:sqlserver://supplyme.database.windows.net:1433;database=Supplyme;user=DBAdmin@supplyme;password=@lphadot60;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");  
        
        
        
        // creating new instance of array list 
        ArrayList<Order> orderData = new ArrayList();
        String query = "Select Title, OrderDescription, DateNeeded, Qty, Category, County, Contactno, email from Orders;";
            //executing SQL Query
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Read values using column name
                String Title = rs.getString("Title");
                String OrderDescription = rs.getString("OrderDescription");
                String DateNeeded = rs.getString("DateNeeded");
                int Qty = rs.getInt("Qty");
                String Category = rs.getString("Category");
                String County = rs.getString("County");
                String Contactno = rs.getString("Contactno");
                String email = rs.getString("email");
                Order newOrder = new Order();
                newOrder.setTitle(Title);
                newOrder.setOrderDescription(OrderDescription);
                newOrder.setDateNeeded(DateNeeded);
                newOrder.setQty(Qty);
                newOrder.setCategory(Category);
                newOrder.setCounty(County);
                newOrder.setContactno(Contactno);
                newOrder.setemail(email);
                orderData.add(newOrder);
                //System.out.println(orderData+ "Orders");
                
            }

        
        }   catch (SQLException ex) {
           Logger.getLogger(OrderDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
           
       }finally {
            if(con != null) {
                con.close();
            }
          

            
        }
      return orderData;
   
    
     }
} //Final
