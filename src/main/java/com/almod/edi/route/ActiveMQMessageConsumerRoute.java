package com.almod.edi.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessageConsumerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:inbound.queue")
                .log("Received a message - ${body}");
    }
}
