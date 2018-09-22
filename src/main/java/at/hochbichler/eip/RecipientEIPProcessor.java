package at.hochbichler.eip;

import org.apache.camel.Exchange;

public class RecipientEIPProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String employeeType = exchange.getIn().getHeader("type", String.class);

        if ("senior".equals(employeeType)) {
            exchange.getIn().setHeader("type", "file:output/xmlsenior");
        } else if ("junior".equals(employeeType)) {
            exchange.getIn().setHeader("type", "file:output/xmljunior");
        }
    }
}
