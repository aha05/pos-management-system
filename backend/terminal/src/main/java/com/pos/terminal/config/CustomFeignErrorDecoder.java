package com.pos.terminal.config;

import com.pos.terminal.common.ResourceNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomFeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultDecoder =
            new ErrorDecoder.Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        if (response.status() == 404) {
            return new ResourceNotFoundException(
                    "Resource not found: " + methodKey);
        }

        return defaultDecoder.decode(methodKey, response);
    }
}
