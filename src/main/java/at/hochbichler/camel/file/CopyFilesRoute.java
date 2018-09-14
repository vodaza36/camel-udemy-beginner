package at.hochbichler.camel.file;

import org.apache.camel.builder.RouteBuilder;

public class CopyFilesRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("file:data/input?noop=true")
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .to("file:data/output");
    }
}
