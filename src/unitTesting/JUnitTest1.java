package unitTesting;

import com.exemple.com.entities.Product;
import com.exemple.com.patterns.chainOfResponsability.ClassifyingHandler;
import com.exemple.com.patterns.chainOfResponsability.JewelleryClass;
import com.exemple.com.patterns.chainOfResponsability.OthersClass;
import com.exemple.com.patterns.chainOfResponsability.PaintingsClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public class JUnitTest1 {


    private Product product;
    ClassifyingHandler jewelleryHandler;
    ClassifyingHandler paintingsHandler;
    ClassifyingHandler othersHandler;

    @Before
    public void setUp(){
        jewelleryHandler =  new JewelleryClass();
        paintingsHandler =  new PaintingsClass();
        othersHandler =  new OthersClass();
        jewelleryHandler.setSuccessor(paintingsHandler);
        paintingsHandler.setSuccessor(othersHandler);
        product = new Product();
        product.setCategory("Jewellery");
        jewelleryHandler.classifyProduct(product);
    }

    @Test
    public void testClassifying1(){
        Assert.assertNotEquals(0, product.getMinBidValue());
    }


    @Test
    public void testClassifying2(){
        Assert.assertTrue(product.getCategory().equals("Jewellery"));
    }

    @Test
    public void testClassifying3(){
        Assert.assertEquals(0.0, product.getCurrentBidValue(),0);
    }



}
