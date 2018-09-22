package at.hochbichler.camel.route.onexception;

import org.apache.camel.Exchange;

public class GenerateErrorResponseProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        System.out.println("Actual exception message: " + e.getMessage());
        System.out.println("Actual exception class: " + e.getClass());

        String failedEndpoint = (String) exchange.getProperty(Exchange.FAILURE_ENDPOINT);
        System.out.println("Failed endpoint: " + failedEndpoint);

        exchange.getIn().setBody("Exception happened in the route");
    }
}
