package at.hochbichler.camel.route;

import at.hochbichler.camel.route.process.CamelModifyFileProcessorRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyFileProcessorRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new CamelModifyFileProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {
        String expected = "Hello;Thomas;Hochbichler;1234";
        MockEndpoint mockEndpoint = new MockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expected);

        Thread.sleep(5000);

        assertMockEndpointsSatisfied();
    }
}