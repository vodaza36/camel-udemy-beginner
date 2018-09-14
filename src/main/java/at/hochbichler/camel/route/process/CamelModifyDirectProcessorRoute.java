package at.hochbichler.camel.route.process;

import at.hochbichler.camel.processor.CamelDirectExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyDirectProcessorRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("direct:processInput")
                .process(new CamelDirectExampleProcessor())
                .log("Receive message ${body}")
                .to("file:data/output?fileName=output.txt")
                .to(("mock:output"));
    }
}
