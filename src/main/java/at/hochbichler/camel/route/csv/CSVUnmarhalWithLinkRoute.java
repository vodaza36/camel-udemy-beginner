package at.hochbichler.camel.route.csv;

import at.hochbichler.camel.domain.EmployeeCSVWithAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;

public class CSVUnmarhalWithLinkRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        BindyCsvDataFormat bindyCsvDataFormat = new BindyCsvDataFormat(EmployeeCSVWithAddress.class);

        from("file:data/csv/input?fileName=file-with-address.txt&noop=true")
                .unmarshal(bindyCsvDataFormat)
                .log("Unmarshaled: ${body}")
                .to("direct:output");
    }
}
