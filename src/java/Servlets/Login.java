/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
// iteration 2, Part of the followng code was taken from https://www.javatpoint.com/example-of-login-form-in-servlet 
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
         //getting value of input from form elements 
    String n=request.getParameter("loginusername");  
    String p=request.getParameter("loginpass");  
      //if they are validated through the Login DAO than the request is forwarded to the welcome servlet     
    if(LoginDao.validate(n, p)){  
        //RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");  
        //rd.forward(request,response); 
        //changes made in iteration 4
        response.setContentType("text/html");
      
      // New location to be redirected
      String site = new String("LandingPage.html");

      response.setStatus(response.SC_MOVED_TEMPORARILY);
      response.setHeader("Location", site); 
        
    }  
    else{  
        out.print("Sorry username or password error");  
        RequestDispatcher rd=request.getRequestDispatcher("login.html");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  
}  