package at.hochbichler.camel.direct;

import org.apache.camel.builder.RouteBuilder;

public class SampleMockRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("direct:sampleInput")
                .log("Receive some message ${body} with headers ${headers}")
                .to("mock:output");
    }
}
