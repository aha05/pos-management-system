package com.pos.merchant.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.TOO_MANY_REQUESTS)
public class TooManyRequestsException extends RuntimeException {
    public TooManyRequestsException(String message) {
        super("Too many requests. Please try again later");
    }

    public TooManyRequestsException() {
        super("Too many requests. Please try again later");
    }
}
