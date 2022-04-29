package com.almod.edi.provider;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KimerProviderRoute extends RouteBuilder {
    @Value("${kenim.incoming.queue}")
    public String kenimOutgoingAlmod;

    @Override
    public void configure() throws Exception {
        from("timer:active-mq-timer?period=10000")
                .transform().constant("Hello Message from Kenim")
                //send this message to ActiveMQ queue
                .to("activemq:kenim.outgoing.almod");
    }
}
