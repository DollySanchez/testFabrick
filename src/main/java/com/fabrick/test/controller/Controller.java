package com.fabrick.test.controller;

import com.fabrick.test.model.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    @GetMapping("letturaSaldo")
    public Payload letturaSaldo(){
        String uri ="https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/14537780/balance";
        RestTemplate restTemplate = new RestTemplate();
        Payload result = restTemplate.getForObject(uri, Payload.class);
        return result;
    }
    /*
    @PostMapping("bonifico")
    public void bonifico(@RequestBody Bonifico bonifico){
        String uri ="https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/14537780/payments/money-transfers";


    }
*/

}
