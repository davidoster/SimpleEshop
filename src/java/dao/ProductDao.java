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
import java.util.ArrayList;
import java.util.List;
import models.DBConnectionOptions;
import models.Product;

/**
 *
 * @author George.Pasparakis
 */
public class ProductDao extends GenericDao implements IProductDao {

    @Override
    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM products";
//        String host      = "ra1.anystream.eu";
//        String hostPort  = "3012";
//        String username  = "simpleeshop";
//        String password  = "simpleeshop";
//        String database  = "simpleeshop";
//        String dbOption = "useSSL=false&serverTimezone=Europe/Athens";
//        DBConnectionOptions dbOptions = new DBConnectionOptions(host, hostPort, username, password, database, dbOption);
        
        List<Product> products = new ArrayList<>();
        Product product;
        this.connect();
        
        try {
            boolean bReturnValue = this.executePS(sql, new Object[]{}) && ps.getResultSet().next();
            
            if(bReturnValue) {
                this.rs = ps.getResultSet();
                this.rs.last();
                int rows = rs.getRow();
                System.out.println("Rows: " + rows);
                System.out.println(rs.getString(1));
                this.rs.beforeFirst();
                while(rs.next()) {
                        // id, name, price, description, image
                    product = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), 
                                                  rs.getString("description"), rs.getString("image"));
                   
                    products.add(product);
                }
                System.out.println(products);
                this.disconnect();
                rs.close();
//                return(products);
            }
            
        } catch(SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
            System.out.println("Oooops");
        }
        
//        return(dbGetAllProducts(dbOptions, sql));
        return(products);
    }
    
//    private List<Product> dbGetAllProducts(DBConnectionOptions dbOptions, String sql) {
//        Connection conn;
//        String url = "jdbc:mysql://" + dbOptions.getHost() + ":" 
//                                     + dbOptions.getHostPort() + "/" 
//                                     + dbOptions.getDatabase() + "?"
//                                     + dbOptions.getDbOptions(); // useSSL=false&serverTimezone=Europe/Athens
//        System.out.println(url);
//        List<Product> products = new ArrayList<>();
//        Product product;
//        
//        
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(url, dbOptions.getUsername(), dbOptions.getPassword());
//            String preStatement = sql; // "SELECT username, password FROM users WHERE username = ? AND password = ?";
//            PreparedStatement ps = conn.prepareStatement(preStatement,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            boolean bReturnValue = ps.execute() && ps.getResultSet().next();
//            ResultSet rs = ps.getResultSet();
//            if(bReturnValue) {
//                rs.last();
//                int rows = rs.getRow();
//                System.out.println("Rows: " + rows);
//                System.out.println(rs.getString(1));
//                rs.beforeFirst();
//                while(rs.next()) {
//                        // id, name, price, description, image
//                    product = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), 
//                                                  rs.getString("description"), rs.getString("image"));
//                   
//                    products.add(product);
//                }
//                 System.out.println(products);
//                Object[] myArray = new Object[rows];
//                return(ps.getResultSet());
//                return(products);
//            }
//        } catch(SQLException | ClassNotFoundException e) {
//            System.out.println("Error: " + e.getLocalizedMessage());
//            System.out.println("Oooops");
//        }
//        return(products);
//    }
    
}
