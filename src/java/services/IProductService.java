/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.Product;

/**
 *
 * @author George.Pasparakis
 */
public interface IProductService {
    
    // getProductWithId
    // getAllProducts
    // getProductsWithPrice
    // getAllProductsWithPriceRange
    
    List<Product> getAllProducts();
    
}
