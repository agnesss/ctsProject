package com.exemple.com.patterns.chainOfResponsability;

import com.exemple.com.entities.Product;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public class PaintingsClass extends ClassifyingHandler {

    @Override
    public void classifyProduct(Product product) {
        if(product.getCategory()!= null && product.getCategory().equals("Paintings"))
        {
            product.setMinBidValue(3000);
            System.out.println("Product has been classified as 'Painting'");
        }

        else{
            if(this.getSuccessor()!=null)
                this.getSuccessor().classifyProduct(product);
        }
    }
}
