package com.example;

import com.example.dto.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


import java.util.Map;

@RestController
@RequestMapping("/auth")
public class ApiGateWayController {

    @Autowired
    private KeycloakService keycloakService;

    @PostMapping("/token")
    public ResponseEntity<Mono<Map<String, Object>>> getToken(@RequestBody AuthRequest authRequest) {
        Mono<Map<String, Object>> token = keycloakService.getToken(authRequest.getEmail(), authRequest.getPassword());
        System.out.println("======>>>>>> token: " +  token);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        keycloakService.validateToken(token);
        return "token is valid";
    }

}
