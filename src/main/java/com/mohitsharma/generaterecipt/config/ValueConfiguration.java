package com.mohitsharma.generaterecipt.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.mohitsharma.values")
@Getter
@Setter
public class ValueConfiguration {
    private String fuelReciptTemplateName;
}
