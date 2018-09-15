package at.hochbichler.camel.route.gson;

import at.hochbichler.camel.processor.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnMarshalUsingGsonTest  extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnMarshalUsingGson();
    }

    @Test
    public void unmarshalGson() {
        String input = "{\"id\":\"123\",\"name\":\"Thomas\",\"joinDate\":\"2006\"} ";

        Employee expected = new Employee();
        expected.setId("123");
        expected.setName("Thomas");
        expected.setJoinDate("2006");

        Employee response = template.requestBody("direct:unmarshalGson", input, Employee.class);

        assertEquals(expected, response);

    }
}