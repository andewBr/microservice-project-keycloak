package com.example.client;

import com.example.entity.Country;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COUNTRY-SERVICE")
public interface CountryClient {

//    @CircuitBreaker(name = "countryServiceCircuitBreaker", fallbackMethod = "fallbackGetCountryName")
    @GetMapping("/country-server/api/v1/countries/{id}")
    ResponseEntity<Country> getCountryById(@PathVariable("id") Long id);

//    // Метод, который будет вызван при срабатывании Circuit Breaker
//    default String fallbackGetCountryName(Long countryId, Throwable throwable) {
//        System.out.println("===>>> countryId: " + countryId);
//        System.out.println("===>>> exception: " + throwable.getMessage());
//        return "Unknown Country";
//    }
}