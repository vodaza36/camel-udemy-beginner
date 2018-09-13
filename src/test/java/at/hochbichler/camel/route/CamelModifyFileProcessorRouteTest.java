package at.hochbichler.camel.route;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class CamelModifyFileProcessorRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyFileProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {
        Thread.sleep(5000);
    }
}