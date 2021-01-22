/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class DBConnection {
    
    // singelton design pattern 
    private static Connection con = null;   

    private final static String url = "jdbc:mysql://localhost:3306/clinic"; 
    private final static String user = "root"; 
    private final static String pass = ""; 
    
   // get_connection method (connect my java app with mysql using  jdbc) 
    public static Connection get_Connection(String url , String user , String pass)
    {         
       if(con == null)
       {
           try { 
               
               Class.forName("com.mysql.jdbc.Driver");
               con = DriverManager.getConnection(url, user, pass); 
               
           } catch (ClassNotFoundException | SQLException ex) {
             
                if(ex instanceof com.mysql.jdbc.exceptions.jdbc4.CommunicationsException)
               {
                    JOptionPane.showMessageDialog(new LoginForm(),"Hello plz try to connect server  !");
          
               }
              
               Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
           }
           

       }
           return con;
       
    }
    
    
      public static Connection get_DefaultConnection(){
      
          return get_Connection(url, user , pass);
               
      }
    
}
