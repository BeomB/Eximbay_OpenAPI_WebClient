package com.eximbay.sample.dto;

import lombok.Builder;
import lombok.Getter;



@Getter
public class VerifyRequest {

    private String data;

    @Builder
    public VerifyRequest(String data) {
        this.data = data;
    }
}

