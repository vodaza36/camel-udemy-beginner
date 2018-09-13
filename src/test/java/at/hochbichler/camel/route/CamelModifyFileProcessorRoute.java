package at.hochbichler.camel.route;

import at.hochbichler.camel.process.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileProcessorRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .log("Read file is ${body}")
                .process(new CamelFileExampleProcessor())
                .to("file:data/output?fileName=output.txt");
    }
}
