package com.almod.edi.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class BrokerToFlowByTypeDocRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        /*from("activemq:doc.incoming")
                .routeId("local-broker-to-flow-by-type-doc")
                .choice()
                .when()*/
    }
}
