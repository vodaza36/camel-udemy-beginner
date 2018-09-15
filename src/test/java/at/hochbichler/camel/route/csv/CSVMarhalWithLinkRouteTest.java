package at.hochbichler.camel.route.csv;
import at.hochbichler.camel.domain.AddressCSV;

import at.hochbichler.camel.domain.EmployeeCSVWithAddress;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class CSVMarhalWithLinkRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVMarhalWithLinkRoute();
    }

    @Test
    public void test() {
        EmployeeCSVWithAddress emp = new EmployeeCSVWithAddress();
        AddressCSV address = new AddressCSV();
        address.setAddressLine("Musterstr. 9");
        address.setCity("Wien");
        address.setState("Wien");
        address.setZip("1010");
        address.setCountry("Aut");

        emp.setAddressCSV(address);
        emp.setId("1");
        emp.setFirstName("Tom");
        emp.setLastName("Hochbichler");

        template.sendBody("direct:objectInput", emp);
    }
}