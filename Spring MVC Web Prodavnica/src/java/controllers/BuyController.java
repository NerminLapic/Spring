/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.sql.DataSource;
import javax.validation.Valid;
import model.Buy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nermin
 */

@Controller
public class BuyController {

@Autowired
private DataSource dataSource;

  @RequestMapping(value = "/new_buy", method=RequestMethod.GET)
    public String NewBuyForm(Model model) throws SQLException{
        
        model.addAttribute("buy", new Buy());
        
         Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/web_prodavnica", "root", "");
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select * from products");
         HashMap<Integer,String> proizvodi=new HashMap<Integer,String>();
               while(rs.next()){
               proizvodi.put(rs.getInt("productId"),rs.getString("productName"));
               
               }   
        model.addAttribute("proizvodi",proizvodi);
       
        
       ResultSet rs1=st.executeQuery("select * from Customers");
         HashMap<Integer,String> kupci=new HashMap<Integer,String>();
               while(rs1.next()){
               kupci.put(rs1.getInt("customerId"),rs1.getString("firstName"));
               
               }     
        model.addAttribute("kupci",kupci);
   
        return "new_buy";
    }
    
    @RequestMapping(value = "new_buy", method = RequestMethod.POST)
    public  String addBuy(@ModelAttribute("buy") @Valid Buy buy,BindingResult result, ModelMap model) throws SQLException, ClassNotFoundException{
  
        if(result.hasErrors()){
            return "/new_buy";
        } 
         String message = null;
         String artikl=null;
          Integer ID=buy.getProductId();
          String sql="UPDATE  PRODUCTS SET productQty=? WHERE productId=?";
          
          Class.forName("com.mysql.jdbc.Driver");
     
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/web_prodavnica", "root", "")){
         Statement st=conn.createStatement();
        
         ResultSet rs=st.executeQuery("select * from products where productId="+ID);
         if(rs.next()){
       if((rs.getInt("productQty"))>(buy.getBuyQty())){
       Integer newProductQty=(rs.getInt("productQty")-buy.getBuyQty());
       try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, newProductQty);
                ps.setInt(2, ID);
                ps.executeUpdate();
                buy.insertBuy();
                 
            }
        
          message="Uspjesno izvršena prodaja artikla :";
          artikl=rs.getString("productName");
          
               } 
         else{
             message="Nemate dovoljno na zalihi odabranog artikla";
         }
        
         }
      
         }
        catch (SQLException e) {
           message=e.getSQLState();
            
        }
       model.put("poruka", message);
       model.put("brojKupovine", buy.getBuyNumber());
       model.put("artikl", artikl);
        NewBuyForm((Model) model);
       return "new_buy";
    }
   
}
