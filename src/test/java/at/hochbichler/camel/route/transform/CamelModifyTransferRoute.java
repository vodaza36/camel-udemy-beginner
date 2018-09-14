package at.hochbichler.camel.route.transform;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifyTransferRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:transformInput")
                .transform(body().regexReplaceAll(",", "*"))
                .to("mock:output");
    }
}
