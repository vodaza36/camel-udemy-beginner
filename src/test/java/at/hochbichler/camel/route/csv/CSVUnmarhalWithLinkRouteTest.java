package at.hochbichler.camel.route.csv;

import at.hochbichler.camel.domain.EmployeeCSVWithAddress;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class CSVUnmarhalWithLinkRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVUnmarhalWithLinkRoute();
    }

    @Test
    public void unmarshal() throws InterruptedException {
        Exchange exchange = consumer.receive("direct:output");
        Thread.sleep(5000);

        EmployeeCSVWithAddress emp = (EmployeeCSVWithAddress) exchange.getIn().getBody();

        assertNotNull(emp.getAddressCSV());
    }
}