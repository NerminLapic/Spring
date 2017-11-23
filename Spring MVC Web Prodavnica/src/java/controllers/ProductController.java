/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.validation.Valid;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
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
;
@Controller
public class ProductController {
    
   @Autowired
   private DataSource dataSource;
   
   @RequestMapping(value = "/", method=RequestMethod.GET)
   public String home(){
       
       return "home";
       
   }
    
    @RequestMapping(value = "/new_product", method=RequestMethod.GET)
    public String NewProductForm(Model model){
        model.addAttribute("product", new Product());
        
   
        return "new_product";
    }
    
    @RequestMapping(value = "/new_product", method = RequestMethod.POST)
    
    public  String addProduct(@ModelAttribute("product")  @Valid Product product,BindingResult result, ModelMap model) throws SQLException, ClassNotFoundException{
    
        if(result.hasErrors()){
            return "/new_product";
        }
     product.insertProduct();
     NewProductForm((Model) model);
        readProducts(model);

        return "new_product";
    }
    
    @RequestMapping(value = "/lista",method = RequestMethod.GET)
    public String readProducts(ModelMap model) throws SQLException, ClassNotFoundException{

         Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/web_prodavnica", "root", "");
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select * from products");
         ArrayList<String[]> proizvodi=new ArrayList<String[]>();
               while(rs.next()){
               proizvodi.add(new String[]{rs.getString("productId"),rs.getString("productName"),rs.getString("productPrice"),rs.getString("productQty")});
               
               }     
              model.put("proizvodi",proizvodi);
              
        return "proizvodi";
    }
    
    @RequestMapping(value = "/detalji/{Id}",method = RequestMethod.GET)
    public String detalji(@PathVariable (value = "Id") String proizvod, ModelMap model) throws SQLException, ClassNotFoundException {
        
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/web_prodavnica", "root", "");
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select * from products where productID="+proizvod);
         if(rs.next()){
         model.addAttribute("proizvod", rs.getString("productDescription"));
         model.addAttribute("productName",rs.getString("productName"));
         }
      
        return "detalji";
    }
    

        @RequestMapping(value = "/brisi/{param}")
        public String deleteProduct(@PathVariable (value = "param") String proizvod, ModelMap model) throws SQLException, ClassNotFoundException {
        
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/web_prodavnica", "root", "");
         Statement st=conn.createStatement();
         st.executeUpdate("delete  from products where productId ="+proizvod);
        readProducts(model);
        return "proizvodi";
    }
        
        
        
      @RequestMapping(value = "/izmjeni/{param}" )
    public String EditProductForm(@PathVariable(value = "param") Integer productId, ModelMap model) throws SQLException{
        Product pr=new Product();
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/web_prodavnica", "root", "");
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select * from products where productID="+productId);
         if(rs.next()){
        pr.setProductId(rs.getInt("productId"));
        pr.setProductName(rs.getString("productName"));
        pr.setProductDescription(rs.getString("productDescription"));
        pr.setProductPrice(rs.getFloat("productPrice"));
        pr.setProductQty(rs.getInt("productQty"));
  
         }
        model.addAttribute("product", pr);
        return "edit_product";
    }
    
    @RequestMapping(value = "izmjeni/edit_product", method = RequestMethod.POST)
    
    public  String editProduct(@ModelAttribute("product") @Valid Product product, BindingResult result, ModelMap model) throws SQLException, ClassNotFoundException{
    
        if(result.hasErrors()){
            return "edit_product";
        }
        System.out.println(product);
        product.editProduct();
        readProducts(model);

        return "proizvodi";
    }      
    
}
