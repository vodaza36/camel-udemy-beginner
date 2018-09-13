package at.hochbichler.camel.process;

import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;

import java.io.File;

public class CamelFileExampleProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Processor: " + exchange.getIn().getBody());

        GenericFile<File> body = (GenericFile<File>) exchange.getIn().getBody();
    }
}
