package at.hochbichler.camel.route.csv;

import at.hochbichler.camel.domain.EmployeeCSV;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CSVMarshalRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVMarshalRoute();
    }

    @Test
    public void marshalCsv() {
        EmployeeCSV employee1 = new EmployeeCSV();
        employee1.setId("1");
        employee1.setFirstName("Thomas");
        employee1.setLastName("Hochbichler");

        EmployeeCSV employee2 = new EmployeeCSV();
        employee2.setId("2");
        employee2.setFirstName("Marion");
        employee2.setLastName("Hochbichler");


        template.sendBody("direct:objectInput", Arrays.asList(employee1, employee2));

    }
}