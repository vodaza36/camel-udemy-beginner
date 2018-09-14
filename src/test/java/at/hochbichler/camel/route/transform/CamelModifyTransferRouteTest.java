package at.hochbichler.camel.route.transform;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class CamelModifyTransferRouteTest extends CamelTestSupport {


    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyTransferRoute();
    }

    @Test
    public void transform() throws InterruptedException {

        String expected = "123*Thomas";
        String input = "123,Thomas";
        MockEndpoint mockEndpoint = new MockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expected);

        template.sendBody("direct:transformInput", input);
        assertMockEndpointsSatisfied();
    }
}