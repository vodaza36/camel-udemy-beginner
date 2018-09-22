package at.hochbichler.camel.route.onexception;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class OnExceptionHandlerRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new OnExceptionHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void onExceptionTest() {
        String request = null;

        String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response: " + response);
    }
}