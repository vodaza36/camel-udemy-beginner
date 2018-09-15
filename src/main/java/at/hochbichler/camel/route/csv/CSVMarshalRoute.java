package at.hochbichler.camel.route.csv;

import at.hochbichler.camel.domain.EmployeeCSV;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;

public class CSVMarshalRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        BindyCsvDataFormat bindyCsvDataFormat = new BindyCsvDataFormat(EmployeeCSV.class);

        from("direct:objectInput")
                .log("Receive: ${body}")
                .marshal(bindyCsvDataFormat)
                .log("After: ${body}")
                .to("file:data/csv/output?fileName=output.txt");
    }
}
