package com.example.controller;

import com.example.client.CountriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/curriculum-vitae/")
public class CountriesController {

    private final CountriesService countriesService;

    @GetMapping("/v2/country/{countryId}")
    public ResponseEntity<String> getCvByUuid2(@PathVariable(value = "countryId") long countryId) {
        String countryName = String.valueOf(countriesService.getCountryNameById(countryId));

        if (countryName != null) {
            return ResponseEntity.ok(countryName);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
