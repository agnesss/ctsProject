package com.exemple.com.exceptions;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public class LowerThanCurrentBidValuexException extends  Exception {

    public LowerThanCurrentBidValuexException(){
        super("New bid CANNOT be lower than the current bid");
    }
}
