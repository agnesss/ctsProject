package com.exemple.com.patterns.factory;

import com.exemple.com.entities.Product;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public class ExcelFactory {

    private ExcelFile file = null;


    public void create(String filePath){

       String fileType = getFileType(filePath);

        if(fileType.equals("xls"))
            this.file = new XlsExcelFile(filePath);

        if(fileType.equals("xlsx"))
            this.file = new XlsxExcelFile(filePath);


    }


    public ArrayList<Product> parseFile(){

        return this.file.parse();
    }


    public String getFileType(String filePath){
        String[] tok = filePath.split("\\.");
        return tok[1];
    }
}
