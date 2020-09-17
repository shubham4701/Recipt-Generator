package com.mohitsharma.generaterecipt.api.impl;

import com.mohitsharma.generaterecipt.api.GenerateReciptApi;
import com.mohitsharma.generaterecipt.entity.ReciptCreationRequest;
import com.mohitsharma.generaterecipt.service.ReciptService;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class GenerateReciptController implements GenerateReciptApi {

    private ReciptService reciptService;

    public GenerateReciptController(final ReciptService reciptService) {
        this.reciptService = reciptService;
    }

    @Override
    public void generateReceipts(ReciptCreationRequest reciptCreationRequest) throws IOException, TemplateException {
        log.info("Request recieved : {}", reciptCreationRequest);
        reciptService.process(reciptCreationRequest);
    }
}
