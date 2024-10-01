package com.example.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                //todo
                break;
            case 404:
                if (methodKey.contains("getCountryById")) {
                    return new ResponseStatusException(HttpStatusCode.valueOf(404), "Course service is not available");
                }
            default:
                return new Exception(response.reason());
        }
        return null;
    }
}
