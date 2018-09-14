package at.hochbichler.camel.route.process;

import at.hochbichler.camel.processor.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileProcessorRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("file:data/input?noop=true")
                .log("Read file is ${body}")
                .process(new CamelFileExampleProcessor())
                .to("file:data/output?fileName=output.txt")
                .to("mock:output");
    }
}
