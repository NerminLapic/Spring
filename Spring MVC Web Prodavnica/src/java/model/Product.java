package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Entity;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;





/**
 *
 * @author Nermin
 */
@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @NotNull
    @Column (name="productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @NotEmpty
    @Column(name = "productName")
    private String productName;
    @NotNull
    @Column(name = "productPrice")
    private float productPrice;
    @NotEmpty
    @Column(name = "productDescription")
    private String productDescription;
    @NotNull
    @Column(name = "productQty")
    private int productQty;

    Product(int id,String name, int price,String description, int qty){
        this.productId=id;
        this.productName=name;
        this.productPrice=price;
        this.productDescription=description;
        this.productQty=qty;
                
    
    }

    public Product() {
    }
    
public int getProductId(){
    
    return productId;
}

public String getProductName(){
    return productName;
}

public float getProductPrice(){
    return productPrice;
}

public String getProductDescription(){
    return productDescription;
}
public int getProductQty()
{
    return productQty;
}

public void setProductId(int productId){
    this.productId=productId;    
}

public void setProductName(String productName){
    this.productName=productName;
}

public void setProductPrice(float productPrice){
    this.productPrice=productPrice;
}

public void setProductDescription(String productDescriptio){
    this.productDescription=productDescriptio;
}

public void setProductQty(int qty){
    this.productQty=qty;
}
@Autowired

public void insertProduct() throws SQLException, ClassNotFoundException{
    
String sql="INSERT INTO PRODUCTS (productId,productName,productPrice,productDescription,productQty) VALUES(?,?,?,?,?)";
  
 
     Class.forName("com.mysql.jdbc.Driver");
   
        try(java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/web_prodavnica", "root", "")) {
           // Connection conn=dataSource.getConnection();
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, productId);
                ps.setString(2, productName);
                ps.setFloat(3, productPrice);
                ps.setString(4, productDescription);
                ps.setInt(5, productQty);
                ps.executeUpdate();
            }
            
            
        } catch (SQLException e) {
            
    
    
//   Session session =HibernateUtil.getSessionFactory().openSession();
//        Transaction tx=null;
//
//           try {
//            tx=session.beginTransaction();
//            session.save(this);
//            tx.commit();
//        } catch (Exception e) {
//            if(tx!=null){
//                tx.rollback();
//            }
//        }
//           finally{
//               if(session.isOpen()){
//                   session.close();
//               }
//           }
}}
public void editProduct() throws SQLException, ClassNotFoundException{
    
    String sql="UPDATE  PRODUCTS SET productName=?,productPrice=?,productDescription=?,productQty=? WHERE productId=?";
  
 
     Class.forName("com.mysql.jdbc.Driver");
   
        try(java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/web_prodavnica", "root", "")) {
            //Connection conn=dataSource.getConnection();
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                //ps.setInt(1, productId);
                ps.setString(1, productName);
                ps.setFloat(2, productPrice);
                ps.setString(3, productDescription);
                ps.setInt(4,productQty);
                ps.setInt(5, productId);
                ps.executeUpdate();
            }
            
            
        } catch (SQLException e) {
            
        }
}
}
