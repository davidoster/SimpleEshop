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
public class SaleDao extends GenericDao{

//    String host = "ra1.anystream.eu";
//    String hostPort = "3012";
//    String username = "simpleeshop";
//    String password = "simpleeshop";
//    String database = "simpleeshop";
//    String dbOption = "useSSL=false&serverTimezone=Europe/Athens";
//    DBConnectionOptions dbOptions = new DBConnectionOptions(host, hostPort, username, password, database, dbOption);
//    Connection conn;
    User user;
    private String insertSales = "insert into sales (customers_id,products_id) values (?,?);";

    public void insertSales(int customer_id, int product_id) {
        
         this.connect();
            boolean bReturnValue = this.executePS(this.insertSales, new Object[] {(Object)customer_id,(Object)product_id});
            
            
            if (bReturnValue) {
                System.out.println("APOTHIKEYTIKE  iii oooooOOOOOOOOOOOOOO OOOOOoooooooooooo");
            }
            this.disconnect();
        
//        String url = "jdbc:mysql://" + dbOptions.getHost() + ":"
//                + dbOptions.getHostPort() + "/"
//                + dbOptions.getDatabase() + "?"
//                + dbOptions.getDbOptions(); // useSSL=false&serverTimezone=Europe/Athens

//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(url, dbOptions.getUsername(), dbOptions.getPassword());
//            String preStatement = insertSales;
            
//            PreparedStatement ps = conn.prepareStatement(preStatement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ps.setInt(1, customer_id);
//            ps.setInt(2, product_id);
//            boolean bReturnValue = ps.execute();
            
//            if (bReturnValue) {
//                System.out.println("APOTHIKEYTIKE  iii oooooOOOOOOOOOOOOOO OOOOOoooooooooooo");
//            }
           
            
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println("Error: " + e.getLocalizedMessage());
//            System.out.println("Oooops");
//        }
       
    }
    
}
