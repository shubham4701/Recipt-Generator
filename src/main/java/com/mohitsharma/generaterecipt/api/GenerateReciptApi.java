package com.mohitsharma.generaterecipt.api;

import com.mohitsharma.generaterecipt.entity.ReciptCreationRequest;
import freemarker.template.TemplateException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/v1/generate")
public interface GenerateReciptApi {

    @PostMapping
    void generateReceipts(@RequestBody final ReciptCreationRequest reciptCreationRequest)
            throws IOException, TemplateException;

}
