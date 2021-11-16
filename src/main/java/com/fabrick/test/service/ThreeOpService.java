package com.fabrick.test.service;

import com.fabrick.test.exception.BadRequestException;
import com.fabrick.test.model.Bonifico;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;


@Service
@Slf4j
public class ThreeOpService {
    Logger logger = LoggerFactory.getLogger(ThreeOpService.class);

    private final RestTemplate restTemplate;
    private final HttpHeaders headers;
    private HttpEntity request;



    public ThreeOpService(RestTemplate restTemplate, HttpHeaders headers) {
        logger.info("inside Service constructor");
        this.restTemplate = restTemplate;
        this.headers = headers;
        headers.add("Auth-Schema","S2S");
        headers.add("Api-Key","FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
        request = new HttpEntity(headers);
    }

    public ResponseEntity<?> letturaSaldo(String accountId){
        //Request URL
        String url = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/{id}/balance";

        //make an HTTP GET request with headers
        ResponseEntity<?> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                accountId
        );
        return response;

    }

    public ResponseEntity<?> bonifico (String accountId, Bonifico bonifico){
        logger.info("inside bonifico Service method");
        String url = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/{id}/payments/money-transfers";

        HttpEntity<Bonifico> newRequest = new HttpEntity<>(bonifico,headers);

        try{
            logger.info("trying to post");
            ResponseEntity<?> response = restTemplate.postForEntity(url, newRequest, Bonifico.class, accountId);
            return response;
        }catch (RuntimeException e){
            logger.info("exception!");
            throw new BadRequestException("error!!!");
        }





    }


}
