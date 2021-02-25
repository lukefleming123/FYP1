<%-- 
    Document   : Orders
    Created on : 23-Feb-2021, 17:11:14
    Author     : luke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Order"%>
<%@ page import="java.util.List" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    <center> <h1>SupplyMe</h1> </center>
        
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="Index">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="orderform.html">Create Order</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="LandingPage.html">About us</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#"></a>
      </li>
    </ul>
  </div>
</nav>
    
    
    </head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                crossorigin="anonymous">
    <!-- <link rel="stylesheet" href="CSS/Main.css"> -->
     <style>
    body {
           
            
        }

    .my-container {
            position: relative;
            
            padding-top: 20px;
        }

    .my-row {
             
            
        }

    .my-col {
        border: 3px ;
        }
        
    .card-separator {
    margin: 20px;
  }
  
    .navbar{
     display: flex;
    justify-content: center;
  }
    .label{
    font-weight: bold;
    padding: 0px;
}
   .card-header{
    font-weight: bold;
}
.h2{
    margin-bottom: 10px;
    text-align: center;
}
   
    </style>
    <body>
        
         
        
        <!-- ------------------------------ -->
        
        
        <div class="container-fluid my-container">
            
        <div class="row my-row">
            <div class="col-md-3 ">
                
                
            </div> 
            <div class="col-md-6 "> 
                 <c:forEach items="${ordercategory}" var="order">
                     
                     <h2>Showing Orders in: </h2>
                     <h2><c:out value="${order.getCategory()}"/> </h2>
                <div class="card">
    <div class="card-header"><c:out value = "${order.getTitle()}"/></div>
    <div class="card-body">
        <ul Style="list-style: none">
           
            <div class="attribute">
                <label class="label" for="orderdesc">Order Description:</label>
                <li id="orderdesc"><c:out value="${order.getOrderDescription()}"/></li>
            </div>
            <div class="attribute">
                <label class="label" for="dateneeded">Date Needed:</label>
                <li id="dateneeded"><c:out value="${order.getDateNeeded()}"/></li>
            </div>
            <div class="attribute">
                <label class="label" for="qty">Quantity:</label>
                <li id="qty"><c:out value="${order.getQty()}"/></li>
            </div>
            <div class="attribute">
                <label class="label" for="category">Category:</label>
                <li id="category"><c:out value="${order.getCategory()}"/></li>
            </div>
            <div class="attribute">
                <label class="label" for="county">County:</label>
                <li id="county"><c:out value="${order.getCounty()}"/></li>
            </div>
            <div class="attribute">
                <label class="label" for="contactno">Contact Number:</label>
                <li id="contactno"><c:out value="${order.getContactno()}"/></li>
            </div>
        </ul>

    </div> 
    <div class="card-footer"><c:out value="${order.getemail()}"/></div>
  </div>
         </c:forEach>
                

                
             

                
                </div> 
          
           
            
            <div class="col-md-3 ">
        </div>

            
            
    </div>
        </div>
        
        <footer class="text-muted">
      <div class="container">
        <p class="float-right">
          <a href="#">Back to top</a>
        </p>
        <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>
        <p>New to Bootstrap? <a href="../../">Visit the homepage</a> or read our <a href="../../getting-started/">getting started guide</a>.</p>
      </div>
    </footer>
        
    
          
    </body>
</html>

