package at.hochbichler.eip;

import org.apache.camel.builder.RouteBuilder;

public class AggregatorCompletionTimeoutRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:simpleAggregator")
                .log("Receive message ${body} and header ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new AggregatorSimpleRouteStrategy())
                .completionSize(3).completionTimeout(3000)
                .log("Aggregated message ${body} and header ${header.aggregatorId}")
                .to("mock:output");
    }
}
