package com.pos.gatewayserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class FallbackController {
    @RequestMapping("/serviceUnavailable")
    public Mono<ResponseEntity<Map<String, String>>> contactSupport() {
        Map<String, String> response = Map.of(
                "error", "true",
                "message", "An error occurred. Please try after some time or contact support team!!!"
        );

        return Mono.just(
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response)
        );
    }
}
