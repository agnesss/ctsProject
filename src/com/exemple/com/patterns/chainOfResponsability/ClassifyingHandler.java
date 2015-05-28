package com.exemple.com.patterns.chainOfResponsability;

import com.exemple.com.entities.Product;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public abstract class ClassifyingHandler {

    private ClassifyingHandler successor;

    public ClassifyingHandler getSuccessor() {
        return successor;
    }

    public void setSuccessor(ClassifyingHandler successor) {
        this.successor = successor;
    }

    public abstract void classifyProduct(Product product);
}
