package at.hochbichler.camel.route.defaulterrorhandler;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class DefaultErrorHandlerRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new DefaultErrorHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void exceptionCheck() throws InterruptedException {
        String expectedOutput = "123*Tom*1976";
        String input = null;

        String body = template.requestBody("direct:exception", input, String.class);
    }
}