package com.exemple.com.patterns.chainOfResponsability;

import com.exemple.com.entities.Product;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public class OthersClass extends ClassifyingHandler {


    @Override
    public void classifyProduct(Product product) {
     if(product.getCategory() == null || !product.getCategory().equals("Paintings") && !product.getCategory().equals("Jewellery")) {
         product.setCategory("Others");
         product.setMinBidValue(500);
         System.out.println("Product has been classified as 'Others'");
       }
    }
}
