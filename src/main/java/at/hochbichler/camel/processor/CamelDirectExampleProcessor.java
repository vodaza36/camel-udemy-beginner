package at.hochbichler.camel.processor;

import org.apache.camel.Exchange;

public class CamelDirectExampleProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) {

        String oldValue = (String) exchange.getIn().getBody();
        String newValue = oldValue.replace(",", ";");
        exchange.getIn().setBody(newValue);
    }
}
