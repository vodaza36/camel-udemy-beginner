package at.hochbichler.camel.route.gson;

import at.hochbichler.camel.processor.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarshalUsingGsonTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingGson();
    }

    @Test
    public void marshalGson() {
        String expected = "{\"id\":\"123\",\"name\":\"Thomas\",\"joinDate\":\"2006\"}";

        Employee employee = new Employee();
        employee.setId("123");
        employee.setName("Thomas");
        employee.setJoinDate("2006");

        String response = template.requestBody("direct:marshalGson", employee, String.class);

        assertEquals(expected, response);

    }
}