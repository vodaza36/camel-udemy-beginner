package at.hochbichler.camel.route.xmlxstream;

import at.hochbichler.camel.processor.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import java.util.HashMap;

public class UnmarshalUsingXstream extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
        java.util.Map<String, String> aliases = new HashMap<>();
        aliases.put("employee", Employee.class.getName());
        xStreamDataFormat.setAliases(aliases);
        xStreamDataFormat.setPermissions(Employee.class.getName());

        from("direct:xmlInput")
                .unmarshal(xStreamDataFormat)
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }
}
