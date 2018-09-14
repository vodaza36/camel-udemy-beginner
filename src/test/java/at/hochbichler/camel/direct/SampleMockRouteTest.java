package at.hochbichler.camel.direct;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SampleMockRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new SampleDirectRoute();
    }

    @Test
    public void sampleRouteMock() throws InterruptedException {
        String input = "Hello";

        MockEndpoint endpoint = new MockEndpoint("mock:output");
        endpoint.expectedBodiesReceived(input);

        template.sendBody("direct:sampleInput", "Hello");
        assertMockEndpointsSatisfied();
    }
}