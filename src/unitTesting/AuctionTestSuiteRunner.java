package unitTesting;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Agnes.Bolovan on 5/26/2015.
 */
public class AuctionTestSuiteRunner {

    public static void main(String[] args) {
        Result res = JUnitCore.runClasses(AuctionTestSuite.class);
        for (Failure f: res.getFailures()) {
            System.out.println(f);
        }
        System.out.println("Tests were successful?? --> "+res.wasSuccessful());
        System.out.println("No. of tests run: "+res.getRunCount());
        System.out.println("No. of failures: "+res.getFailureCount());

    }
}
