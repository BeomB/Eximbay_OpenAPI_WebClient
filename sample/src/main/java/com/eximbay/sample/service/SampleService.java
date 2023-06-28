package com.eximbay.sample.service;


import com.eximbay.sample.dto.ReadyRequest;
import com.eximbay.sample.util.UtillClass;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class SampleService {

    private static final String API_ENDPOINT = "https://api-test.eximbay.com/v1/payments/ready";
    private static final String AUTHORIZATION_HEADER = UtillClass.getBasicAuthenticationHeader("test_1849705C642C217E0B2D", "");

    public void ready() {
        ReadyRequest request = ReadyRequest.builder()
                .payment(ReadyRequest.Payment.builder()
                        .transactionType("PAYMENT")
                        .orderId("Sample_orderId_1")
                        .currency("USD")
                        .amount("1")
                        .lang("EN")
                        .paymentMethod("P000")
                        .build())
                .merchant(ReadyRequest.Merchant.builder()
                        .mid("1849705C64")
                        .build())
                .url(ReadyRequest.Url.builder()
                        .returnUrl("https://eximbay.samplesource.com/returnurl")
                        .statusUrl("https://eximbay.samplesource.com/statusurl")
                        .build())
                .buyer(ReadyRequest.Buyer.builder()
                        .name("Eximbay")
                        .email("Eximbay@test.com")
                        .build())
                .build();

        WebClient webClient = WebClient.create();
        webClient.post()
                .uri(API_ENDPOINT)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, AUTHORIZATION_HEADER)
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(System.out::println, Throwable::printStackTrace);
    }
}


