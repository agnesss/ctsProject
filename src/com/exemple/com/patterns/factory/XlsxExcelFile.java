package com.exemple.com.patterns.factory;

import com.exemple.com.entities.Product;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public class XlsxExcelFile extends  ExcelFile {


    public XlsxExcelFile(String filePath){
        this.filePath = filePath;
    }

    @Override
    public ArrayList<Product> parse() {

        System.out.println("File has type xlsx");

        try {

            File file = new File(this.filePath);
            FileInputStream fins = new FileInputStream(file);
            //System.out.print(file.getName()); //--> primeste corect numele

            //Get the workbook instance for XLS file
            XSSFWorkbook workbook = new XSSFWorkbook(fins);
            XSSFCell cell;
            XSSFRow row;

            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rows = sheet.getPhysicalNumberOfRows();

            ArrayList<Product> products = new ArrayList<Product>();

            for (int i=1; i< rows; i++){ //fara capul de tabel(prima linie)

                row  = sheet.getRow(i);
                int cols = row.getPhysicalNumberOfCells(); //obtin nr de celule pt fiecare linie
                for(int j=0; j<cols; j++){
                    cell = row.getCell(j);
                    if(cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                        System.out.print(cell.getStringCellValue() + " ");

                    }
                    if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC){
                        System.out.print(cell.getNumericCellValue()+" ");

                    }
                    if(cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
                        System.out.print(cell.getBooleanCellValue()+" ");
                    }
                }
                System.out.println("\n");
            }
            return products;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
