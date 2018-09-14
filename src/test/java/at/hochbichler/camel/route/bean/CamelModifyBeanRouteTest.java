package at.hochbichler.camel.route.bean;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class CamelModifyBeanRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyBeanRoute();
    }

    @Test
    public void testBeanTransform() throws InterruptedException {
        MockEndpoint mockEndpoint = new MockEndpoint("mock:output");
        String expected = "123*Thomas";
        String input = "123,Thomas";
        mockEndpoint.expectedBodiesReceived(expected);
        template.sendBody("direct:beanTransform", input);
        assertMockEndpointsSatisfied();
    }
}