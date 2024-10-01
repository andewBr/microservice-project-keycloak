//package com.example.controller;
//
//import com.example.entity.CurriculumVitae;
//import com.example.service.CurriculumVitaeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Optional;
//import java.util.UUID;
//
//@RestController
//public class CurriculumVitaeController {
//    @Autowired
//    private CurriculumVitaeService curriculumVitaeService;
//
//    @GetMapping("/api/cv/{uuid}")
//    public ResponseEntity<CurriculumVitae> getCvOfUser(@PathVariable UUID uuid) {
//        Optional<CurriculumVitae> cv = curriculumVitaeService.getCvByUuid(uuid);
//        System.out.println(cv);
//        return cv.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//}
