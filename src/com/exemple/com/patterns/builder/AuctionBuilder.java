package com.exemple.com.patterns.builder;

import com.exemple.com.entities.Client;
import com.exemple.com.entities.Product;

import java.util.Date;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public class AuctionBuilder {

    private Auction auction;

    public AuctionBuilder(){
        auction = new Auction();
    }

    public AuctionBuilder setId(int id){
        this.auction.setId(id);
        return this;
    }

    public AuctionBuilder setDate(Date date){
        this.auction.setDate(date);
        return this;
    }

    public AuctionBuilder setClient(Client client){
        this.auction.setClient(client);
        return this;
    }

    public AuctionBuilder setProduct(Product product){
        this.auction.setProduct(product);
        return this;
    }

    public Auction build(){
        return this.auction;
    }
}
