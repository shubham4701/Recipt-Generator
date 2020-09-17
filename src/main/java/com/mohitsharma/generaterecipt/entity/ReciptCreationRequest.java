package com.mohitsharma.generaterecipt.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
public class ReciptCreationRequest {

    private ReciptType reciptType;
    private Map<String, String> parameters;

}
