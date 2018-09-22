package at.hochbichler.eip;

import org.apache.camel.builder.RouteBuilder;

public class MultiCastRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .multicast()
                .stopOnException()
                .parallelProcessing()
                .to("file:output/output1", "file:output/output2");
    }
}
