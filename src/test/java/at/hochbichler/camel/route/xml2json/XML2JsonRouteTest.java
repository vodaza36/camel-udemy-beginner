package at.hochbichler.camel.route.xml2json;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class XML2JsonRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new XML2JsonRoute();
    }

    @Test
    public void testMarshalXml2Json() {
        String expected = "{\"id\":\"123\",\"name\":\"Thomas\",\"joinDate\":\"2006\"}";
        String input = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>Thomas</name><joinDate>2006</joinDate></employee>";
        String response = template.requestBody("direct:marshalEmployeeXml2Json", input, String.class);

        assertEquals(expected, response);
    }

    @Test
    public void testUnMarshalXml2Json() {
        String input = "{\"id\":\"123\",\"name\":\"Thomas\",\"joinDate\":\"2006\"}";
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<employee><id>123</id><joinDate>2006</joinDate><name>Thomas</name></employee>\r\n";
        String response = template.requestBody("direct:marshalEmployeejson2Xml", input, String.class);

        assertEquals(expected, response);
    }
}