package Servlets;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.util.Properties;

//Iteration 1 Part of the following code was taken from https://www.javatpoint.com/example-of-registration-form-in-servlet
public class Register extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String name=request.getParameter("userName"); 
String category=request.getParameter("userCategory");
String bio=request.getParameter("userBIO");
String address=request.getParameter("userAddress");
String county=request.getParameter("userCounty");  
String phone=request.getParameter("userPhone");
String password=request.getParameter("userPass");  
String email=request.getParameter("userEmail");  
 
          
try{  
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:sqlserver://supplyme.database.windows.net:1433;database=Supplyme;user=DBAdmin@supplyme;password=@lphadot60;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");  
  
PreparedStatement ps=con.prepareStatement(  
"INSERT INTO Users (BusinessName, BusinessCategory, BIO, Address, County, Email, Phone, Passsword) VALUES (?,?,?,?,?,?,?,?);"); 
  
ps.setString(1,name);
ps.setString(2,category);
ps.setString(3,bio);
ps.setString(4,address);  
ps.setString(5,county);  
ps.setString(6,email);
ps.setString(7,phone);
ps.setString(8,password);
          
int i=ps.executeUpdate();  
if(i>0)  

out.print("You are successfully registered...");  
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
	}

}
