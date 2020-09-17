package com.mohitsharma.generaterecipt.service.impl;

import com.mohitsharma.generaterecipt.entity.ReciptCreationRequest;
import com.mohitsharma.generaterecipt.service.ReciptProcessor;
import com.mohitsharma.generaterecipt.service.ReciptService;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class GenerateReceiptService implements ReciptService {

    private FuelReceiptProcessor fuelReceiptProcessor;

    public GenerateReceiptService(final FuelReceiptProcessor fuelReceiptProcessor) {
        this.fuelReceiptProcessor = fuelReceiptProcessor;
    }

    @Override
    public void process(final ReciptCreationRequest reciptCreationRequest) throws IOException, TemplateException {
        ReciptProcessor reciptProcessor;
        switch (reciptCreationRequest.getReciptType()) {
            case FUEL:
                reciptProcessor = fuelReceiptProcessor;
                break;
            default:
                throw new IllegalStateException("Unexpected receipt type : " + reciptCreationRequest.getReciptType());
        }
        reciptProcessor.process(reciptCreationRequest);
    }

}
