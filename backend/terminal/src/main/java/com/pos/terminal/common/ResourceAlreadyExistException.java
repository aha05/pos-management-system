package com.pos.terminal.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceAlreadyExistException extends RuntimeException {
    public ResourceAlreadyExistException(String resourceName, String fieldName, Long fieldValue) {
        super(String.format("%s already exist with the given input, %s: %s", resourceName, fieldName, fieldValue));
    }

    public ResourceAlreadyExistException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s already exist with the given input, %s: '%s'", resourceName, fieldName, fieldValue));
    }

}
