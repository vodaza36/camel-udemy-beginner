package at.hochbichler.camel.direct;

import org.apache.camel.builder.RouteBuilder;

public class SampleDirectRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Receive message ${body} with headers ${headers}")
                .to("file:sampleOutput?fileName=output.txt");
    }
}
