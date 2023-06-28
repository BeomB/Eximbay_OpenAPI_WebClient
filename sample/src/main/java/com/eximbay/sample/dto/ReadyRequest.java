package com.eximbay.sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ReadyRequest {

    private Payment payment;
    private Merchant merchant;
    private Url url;
    private Buyer buyer;

    @Builder
    public ReadyRequest(Payment payment, Merchant merchant, Url url, Buyer buyer) {
        this.payment = payment;
        this.merchant = merchant;
        this.url = url;
        this.buyer = buyer;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Payment {

        @JsonProperty("transaction_type")
        private String transactionType;
        @JsonProperty("order_id")
        private String orderId;
        private String currency;
        private String amount;
        private String lang;
        @JsonProperty("payment_method")
        private String paymentMethod;


        @Builder
        public Payment(String transactionType, String orderId, String currency, String amount, String lang, String paymentMethod) {
            this.transactionType = transactionType;
            this.orderId = orderId;
            this.currency = currency;
            this.amount = amount;
            this.lang = lang;
            this.paymentMethod = paymentMethod;
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Merchant {
        private String mid;

        @Builder
        public Merchant(String mid) {
            this.mid = mid;
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Url {
        @JsonProperty("return_url")
        private String returnUrl;
        @JsonProperty("status_url")
        private String statusUrl;

        @Builder
        public Url(String returnUrl, String statusUrl) {
            this.returnUrl = returnUrl;
            this.statusUrl = statusUrl;
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Buyer {
        private String name;
        private String email;

        @Builder
        public Buyer(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }
}

