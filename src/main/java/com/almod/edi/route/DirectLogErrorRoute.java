package com.almod.edi.route;

import org.apache.camel.ExchangePattern;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.NoErrorHandlerBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DirectLogErrorRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:log-error")
                .setExchangePattern(ExchangePattern.InOnly)
                .errorHandler(new NoErrorHandlerBuilder())
                .log(LoggingLevel.WARN, "[batch = ${exchangeProperty.BATCH_ID}] ERROR: ${exception.message} ${exception.stacktrace}")
                .to("activemq:log-error");
    }
}
