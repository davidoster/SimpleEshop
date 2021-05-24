/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.UserDao;
import models.User;

/**
 *
 * @author tsepe
 */
public class UserService {
    // validateLogin
    // getByUnPas
    UserDao userDao = new UserDao();
    public boolean validateLogin(String userName, String pass){
        
        if(userDao.dbValidateLogin(userName,pass) != null){
            return (true);
        }
        return (false);
    } 
    
    public User getByUnUp(String userName, String pass){
        User user = userDao.dbValidateLogin(userName,pass);
        
        return (user);
    } 
}
