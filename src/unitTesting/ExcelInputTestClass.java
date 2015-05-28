package unitTesting;

import com.exemple.com.entities.Client;
import com.exemple.com.entities.Product;
import com.exemple.com.exceptions.LowerThanCurrentBidValuexException;
import com.exemple.com.exceptions.LowerThanMinBidValueException;
import com.exemple.com.patterns.chainOfResponsability.ClassifyingHandler;
import com.exemple.com.patterns.chainOfResponsability.JewelleryClass;
import com.exemple.com.patterns.chainOfResponsability.OthersClass;
import com.exemple.com.patterns.chainOfResponsability.PaintingsClass;
import com.exemple.com.patterns.factory.ExcelFactory;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
@RunWith(JUnitParamsRunner.class)
public class ExcelInputTestClass {

    static ExcelFactory factory;
    static String filePath;
    static ArrayList<Product> products;
    static ClassifyingHandler jewelleryHandler;
    static ClassifyingHandler paintingsHandler;
    static ClassifyingHandler othersHandler;
    static Client client;


    @BeforeClass
    public static void setUp(){
        factory =  new ExcelFactory();
        filePath = "D:\\CTS\\Auction\\Products.xls";
        factory.create(filePath);
        products = factory.parseFile();
        jewelleryHandler =  new JewelleryClass();
        paintingsHandler = new PaintingsClass();
        othersHandler = new OthersClass();
        jewelleryHandler.setSuccessor(paintingsHandler);
        paintingsHandler.setSuccessor(othersHandler);
        client = new Client("Agnes");
    }

    @Test
    public void testClassifyMethod(){

        for(Product p :  products){
            jewelleryHandler.classifyProduct(p);

            if(p.getCategory().equals("Jewellery"))
                assertTrue(p.getMinBidValue() == 2000);

            if(p.getCategory().equals("Paintings"))
                assertTrue(p.getMinBidValue() == 3000);


            if(p.getCategory().equals("Others"))
                assertTrue(p.getMinBidValue() == 500);
        }

        //System.out.println("DIn metodaaa!!");
        //URL url = getClass().getResource("Products.xls");
        //File file = new File(url.getPath());
        //System.out.println("-------->>>>"+url.getPath());
    }

    @Test
    @FileParameters("src/com/exemple/com/externalFiles/Bids.csv")
    public void testBidsFromFile(String productCategory, double bidValue, boolean result){
        for(Product product :  products) {
            if (product.getCategory().equals(productCategory) && productCategory.equals("Jewellery")){
                try {
                    client.bidProduct(product, 1000);
                    fail("Bid for Jewellery takes lower values then current Bid or minimum Bid (2000)");
                } catch (LowerThanMinBidValueException e) {
                    e.printStackTrace();
                } catch (LowerThanCurrentBidValuexException e) {
                    e.printStackTrace();
                }
            }

            if (product.getCategory().equals(productCategory) && productCategory.equals("Paintings")){
                try {
                    client.bidProduct(product, 2800);
                    fail("Bid for Paintings takes lower values then current Bid or minimum Bid (3000)");
                } catch (LowerThanMinBidValueException e) {
                    e.printStackTrace();
                } catch (LowerThanCurrentBidValuexException e) {
                    e.printStackTrace();
                }
            }

            if (product.getCategory().equals(productCategory) && productCategory.equals("Others")){
                try {
                    client.bidProduct(product, 200);
                    fail("Bid for Others takes lower values then current Bid or minimum Bid (500)");
                } catch (LowerThanMinBidValueException e) {
                    e.printStackTrace();
                } catch (LowerThanCurrentBidValuexException e) {
                    e.printStackTrace();
                }
            }

        }
    }



}
