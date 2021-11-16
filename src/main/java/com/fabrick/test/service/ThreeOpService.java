package com.fabrick.test.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThreeOpService {

    private final RestTemplate restTemplate;
    private final HttpHeaders headers;
    private HttpEntity request;



    public ThreeOpService(RestTemplate restTemplate, HttpHeaders headers) {
        this.restTemplate = restTemplate;
        this.headers = headers;
        //this.request = request;
        headers.add("Auth-Schema","S2S");
        headers.add("Api-Key","FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
        request = new HttpEntity(headers);
    }

    public ResponseEntity<?> letturaSaldo(String accountId){
        //Request URL
        String URL = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/{id}/balance";

        //Instance of restTemplate
        //RestTemplate restTemplate = new RestTemplate();

        //Create Headers
        //HttpHeaders headers = new HttpHeaders();

        //custom headers
        //headers.add("Auth-Schema","S2S");
        //headers.add("Api-Key","FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");

        //build the request
        //HttpEntity request = new HttpEntity(headers);

        //make an HTTP GET request with headers
        ResponseEntity<?> response = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                request,
                String.class,
                accountId
        );
        return response;

    }
/*
    public void bonifico (String accountId){
        String URL = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/{id}/payments/money-transfers";




    }*/


}
