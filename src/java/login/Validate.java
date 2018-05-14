/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import data.ConnectionManager;
import java.sql.*;

/**
 *
 * @author Sagar
 */
public class Validate {
    
    public static boolean checkUser(String email,String pass) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("org.postgresql.Driver");

 	 //creating connection with the database 
         //Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/nic","postgres","nic");

         Connection conn=ConnectionManager.getConnection();
         
         PreparedStatement ps =conn.prepareStatement("select * from login where username=? and password=?");
         ps.setString(1, email);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
    
}
