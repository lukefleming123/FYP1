/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import dao.OrderDAO;
import dao.OrderDAOimpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Order;

/**
 *
 * @author luke
 */
// Part of the following code was taken from https://www.javaguides.net/2019/03/jsp-servlet-jdbc-mysql-crud-example-tutorial.html
public class GetOrdersServlet extends HttpServlet{ //implements OrderDAO{

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Creating new instance of OrderDAOimpl class to 
            
            OrderDAOimpl orderDAO = new OrderDAOimpl();
            //creating array object to hold rows obtained from sql query
            ArrayList<Order> allOrders = null;
         try {
             allOrders = orderDAO.getAllOrders();
             
         } catch (SQLException ex) {
             Logger.getLogger(GetOrdersServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(GetOrdersServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
          //System.out.println(allOrders);      
         //PrintWriter MyResponse = response.getWriter();
          //MyResponse.println("<title>test</title><p>" + allOrders.get(0).getTitle());
           request.setAttribute("allOrders", allOrders);
            RequestDispatcher view = request.getRequestDispatcher("Index.jsp");
            view.forward(request, response); 
                
      
    
	} 

        
        
        } 
    
    
