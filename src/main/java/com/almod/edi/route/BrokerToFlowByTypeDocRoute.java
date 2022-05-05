package com.almod.edi.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Роут для приёма всех входящих документов от провайдеров и отправка в соответствующую очередь в зависимости от типа документа.
 */
@Component
public class BrokerToFlowByTypeDocRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:doc.incoming")
                .routeId("local-broker-to-flow-by-type-doc")
                .log("[batch = ${exchangeProperty.BATCH_ID}] Receive document from doc.incoming")
                .choice()
                    .when(simple("${header.TYPE_DOC} == 'pricat'"))
                            .log("[batch = ${exchangeProperty.BATCH_ID}] Sending document in the pricat.incoming")
                            .to("activemq:pricat.incoming")
                .endChoice()
                    .otherwise()
                        .log(LoggingLevel.WARN, "[batch = ${exchangeProperty.BATCH_ID}] Unknown document type, sending document in the unknown.doc")
                        .to("activemq:unknown.doc")
                .end();
    }
}
