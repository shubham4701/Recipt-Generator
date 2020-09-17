package com.mohitsharma.generaterecipt.config;

import com.mohitsharma.generaterecipt.api.impl.GenerateReciptController;
import com.mohitsharma.generaterecipt.service.ReciptService;
import com.mohitsharma.generaterecipt.service.impl.FuelReceiptProcessor;
import com.mohitsharma.generaterecipt.service.impl.GenerateReceiptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
@Slf4j
public class BeanConfiguration {

    @Bean
    public ReciptService generateReciptService() throws IOException {
        return new GenerateReceiptService(fuelReciptProcessor());
    }

    @Bean
    public GenerateReciptController generateReciptController() throws IOException {
        return new GenerateReciptController(generateReciptService());
    }

    @Bean
    public ValueConfiguration valueConfiguration() {
        return new ValueConfiguration();
    }

    @Bean
    public FuelReceiptProcessor fuelReciptProcessor() throws IOException {
        return new FuelReceiptProcessor(valueConfiguration(), configuration());
    }

    @Bean
    public freemarker.template.Configuration configuration() throws IOException {
        freemarker.template.Configuration configuration = new freemarker.template.Configuration();
        configuration.setDirectoryForTemplateLoading(new ClassPathResource("templates").getFile());
        return configuration;
    }
}
