package at.hochbichler.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CamelFileExampleProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws IOException {
        System.out.println("Processor: " + exchange.getIn().getBody());

        GenericFile<File> body = (GenericFile<File>) exchange.getIn().getBody();
        String transformFile = transformFile(body.getFile());
        exchange.getIn().setBody(transformFile);
    }

    private String transformFile(File file) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(file.toURI()));
        return lines.map(l -> l.replace(',', ';')).reduce("", String::concat);
    }
}
