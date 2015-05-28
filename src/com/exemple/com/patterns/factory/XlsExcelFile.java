package com.exemple.com.patterns.factory;

import com.exemple.com.entities.Product;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public class XlsExcelFile extends ExcelFile {


    public XlsExcelFile(String filePath){
        this.filePath = filePath;
    }


    @Override
    public ArrayList<Product> parse() {

        System.out.println("File has type xls");
        try {

            File file = new File(this.filePath);
            FileInputStream fins = new FileInputStream(file);
            //System.out.print(file.getName()); //--> primeste corect numele

            HSSFWorkbook workbook = new HSSFWorkbook(fins);
            HSSFCell cell;
            HSSFRow row;

            HSSFSheet sheet = workbook.getSheetAt(0);
            int rows = sheet.getPhysicalNumberOfRows();
            ArrayList<Product> products = new ArrayList<Product>();

            for (int i=1; i< rows; i++){ //fara capul de tabel(prima linie)
                Product product = new Product();
                row  = sheet.getRow(i);
                int k = 0;//contorizeaza numarul casutei
                int cols = row.getPhysicalNumberOfCells(); //obtin nr de celule pt fiecare linie
                for(int j=0; j<cols; j++){
                    cell = row.getCell(j);
                    if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                        k++;
                        System.out.print(cell.getStringCellValue() + " ");
                        //prima casuta de tipul String este denumirea produsului, iar a doua casuta este categoria
                        if(k==1) product.setName(cell.getStringCellValue());
                        if(k==2) product.setCategory(cell.getStringCellValue());
                    }
                    if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                        System.out.print(cell.getNumericCellValue()+" ");

                    }
                    if(cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
                        System.out.print(cell.getBooleanCellValue()+" ");
                    }
                }
                System.out.println("\n");
                products.add(product);

            }
            return products;

        } catch(Exception e){
            e.printStackTrace();
        }

        return null;

    }
}
