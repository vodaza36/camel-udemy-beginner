package at.hochbichler.camel.route.onexception;

import at.hochbichler.camel.bean.DataModifier;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class OnExceptionHandlerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        onException(RuntimeException.class, Exception.class)
                .maximumRedeliveries(2)
                .redeliveryDelay(2000)
                .process(new GenerateErrorResponseProcessor())
                .log(LoggingLevel.INFO, "Exception in bean caught here!");

        from("direct:exception")
                .bean(new DataModifier(), "mapOnException")
                .to("log:?level=INFO&showBody=true");
    }
}
