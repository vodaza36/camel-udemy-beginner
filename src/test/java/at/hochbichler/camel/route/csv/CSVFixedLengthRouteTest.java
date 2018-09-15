package at.hochbichler.camel.route.csv;

import at.hochbichler.camel.domain.EmployeeFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class CSVFixedLengthRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVFixedLengthRoute();
    }

    @Test
    public void test() {
        Exchange exchange = consumer.receive("direct:output");
        List<EmployeeFixedLength> emps = (List<EmployeeFixedLength>) exchange.getIn().getBody();

        assertEquals("Thomas", emps.get(0).getFirstname());
        assertEquals("Julia", emps.get(1).getFirstname());

        LocalDate expectedDate = LocalDate.of(2010,02,21);
        assertEquals(expectedDate.getYear(), emps.get(0).getJoinDate().getYear());
    }
}