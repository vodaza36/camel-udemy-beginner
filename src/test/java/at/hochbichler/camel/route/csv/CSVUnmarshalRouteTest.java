package at.hochbichler.camel.route.csv;

import at.hochbichler.camel.domain.EmployeeCSV;
import at.hochbichler.camel.processor.Employee;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CSVUnmarshalRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVUnmarshalRoute();
    }

    @Test
    public void unmarshal() throws InterruptedException {
        Exchange exchange = consumer.receive("direct:output");

        Thread.sleep(5000);

        List<EmployeeCSV> employees = (List<EmployeeCSV>) exchange.getIn().getBody();

        assertEquals("Thomas", employees.get(0).getFirstName());
        assertEquals("Marion", employees.get(1).getFirstName());
    }
}