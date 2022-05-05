package com.almod.edi.provider;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KenimProviderRoute extends RouteBuilder {
    @Value("${kenim.incoming.queue}")
    public String kenimOutgoingAlmod;

    @Override
    public void configure() throws Exception {
        //from("timer:active-mq-timer?period=10000")
        from("file:docFromProvider/kenim?noop=true&charset=utf-8")
                //.transform().constant("Hello Message from Kenim")
                .to("activemq:kenim.outgoing.almod");
    }
}
