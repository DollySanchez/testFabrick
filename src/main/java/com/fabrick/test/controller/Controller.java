package com.fabrick.test.controller;


import com.fabrick.test.exception.BadRequestException;
import com.fabrick.test.model.Bonifico;
import com.fabrick.test.service.ThreeOpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value="/test")
public class Controller {

    @Autowired
    ThreeOpService threeOpService;

    @GetMapping(value = "/letturaSaldo")
    public ResponseEntity<?> letturaSaldo(@RequestParam(value="accountId") String accountId){

        return threeOpService.letturaSaldo(accountId);
    }

    @PostMapping(value="/bonifico")
    public ResponseEntity<?> bonifico(@RequestParam(value="accountId") String accountId,
                                      @RequestBody Bonifico bonifico){

        return threeOpService.bonifico(accountId,bonifico);

    }








}
