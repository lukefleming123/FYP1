/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
//Part of the followng code was taken from https://www.javatpoint.com/example-of-login-form-in-servlet Iteration 1
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class Login extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("loginusername");  
    String p=request.getParameter("loginpass");  
          
    if(LoginDao.validate(n, p)){  
        RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");  
        rd.forward(request,response);  
    }  
    else{  
        out.print("Sorry username or password error");  
        RequestDispatcher rd=request.getRequestDispatcher("login.html");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  
}  