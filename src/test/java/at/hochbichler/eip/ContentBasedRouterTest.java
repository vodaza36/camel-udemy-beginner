package at.hochbichler.eip;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ContentBasedRouterTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new ContentBasedRouter();
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(5000);

        File file1 = new File("output/html");
        assertTrue(file1.isDirectory());

        File file2 = new File("output/txt");
        assertTrue(file2.isDirectory());

        File file3 = new File("output/json");
        assertTrue(file3.isDirectory());
    }
}