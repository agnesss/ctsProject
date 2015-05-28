package com.exemple.com.patterns.builder;

import com.exemple.com.entities.Client;
import com.exemple.com.entities.Product;

import java.util.Date;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public class Auction {
    private int id;
    private Date date;
    private Client client;
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Auction Id: "+id+"\n"
                +"Date: "+date+"\n"
                +"Client: "+client+"\n"
                +"Product: "+product;
    }
}
