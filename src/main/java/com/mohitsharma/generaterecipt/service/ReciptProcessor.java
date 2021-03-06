package com.mohitsharma.generaterecipt.service;

import com.mohitsharma.generaterecipt.entity.ReciptCreationRequest;
import freemarker.template.TemplateException;

import java.io.IOException;

public interface ReciptProcessor {
    void process(final ReciptCreationRequest reciptCreationRequest) throws IOException, TemplateException;
}
