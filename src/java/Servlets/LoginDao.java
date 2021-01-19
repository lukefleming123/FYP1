/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.sql.*;  
  
public class LoginDao {  
public static boolean validate(String Email,String Passsword){  
boolean status=false;  
try{  
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:sqlserver://supplyme.database.windows.net:1433;database=Supplyme;user=DBAdmin@supplyme;password=@lphadot60;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");  
      
PreparedStatement ps=con.prepareStatement(  
"select * from Users where Email=? and Passsword=?;");  
ps.setString(1,Email);  
ps.setString(2,Passsword);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  