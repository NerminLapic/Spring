package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nermin
 */

public class Customer {
    @NotNull
    private int customerId;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    @Email
    private String email;

    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
 
@Autowired
DataSource dataSource;
public void insertCustomer() throws SQLException, ClassNotFoundException{
    
    String sql="INSERT INTO CUSTOMERS (customerId,firstName,lastName,email) VALUES(?,?,?,?)";
  
 
     Class.forName("com.mysql.jdbc.Driver");
   
        try(java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/web_prodavnica", "root", "")) {
           // Connection conn=dataSource.getConnection();
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, customerId);
                ps.setString(2, firstName);
                ps.setString(3, lastName);
                ps.setString(4, email);
              
                ps.executeUpdate();
            }
            
            
        } catch (SQLException e) {
            
        }
  
        
    
    
}
public void editCustomer() throws SQLException, ClassNotFoundException{
    
    String sql="UPDATE  CUSTOMERS SET firstName=?,lastName=?,email=? WHERE customerId=?";
  
 
     Class.forName("com.mysql.jdbc.Driver");
   
        try(java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/web_prodavnica", "root", "")) {
            //Connection conn=dataSource.getConnection();
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
               
                ps.setString(1,firstName);
                ps.setString(2, lastName);
                ps.setString(3, email);
                ps.setInt(4, customerId);
                ps.executeUpdate();
            }
            
            
        } catch (SQLException e) {
            
        }
}

    
}
