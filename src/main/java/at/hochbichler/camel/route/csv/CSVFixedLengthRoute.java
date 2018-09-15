package at.hochbichler.camel.route.csv;

import at.hochbichler.camel.domain.EmployeeFixedLength;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;

public class CSVFixedLengthRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        BindyFixedLengthDataFormat dataFormat = new BindyFixedLengthDataFormat(EmployeeFixedLength.class);

        from("file:data/fixedlength?fileName=fixedlength.txt&noop=true")
                .unmarshal(dataFormat)
                .log("After: ${body}")
                .to("direct:output");
    }
}
