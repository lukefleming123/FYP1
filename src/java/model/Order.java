/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author luke
 */
/** Getters and setters class for Orders
 /**
 * @author luke
 */
public class Order {
    private String Title;
    private String OrderDescription;
    private String DateNeeded;
    private int Qty;
    private String Category;
    private String County;
    private String Contactno;
    private String email;
    
    //public Order(){}
    

   // public Order(String Title, String OrderDescription, String DateNeeded, int Qty, String Category, String County, String Contactno, String email) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     //   this.Title = Title;
     //   this.OrderDescription = OrderDescription;
     //   this.DateNeeded = DateNeeded;
     //   this.Qty = Qty;
      //  this.Category = Category;
      //  this.County = County;
      //  this.Contactno = Contactno;
      //  this.email = email;
  //  }

   
    public String getTitle(){
        return Title;
    }
    public void setTitle(String Title){
       this.Title = Title;
    }
    public String getOrderDescription(){
        return OrderDescription;
    }
    public void setOrderDescription(String OrderDescription){
        this.OrderDescription = OrderDescription;
    }
    public String getDateNeeded(){
        return DateNeeded;  
    }
    public void setDateNeeded(String DateNeeded){
        this.DateNeeded = DateNeeded;
    }
    public int getQty() {
        return Qty;
    }
    public void setQty(int Qty) {
		this.Qty = Qty;
	}
    public String getCategory(){
        return Category;  
    }
    public void setCategory(String Category){
        this.Category = Category;
    }
    public String getCounty(){
        return County;  
    }
    public void setCounty(String County){
        this.County = County;
    }
    public String getContactno(){
        return Contactno;  
    }
    public void setContactno(String Contactno){
        this.Contactno = Contactno;
    }
    public String getemail(){
        return email;  
    }
    public void setemail(String email){
        this.email = email;
    }
    }
    


