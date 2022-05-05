package com.almod.edi.flow.typeDocument.payload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueProviderKenimForPricatConfig {
    @Value("${kenim.provider.name}")
    private String kenimProviderName;

    @Value("${kenim.incoming.queue}")
    private String kenimIncomingQueue;

    @Value("${kenim.in.consumer.count}")
    private String kenimInConsumerCount;

    @Value("${kenim.route.id}")
    private String kenimRouteId;

    public String getKenimProviderName() {
        return kenimProviderName;
    }

    public String getKenimIncomingQueue() {
        return kenimIncomingQueue;
    }

    public String getKenimInConsumerCount() {
        return kenimInConsumerCount;
    }

    public String getKenimRouteId() {
        return kenimRouteId;
    }
}
