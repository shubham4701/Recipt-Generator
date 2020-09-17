package com.mohitsharma.generaterecipt.service.impl;

import com.mohitsharma.generaterecipt.config.ValueConfiguration;
import com.mohitsharma.generaterecipt.entity.ReciptCreationRequest;
import com.mohitsharma.generaterecipt.service.ReciptProcessor;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

@Slf4j
public class FuelReceiptProcessor implements ReciptProcessor {

    private ValueConfiguration valueConfiguration;
    private Configuration configuration;

    public FuelReceiptProcessor(final ValueConfiguration valueConfiguration, final Configuration configuration) {
        this.valueConfiguration = valueConfiguration;
        this.configuration = configuration;
    }

    @Override
    public void process(final ReciptCreationRequest reciptCreationRequest) throws IOException, TemplateException {
        Template template = configuration.getTemplate(valueConfiguration.getFuelReciptTemplateName());
        String parsedHtml = this.parseTemplateAndGetAsString(template, reciptCreationRequest.getParameters());
        log.info("HTML Document : {}", parsedHtml);
    }

    private String parseTemplateAndGetAsString(Template template, Map<String, String> model)
            throws IOException, TemplateException {
        StringWriter result = new StringWriter();
        template.process(model, result);
        return result.toString();
    }
}