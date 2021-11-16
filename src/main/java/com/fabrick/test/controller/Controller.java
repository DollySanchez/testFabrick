package com.fabrick.test.controller;


import com.fabrick.test.service.ThreeOpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@RestController
@RequestMapping(value="/test")
public class Controller {

    @Autowired
    ThreeOpService threeOpService;

    @GetMapping(value = "/letturaSaldo")
    public ResponseEntity<?> letturaSaldo(@RequestParam(value="accountId") String accountId){

        return threeOpService.letturaSaldo(accountId);
    }








}
