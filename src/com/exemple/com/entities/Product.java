package com.exemple.com.entities;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public class Product {

    private String name;
    private String category;
    private double minBidValue; //valoare de la care incepe licitarea
    private double currentBidValue;

    public Product(){}

    public Product(String name, double minBidValue) {
        this.name = name;
        this.minBidValue = minBidValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinBidValue() {
        return minBidValue;
    }

    public void setMinBidValue(double minBidValue) {
        this.minBidValue = minBidValue;
    }

    public double getCurrentBidValue() {
        return currentBidValue;
    }

    public void setCurrentBidValue(double currentBidValue) {
        this.currentBidValue = currentBidValue;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return name;
    }
}
