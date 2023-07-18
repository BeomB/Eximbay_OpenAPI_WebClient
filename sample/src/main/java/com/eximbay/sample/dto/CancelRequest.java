package com.eximbay.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CancelRequest {          // 취소 API Request DTO 생성


    private String mid;
    private Payment payment;
    private Refund refund;

    @Builder
    public CancelRequest(String mid, Payment payment, Refund refund) {
        this.mid = mid;
        this.payment = payment;
        this.refund = refund;
    }

    @Data
    @NoArgsConstructor
    public static class Payment {
        private String amount;
        private String balance;
        private String currency;
        private String lang;
        private String orderId;

        @Builder
        public Payment(String amount, String balance, String currency, String lang, String orderId) {
            this.amount = amount;
            this.balance = balance;
            this.currency = currency;
            this.lang = lang;
            this.orderId = orderId;
        }
    }

    @Data
    @NoArgsConstructor
    public static class Refund {
        private String reason;
        private String refundType;
        private String refundAmount;
        private String refundId;

        @Builder
        public Refund(String reason, String refundType, String refundAmount, String refundId) {
            this.reason = reason;
            this.refundType = refundType;
            this.refundAmount = refundAmount;
            this.refundId = refundId;
        }
    }
}
