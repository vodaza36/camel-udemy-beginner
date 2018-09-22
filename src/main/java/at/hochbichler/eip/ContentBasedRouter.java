package at.hochbichler.eip;

import org.apache.camel.builder.RouteBuilder;

public class ContentBasedRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/content?noop=true")
                .choice()
                    .when(header("CamelFileNameConsumed").endsWith(".html"))
                        .to("file:output/html")
                    .when(header("CamelFileNameConsumed").endsWith(".txt"))
                        .to("file:output/txt")
                    .when(header("CamelFileNameConsumed").endsWith(".json"))
                        .to("file:output/json")
                    .otherwise()
                        .to("file:output/other").stop()
                    .end()
                .to("file:output/all");
    }
}
