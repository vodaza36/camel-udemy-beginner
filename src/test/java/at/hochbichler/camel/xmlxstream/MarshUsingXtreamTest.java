package at.hochbichler.camel.xmlxstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarshUsingXtreamTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshUsingXtream();
    }

    @Test
    public void testXstream() throws InterruptedException {
        String expected = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>Thomas</name><joinDate>2006</joinDate></employee>";
        String input = "123,Thomas,2006";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expected);

        template.sendBody("direct:csvInput", input);

        assertMockEndpointsSatisfied();
    }
}