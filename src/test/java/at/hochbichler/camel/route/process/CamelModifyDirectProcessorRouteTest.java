package at.hochbichler.camel.route.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyDirectProcessorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new CamelModifyDirectProcessorRoute();
    }

    @Test
    public void processDirectInput() {
        String expected = "123;Thomas";
        String input = "123,Thomas";

        String output = (String) template.requestBody("direct:processInput", input);
        assertEquals(expected, output);
    }

    @Test
    public void processorDirectMock() throws InterruptedException {
        String expected = "123;Thomas";
        String input = "123,Thomas";

        MockEndpoint mockEndpoint = new MockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expected);
        template.sendBody("direct:processInput",input);
        assertMockEndpointsSatisfied();
    }
}