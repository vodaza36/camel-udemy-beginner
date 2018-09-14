package at.hochbichler.camel.direct;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class SampleDirectRouteTest extends CamelTestSupport {

    public static final String MAX_MUSTER_INSTRUCTOR = "124,Max Muster,Instructor";

    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new SampleDirectRoute();
    }

    @Test
    public void sampleSendData() throws InterruptedException {
        template.sendBody("direct:sampleInput", MAX_MUSTER_INSTRUCTOR);
        Thread.sleep(5000);

        File file = new File("sampleOutput");

        assertTrue(file.isDirectory());
        Exchange exchange = consumer.receive("file:sampleOutput");

        assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));

    }
}