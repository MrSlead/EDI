package com.almod.edi.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessageProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        //generates an event/constant message every 10 seconds
        from("timer:active-mq-timer?period=600000")
                .transform().constant("Hello Message from Apache Camel")
                //send this message to ActiveMQ queue
                .to("activemq:inbound.queue");
    }
}