package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DBConnectionOptions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tsepe
 */
public class GenericDao {
    protected String host = "ra1.anystream.eu";
    protected String hostPort = "3012";
    protected String username = "simpleeshop";
    protected String password = "simpleeshop";
    protected String database = "simpleeshop";
    protected String dbOption = "useSSL=false&serverTimezone=Europe/Athens";
    protected DBConnectionOptions dbOptions = new DBConnectionOptions(host, hostPort, username, password, database, dbOption);
    protected Connection conn;
    protected PreparedStatement ps;
    protected ResultSet rs;
    protected String url = "jdbc:mysql://" + dbOptions.getHost() + ":"
                + dbOptions.getHostPort() + "/"
                + dbOptions.getDatabase() + "?"
                + dbOptions.getDbOptions(); // useSSL=false&serverTimezone=Europe/Athens
    
    protected void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, dbOptions.getUsername(), dbOptions.getPassword());
        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex.getLocalizedMessage());
            System.out.println("Oooops");
        }
    }
    
    
    protected void disconnect(){
        try {
            this.conn.close();
            this.ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    protected boolean executePS(String query, Object[] data){
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connect();
            this.ps = this.conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            if(data.length>0){
                for (int i = 0; i < data.length; i++) {
                    if(Integer.class.isInstance(data[i])){
                        ps.setInt(i+1,(int)data[i]);
                    }
                    else if(data[i] instanceof String){
                        ps.setString(i+1, (String)data[i]);
                    }
                    else if(Double.class.isInstance(data[i])){
                        ps.setDouble(i+1, (double)data[i]);
                    }
                    else if(data[i] instanceof LocalDate){
                        LocalDate x = (LocalDate) data[i];
                        ps.setDate(i+1, Date.valueOf(x));
                    }
                }
            }
            return (this.ps.execute());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (false);
    }
    
    
    protected ResultSet getRS(){
        try {
            return (this.rs = ps.getResultSet());
        } catch (SQLException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(null);
    }
    
}
