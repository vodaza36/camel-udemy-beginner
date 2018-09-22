package at.hochbichler.eip;

import org.apache.camel.builder.RouteBuilder;

public class RecipientListRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/xmlinput?noop=true")
                .setHeader("type", xpath("/employee/@type"))
                .process(new RecipientEIPProcessor())
                .recipientList(header("type"));
    }
}
