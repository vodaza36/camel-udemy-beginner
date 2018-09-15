package at.hochbichler.camel.route.bean;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyBeanRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:beanTransform")
                .bean(new CamelBean())
                .to("mock:output");
    }
}
