package at.hochbichler.eip;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class AggregatorSimpleRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregatorSimpleRoute();
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(5000);

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived("123");

        template.sendBodyAndHeader("direct:simpleAggregator", "1", "aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator", "2", "aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator", "4", "aggregatorId",2);
        template.sendBodyAndHeader("direct:simpleAggregator", "3", "aggregatorId",1);

        assertMockEndpointsSatisfied();
    }
}