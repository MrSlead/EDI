package com.almod.edi.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessageProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        //generates an event/constant message every 10 seconds
        from("timer:active-mq-timer?period=10000")
                .transform().constant("Hello Message from Apache Camel")
                .log("${body}")
                //send this message to ActiveMQ queue
                .to("activemq:inbound.queue");
    }
}