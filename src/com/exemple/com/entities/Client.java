package com.exemple.com.entities;

import com.exemple.com.exceptions.LowerThanCurrentBidValuexException;
import com.exemple.com.exceptions.LowerThanMinBidValueException;

import java.util.ArrayList;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public class Client {

    private String name;
    private ArrayList<Product> myProducts;

    public Client(String name){
        this.name = name;
        myProducts = new ArrayList<Product>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getMyProducts() {
        return myProducts;
    }

    public void setMyProducts(ArrayList<Product> myProducts) {
        this.myProducts = myProducts;
    }

    @Override
    public String toString() {
        return name;
    }

    public void bidProduct(Product product, double newBid) throws LowerThanMinBidValueException, LowerThanCurrentBidValuexException {

        if(newBid <= product.getMinBidValue()) throw  new LowerThanMinBidValueException();
        if(newBid <= product.getCurrentBidValue()) throw new LowerThanCurrentBidValuexException();
        else product.setCurrentBidValue(newBid);
    }
}
