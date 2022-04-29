package com.almod.edi.route;

import com.almod.edi.flow.EdiFlow;
import com.almod.edi.flow.EdiFlowConfig;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Создание общего роута для вычитки с очередей разных провайдеров и отправка в общую очередь для обработки документов, обход дублирования кода.
 * Т.к. провайдеры имитированы на том же брокере, в "from" роута вписывается "activemq". Иначе для каждого брокера было бы своё подключение.
 */

@Component
public class IncomingDocumentsFromProviderRoute extends RouteBuilder {

    public List<EdiFlow> flows = EdiFlowConfig.flows;

    @Override
    public void configure() throws Exception {

        for(EdiFlow ediFlow : flows){
            String fromUrl = String.format("activemq:%s?concurrentConsumers=%s", ediFlow.incomingQueue, ediFlow.providerInCounsumerCount);
            from(fromUrl)
                    .routeId(ediFlow.routeId)
                    .log("Receive document from " + ediFlow.providerName.toUpperCase())
                    .to("activemq:doc.incoming");
        }
    }
}
