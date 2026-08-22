package com.pos.transaction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public String index(){
        System.out.println("Payment Request Accepted!");
        return "Payment Accepted!";
    }
}
