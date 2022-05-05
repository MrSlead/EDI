package com.almod.edi.flow;

import com.almod.edi.flow.typeDocument.PricatConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EdiFlowConfig {
    public static List<EdiFlow> flows;

    public PricatConfig pricatConfig;

    public EdiFlowConfig(@Autowired PricatConfig pricatConfig) {
        this.pricatConfig = pricatConfig;

        flows = new ArrayList<>();

        flows.addAll(pricatConfig.flows);
    }
}
