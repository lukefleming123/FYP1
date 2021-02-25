/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luke
 */
public class OrdersServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  

    response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
       // Obtaining the value in input areas on the forms
       
String email=request.getParameter("orderEmail"); 
String contactno=request.getParameter("orderContactno");
String title=request.getParameter("orderTitle");
String orderdescription=request.getParameter("orderDescription");
String county=request.getParameter("orderCounty");  
String date=request.getParameter("orderDate");
int Quantity = Integer.parseInt(request.getParameter("orderQuantity"));  
String category=request.getParameter("orderCategory");
    try{  
    //Creating connection to the database using Driver class and URL for database
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:sqlserver://supplyme.database.windows.net:1433;database=Supplyme;user=DBAdmin@supplyme;password=@lphadot60;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");  
  
PreparedStatement ps=con.prepareStatement(  
"INSERT INTO Orders (email, Contactno, Title, OrderDescription, County, DateNeeded, Qty, Category) VALUES (?,?,?,?,?,?,?,?);"); 
  
ps.setString(1,email);
ps.setString(2,contactno);
ps.setString(3,title);
ps.setString(4,orderdescription);  
ps.setString(5,county);  
ps.setString(6,date);
ps.setInt(7,Quantity);
ps.setString(8,category);
          
int i=ps.executeUpdate();  
if(i>0)  
//forwarding resposnse to welcome servlet
out.print("You are successfully registered...");  
    RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");  
        rd.forward(request,response);        


}catch (ClassNotFoundException e2) {System.out.println(e2);} catch (SQLException e2) {  
    System.out.println(e2);
            }
          
out.close();  
	}

}

