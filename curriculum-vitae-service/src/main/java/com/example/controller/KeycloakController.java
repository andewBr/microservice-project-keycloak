//package com.example.controller;
//
//import com.example.service.KeycloakService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Mono;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/keycloak")
//public class KeycloakController {
//
//    @Autowired
//    private KeycloakService keycloakService;
//
//    @PostMapping("/token")
//    public Mono<Map<String, Object>> getToken(@RequestParam String login, @RequestParam String password) {
//        return keycloakService.getToken(login, password);
//    }
//}
