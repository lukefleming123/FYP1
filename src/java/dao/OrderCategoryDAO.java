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
public class OrderCategoryDAO {
    public ArrayList<Order> getOrderbyCategory(String category) throws ClassNotFoundException, SQLException{
        Order order = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
        Connection con=DriverManager.getConnection(  
            "jdbc:sqlserver://supplyme.database.windows.net:1433;database=Supplyme;user=DBAdmin@supplyme;password=@lphadot60;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");  
        
        
        
        // creating new instance of array list 
        ArrayList<Order> ordercategory = new ArrayList();
        String query = "Select Title, OrderDescription, DateNeeded, Qty, Category, County, Contactno, email from Orders Where Category = ?;";
        
//executing SQL Query
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, category);   
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
                Order newOrder1 = new Order();
                newOrder1.setTitle(Title);
                newOrder1.setOrderDescription(OrderDescription);
                newOrder1.setDateNeeded(DateNeeded);
                newOrder1.setQty(Qty);
                newOrder1.setCategory(Category);
                newOrder1.setCounty(County);
                newOrder1.setContactno(Contactno);
                newOrder1.setemail(email);
                ordercategory.add(newOrder1);
                //System.out.println(orderData+ "Orders");
                
            }

        
        }   catch (SQLException ex) {
           Logger.getLogger(OrderDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
           
       }finally {
            if(con != null) {
                con.close();
            }
          

            
        }
      return ordercategory;
    }

    public ArrayList<Order> getOrderbyCategory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}