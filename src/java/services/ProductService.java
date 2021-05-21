/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ProductDao;
import java.util.List;
import models.Product;

/**
 *
 * @author George.Pasparakis
 */
public class ProductService implements IProductService {

    @Override
    public List<Product> getAllProducts() {
        ProductDao productDao = new ProductDao();
        return(productDao.getAllProducts());
//        return(null);
    }
    
}
