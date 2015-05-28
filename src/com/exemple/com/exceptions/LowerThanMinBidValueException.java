package com.exemple.com.exceptions;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public class LowerThanMinBidValueException extends  Exception {

    public LowerThanMinBidValueException(){
        super("Bid value MUST be higher than minimum bid value");
    }
}
