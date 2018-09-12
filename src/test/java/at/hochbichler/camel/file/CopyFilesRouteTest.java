package at.hochbichler.camel.file;

import at.hochbichler.camel.file.CopyFilesRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CopyFilesRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CopyFilesRoute();
    }

    @Test
    public void checkOutput() throws InterruptedException {
        Thread.sleep(5000);
        File file = new File("data/output");
        assertTrue(file.isDirectory());
        assertEquals(2, file.listFiles().length);
    }
}