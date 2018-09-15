package at.hochbichler.camel.route.csv;

import at.hochbichler.camel.domain.EmployeeCSV;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;

public class CSVUnmarshalRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        BindyCsvDataFormat bindy = new BindyCsvDataFormat(EmployeeCSV.class);

        from("file:data/csv/input?fileName=file1.txt&noop=true")
                .unmarshal(bindy)
                .log("After: ${body}")
                .to("direct:output");
    }
}
