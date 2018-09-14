package at.hochbichler.camel.xmlxstream;

import at.hochbichler.camel.processor.CustomProcessorXstream;
import at.hochbichler.camel.processor.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import java.util.HashMap;

public class MarshUsingXtream extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:csvInput")
                .process(new CustomProcessorXstream())
                // .marshal().xstream()
                .marshal(populateSreamDef())
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }

    private XStreamDataFormat populateSreamDef() {
        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
        java.util.Map<String, String> aliases = new HashMap<String, String>();
        aliases.put("employee", Employee.class.getName());
        xStreamDataFormat.setAliases(aliases);
        return xStreamDataFormat;
    }
}
