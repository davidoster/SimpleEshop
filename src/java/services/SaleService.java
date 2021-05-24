/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.SaleDao;

/**
 *
 * @author tsepe
 */
public class SaleService {
    SaleDao saleDao = new SaleDao();
    
    public void insertSales(int customer_id, int product_id) {
        saleDao.insertSales(customer_id, product_id);
    }
}
