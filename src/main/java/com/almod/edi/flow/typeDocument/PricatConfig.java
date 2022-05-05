package com.almod.edi.flow.typeDocument;

import com.almod.edi.flow.EdiFlow;
import com.almod.edi.flow.typeDocument.payload.ValueProviderKenimForPricatConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PricatConfig {
    public List<EdiFlow> flows = new ArrayList<>();

    public ValueProviderKenimForPricatConfig valueProviderKenimForPricatConfig;

    public PricatConfig(@Autowired ValueProviderKenimForPricatConfig valueProviderKenimForPricatConfig) {
        this.valueProviderKenimForPricatConfig = valueProviderKenimForPricatConfig;

        EdiFlow flow = new EdiFlow();
        flow.providerName = valueProviderKenimForPricatConfig.getKenimProviderName();
        flow.incomingQueue = valueProviderKenimForPricatConfig.getKenimIncomingQueue();
        flow.providerInConsumerCount = valueProviderKenimForPricatConfig.getKenimInConsumerCount();
        flow.routeId = valueProviderKenimForPricatConfig.getKenimRouteId();

        flows.add(flow);
    }


}
