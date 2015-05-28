package com.exemple.com.patterns.factory;

import com.exemple.com.entities.Product;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public abstract class ExcelFile {
    protected String filePath;
    public abstract ArrayList<Product> parse();
}
