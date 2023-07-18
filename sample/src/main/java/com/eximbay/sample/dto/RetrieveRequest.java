package com.eximbay.sample.dto;

import lombok.Getter;



@Getter
@NoArgsConstructor
public class RetrieveRequest {         // 조회 API Request DTO 생성

    private String mid;
    private String keyField;
    private Payment payment;

    @Getter
    public static class Payment {
        private String orderId;
        private String currency;
        private String amount;
        private String lang;
        private String transactionId;
    }

}
