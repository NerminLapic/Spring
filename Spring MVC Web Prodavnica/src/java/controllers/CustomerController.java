/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.validation.Valid;
import model.Customer;
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nermin
 */
@Controller
public class CustomerController {
    
    @RequestMapping(value = "/new_customer", method=RequestMethod.GET)
    public String NewCustomerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "new_customer";
    }
    
    @RequestMapping(value = "/new_customer", method = RequestMethod.POST)
    
    public  String addCustomer(@ModelAttribute("customer")  @Valid Customer customer,BindingResult result, ModelMap model) throws SQLException, ClassNotFoundException{
    
        if(result.hasErrors()){
            return "/new_customer";
        }
     customer.insertCustomer();
       
        return "new_customer";
    }
    
     @RequestMapping(value = "/lista_kupaca",method = RequestMethod.GET)
    public String readCustomers(ModelMap model) throws SQLException, ClassNotFoundException{

         Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/web_prodavnica", "root", "");
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select * from Customers");
         ArrayList<String[]> kupci=new ArrayList<String[]>();
               while(rs.next()){
               kupci.add(new String[]{rs.getString("customerId"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("email")});
               
               }     
              model.addAttribute("kupci",kupci);
              
        return "kupci";
    }  
    
    
     @RequestMapping(value = "/brisiKupca/{param}")
        public String deleteCustomer(@PathVariable (value = "param") String proizvod, ModelMap model) throws SQLException, ClassNotFoundException {
        
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/web_prodavnica", "root", "");
         Statement st=conn.createStatement();
         st.executeUpdate("delete  from Customers where customerId ="+proizvod);
         readCustomers(model);
        return "/kupci";
    }
        
         @RequestMapping(value = "/izmjeniKupca/{param}" )
    public String EditCustomerForm(@PathVariable(value = "param") Integer customerId, ModelMap model) throws SQLException{
       Customer cust=new Customer();
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/web_prodavnica", "root", "");
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select *  from Customers where customerId ="+customerId);
        if(rs.next()){
            
            cust.setCustomerId(rs.getInt("customerId"));
            cust.setFirstName(rs.getString("firstName"));
            cust.setLastName(rs.getString("lastName"));
            cust.setEmail(rs.getString("email"));
         }
        model.addAttribute("customer", cust);
        
        return "edit_customer";
    }
    
     @RequestMapping(value = "izmjeniKupca/edit_customer", method = RequestMethod.POST)
    
    public  String editCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result, ModelMap model) throws SQLException, ClassNotFoundException{
    
        if(result.hasErrors()){
            return "edit_customer";
        }
        customer.editCustomer();
        readCustomers(model);

        return "kupci";
    }      
}
