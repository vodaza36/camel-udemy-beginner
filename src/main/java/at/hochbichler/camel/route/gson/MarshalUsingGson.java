package at.hochbichler.camel.route.gson;

import at.hochbichler.camel.processor.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class MarshalUsingGson extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);

        from("direct:marshalGson")
                .log("Before: ${body}")
                .marshal(gsonDataFormat)
                .log("After: ${body}")
                .to("mock:output");
    }
}
