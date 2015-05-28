package unitTesting;

import com.exemple.com.entities.Client;
import com.exemple.com.entities.Product;
import com.exemple.com.exceptions.LowerThanCurrentBidValuexException;
import com.exemple.com.exceptions.LowerThanMinBidValueException;
import com.exemple.com.patterns.chainOfResponsability.JewelleryClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */

@RunWith(MockitoJUnitRunner.class)
public class MockTestingClass {


    @Mock
    Product product;

    Client client;
    JewelleryClass handler;
    double newBidPositive, newBidNegative;


    @Before
    public void prepareDependencies() {
        MockitoAnnotations.initMocks(this);
        //product = new Product();
        client =  new Client("Agnes");
        newBidPositive = 200;
        newBidNegative = -40;
    }


    @Test
    public void testPositiveBidRequired1() {
        try {
            client.bidProduct(product, newBidPositive);
            verify(product).setCurrentBidValue(newBidPositive);
        } catch (LowerThanMinBidValueException e) {
            e.printStackTrace();
        } catch (LowerThanCurrentBidValuexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPositiveBidRequired2(){
        try {
            client.bidProduct(product, newBidNegative);
            verify(product).setCurrentBidValue(newBidNegative);
        } catch (LowerThanMinBidValueException e) {
            e.printStackTrace();
        } catch (LowerThanCurrentBidValuexException e) {
            e.printStackTrace();
        }
    }
}
