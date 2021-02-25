/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class WelcomeServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
  //Part of following code taken from https://www.tutorialspoint.com/servlets/servlets-page-redirect.htm Iteration 2
 // Set response content type
      response.setContentType("text/html");

      // New location to be redirected
      String site = new String("LandingPage.html");

      response.setStatus(response.SC_MOVED_TEMPORARILY);
      response.setHeader("Location", site); 
      
}
}  
