/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.DBConnectionOptions;
import models.User;

/**
 *
 * @author tsepe
 */
public class UserDao {
    String host      = "ra1.anystream.eu";
    String hostPort  = "3012";
    String username  = "simpleeshop";
    String password  = "simpleeshop";
    String database  = "simpleeshop";
    String dbOption = "useSSL=false&serverTimezone=Europe/Athens";
    DBConnectionOptions dbOptions = new DBConnectionOptions(host, hostPort, username, password, database, dbOption);
    Connection conn;
    User user;
    String validateSql= "select * from customers where fname = ? and lname = ?";

    public UserDao() {
    }
    
    
    
    
    public User dbValidateLogin(String username, String lastname){
        
        String url = "jdbc:mysql://" + dbOptions.getHost() + ":" 
                                     + dbOptions.getHostPort() + "/" 
                                     + dbOptions.getDatabase() + "?"
                                     + dbOptions.getDbOptions(); // useSSL=false&serverTimezone=Europe/Athens
        
        
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbOptions.getUsername(), dbOptions.getPassword());
            String preStatement = validateSql;
            PreparedStatement ps = conn.prepareStatement(preStatement,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, username);
            ps.setString(2, lastname);
            boolean bReturnValue = ps.execute() && ps.getResultSet().next();
            ResultSet rs = ps.getResultSet();
            if(bReturnValue) {
                
                rs.beforeFirst();    //ΑΝ ΧΤΥΠΗΣΕΙ ΤΟ ΠΡΟΓΡΑΜΜΑ ΝΑ ΤΟ ΚΑΝΟΥΜΕ uncomment ΚΑΙ ΝΑ ΞΑΝΑΔΟΚΙΜΑΣΟΥΜΕ
                while(rs.next()) {
                        // id, name, price, description, image
                    user = new User(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), 
                                                  rs.getString("email"));
                   
                }
                 System.out.println(user);
//                Object[] myArray = new Object[rows];
//                return(ps.getResultSet());
                return(user);
            }
        } catch(SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
            System.out.println("Oooops");
        }
        return (null);
    }
        
        
        
}
