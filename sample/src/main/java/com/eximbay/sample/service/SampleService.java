package com.eximbay.sample.service;


import com.eximbay.sample.dto.CancelRequest;
import com.eximbay.sample.dto.ReadyRequest;
import com.eximbay.sample.dto.VerifyRequest;
import com.eximbay.sample.util.UtillClass;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class SampleService {
    private static final String AUTHORIZATION_HEADER = UtillClass.getBasicAuthenticationHeader("test_1849705C642C217E0B2D", "");

    public void ready() {

        String API_ENDPOINT = "https://api-test.eximbay.com/v1/payments/ready";

        ReadyRequest request = ReadyRequest.builder().payment(ReadyRequest.Payment.builder().transactionType("PAYMENT").orderId("Sample_orderId_1").currency("USD").amount("1").lang("EN").paymentMethod("P000").build()).merchant(ReadyRequest.Merchant.builder().mid("1849705C64").build()).url(ReadyRequest.Url.builder().returnUrl("https://eximbay.samplesource.com/returnurl").statusUrl("https://eximbay.samplesource.com/statusurl").build()).buyer(ReadyRequest.Buyer.builder().name("Eximbay").email("Eximbay@test.com").build()).build();

        WebClient webClient = WebClient.create();
        webClient.post().uri(API_ENDPOINT).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).header(HttpHeaders.AUTHORIZATION, AUTHORIZATION_HEADER).body(BodyInserters.fromValue(request)).retrieve().bodyToMono(String.class).subscribe(System.out::println, Throwable::printStackTrace);
    }


    public void cancel() {

        String Transaction_Id = "1849705C6420230406000005";
        String API_ENDPOINT = "https://api-test.eximbay.com/v1/payments/" + Transaction_Id + "/cancel";

        CancelRequest request = CancelRequest.builder().mid("1849705C64").payment(CancelRequest.Payment.builder().amount("1").balance("1").currency("USD").lang("KR").orderId("20230627205615").build()).refund(CancelRequest.Refund.builder().reason("테스트 거래").refundType("F").refundAmount("1").refundId("Sample_refundId_1").build()).build();


        WebClient webClient = WebClient.create();
        webClient.post().uri(API_ENDPOINT).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).header(HttpHeaders.AUTHORIZATION, AUTHORIZATION_HEADER).body(BodyInserters.fromValue(request)).retrieve().bodyToMono(String.class).subscribe(System.out::println, Throwable::printStackTrace);
    }

    public void verify() {
        String API_ENDPOINT = "https://api-test.eximbay.com/v1/payments/verify";


        String payload = "{\"data\":\"cur=KRW&dm_reject=&ver=230&mid=2C233AB5EB&amt=4650&dm_decision=&eci=02&param3=OPENAPI&resmsg=Success.&param1=SP230419YWYIZTYYVR&rescode=0000&param2=40476937&cavv=kJkBAkV5kwAAAABkhAEgdAAAAAA=&ref=SP230419YWYIZTYYVR&xid=9c7d9a6b-c0ca-4076-acac-0f03554799a8&fgkey=D45C82E34CF149EE48927B42F60EC0A73B8A3E24BFF8FD5F1BF8530FEC6D13E8&dm_review=&txntype=PAYER_AUTH&payerauthid=2023041913144025AFB7DFDA&email=robin9202@naver.com\"}";

        WebClient webClient = WebClient.create();
        
        webClient.post().uri(API_ENDPOINT).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).header(HttpHeaders.AUTHORIZATION, AUTHORIZATION_HEADER).body(BodyInserters.fromValue(payload)).retrieve().bodyToMono(String.class).subscribe(response -> {
            System.out.println("Response: " + response);
            // Process the response as needed
        });
    }

}



