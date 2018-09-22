package at.hochbichler.eip;

import org.apache.camel.builder.RouteBuilder;

public class WireTapRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/xmlinput?noop=true")
                .wireTap("file:output/debug")
                .to("file:output/xml");
    }
}
