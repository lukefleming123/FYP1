/*
 Iteration 2, https://www.javatpoint.com/example-of-login-form-in-servlet
 */
package Servlets;

import java.sql.*;  
  
public class LoginDao {  
public static boolean validate(String Email,String Passsword){  
boolean status=false;  
try{  
    //Referencing driver class 
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:sqlserver://supplyme.database.windows.net:1433;database=Supplyme;user=DBAdmin@supplyme;password=@lphadot60;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");  
      //Sql code to be executed once connection to DB has been made
PreparedStatement ps=con.prepareStatement(  
"select * from Users where Email=? and Passsword=?;");  
//converting values to string 
ps.setString(1,Email);  
ps.setString(2,Passsword);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(ClassNotFoundException e){System.out.println(e);} catch (SQLException e) {  
    System.out.println(e);
    }
return status;  

}  
}  