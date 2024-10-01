package com.example.controller;

import com.example.entity.CurriculumVitae;
import com.example.service.CurriculumVitaeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/curriculum-vitae/")
@RequiredArgsConstructor
public class CvController {

    private final CurriculumVitaeService curriculumVitaeService;
    private final CurriculumVitaeService cvService;

    @GetMapping("/hello")
    public void helloMapping() {
        System.out.println("hello");
    }

    // Этот метод обрабатывает GET-запрос на /api/cv/{uuid}
    @GetMapping("country/{countryId}")
    public ResponseEntity<String> getCvByUuid(@PathVariable(value = "countryId") long countryId) {
        String countryName = cvService.getCountryNameById(countryId);

        if (countryName != null) {
            return ResponseEntity.ok(countryName);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
