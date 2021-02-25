/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import dao.OrderDAOimpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Order;

/**
 *
 * @author luke
 */
@WebServlet(name = "OrderCategoryServlet", urlPatterns = {"/OrderCategoryServlet"})
public class OrderCategoryServlet extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String category = request.getParameter("category");
        System.out.println(category);
        
        
        try {  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con = null;
        try {  
            con = DriverManager.getConnection(  
                    "jdbc:sqlserver://supplyme.database.windows.net:1433;database=Supplyme;user=DBAdmin@supplyme;password=@lphadot60;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        } catch (SQLException ex) {
            Logger.getLogger(OrderCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
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
                
                
                request.setAttribute("ordercategory", ordercategory);
            RequestDispatcher view = request.getRequestDispatcher("Orders.jsp");
            view.forward(request, response); 
                //System.out.println(orderData+ "Orders");
                
            }

        
   }   catch (SQLException ex) {
           Logger.getLogger(OrderDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
       }
    
        
    
   }
        
      
    
	} 
