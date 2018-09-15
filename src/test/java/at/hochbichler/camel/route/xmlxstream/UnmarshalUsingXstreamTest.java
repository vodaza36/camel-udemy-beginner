package at.hochbichler.camel.route.xmlxstream;

import at.hochbichler.camel.processor.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnmarshalUsingXstreamTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnmarshalUsingXstream();
    }

    @Test
    public void test() throws InterruptedException {
        Employee employee = new Employee();
        employee.setId("123");
        employee.setName("Thomas");
        employee.setJoinDate("2006");

        String input = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>Thomas</name><joinDate>2006</joinDate></employee>";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(employee.toString());

        template.sendBody("direct:xmlInput", input);

        assertMockEndpointsSatisfied();
    }
}