package at.hochbichler.camel.route.csv;

import at.hochbichler.camel.domain.EmployeeCSVWithAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;

public class CSVMarhalWithLinkRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        BindyCsvDataFormat  bindyCsvDataFormat = new BindyCsvDataFormat(EmployeeCSVWithAddress.class);

        from("direct:objectInput")
                .marshal(bindyCsvDataFormat)
                .log("After: ${body}")
                .to("file:data/csv/output?fileName=output-with-address.txt");
    }
}
