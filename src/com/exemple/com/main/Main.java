package com.exemple.com.main;

import com.exemple.com.entities.Client;
import com.exemple.com.entities.Product;
import com.exemple.com.patterns.builder.Auction;
import com.exemple.com.patterns.builder.AuctionBuilder;
import com.exemple.com.patterns.chainOfResponsability.ClassifyingHandler;
import com.exemple.com.patterns.chainOfResponsability.JewelleryClass;
import com.exemple.com.patterns.chainOfResponsability.OthersClass;
import com.exemple.com.patterns.chainOfResponsability.PaintingsClass;
import com.exemple.com.patterns.factory.ExcelFactory;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public class Main {

    public static void main(String[] args){

        //FACTORY PATTERN
        String path = "D:\\CTS\\Auction\\Products.xls";
        ExcelFactory factory = new ExcelFactory();

        factory.create(path);
        ArrayList<Product> products = factory.parseFile();

        if(products!=null && products.size() > 0){
            System.out.println("Lista nu este vida");
            for(Product p : products)
                System.out.println(p.getName()+"->>"+p.getCategory());
        }


        System.out.println("\n\n");

        //BUILDER PATTERN;


        Client client =  new Client("Taylor Switf");
        Product product1 = new Product();
        product1.setName("Golden Earings");
        product1.setCategory("Jewellery");

        Auction auction = new AuctionBuilder()
                                .setId(100)
                                  .setDate(new Main().formatDateFromString("26-05-2015"))
                                   .setProduct(product1)
                                     .setClient(client)
                                       .build();

        System.out.println(auction);
        System.out.println("\n");



        //CHAIN OF RESPONSABILITY PATTERN
        ClassifyingHandler jewelleryHandler = new JewelleryClass();
        ClassifyingHandler paitingsHandler = new PaintingsClass();
        ClassifyingHandler othersHandler = new OthersClass();

        jewelleryHandler.setSuccessor(paitingsHandler);
        paitingsHandler.setSuccessor(othersHandler);

        Product product2 = new Product();
        product2.setName("Spring Painting");
        product2.setCategory("Paintings");

        Product product3 = new Product();
        product3.setName("Golden Pen");


        jewelleryHandler.classifyProduct(product3);
        jewelleryHandler.classifyProduct(product1);
        jewelleryHandler.classifyProduct(product2);






    }

    public Date formatDateFromString(String dateStr){
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = df.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
