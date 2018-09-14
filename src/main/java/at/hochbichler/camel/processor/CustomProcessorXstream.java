package at.hochbichler.camel.processor;

import org.apache.camel.Exchange;

import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class CustomProcessorXstream implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String newBody = (String) exchange.getIn().getBody();
        StringTokenizer tokens = new StringTokenizer(newBody, ",");
        Employee employee = new Employee();

        while (tokens.hasMoreElements()) {
            employee.setId((String) tokens.nextElement());
            employee.setName((String) tokens.nextElement());
            employee.setJoinDate((String) tokens.nextElement());
        }

        exchange.getIn().setBody(employee);
    }
}
