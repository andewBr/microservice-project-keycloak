package com.example.client;

import com.example.entity.Country;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CountriesService {

    @Autowired
    private CountryClient countryClient;

    @CircuitBreaker(name = "countryServiceCircuitBreaker", fallbackMethod = "fallbackGetCountryNameById")
    public Country getCountryNameById(Long countryId) {
        ResponseEntity<Country> response = countryClient.getCountryById(countryId);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            return null;
        }
    }

    // http://localhost:[port]/actuator/circuitbreakerevents
    // Fallback метод
    public Country fallbackGetCountryNameById(Long countryId, Throwable throwable) {
        System.out.println("===>>> Fallback countryId: " + countryId);
        System.out.println("===>>> Exception: " + throwable.getMessage());

        // Возвращаем объект типа Country с значениями по умолчанию
        Country fallbackCountry = new Country();
        fallbackCountry.setId(countryId);
        fallbackCountry.setCountryName("Fallback Country");
        return fallbackCountry;
    }
}
