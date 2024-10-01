package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("secured")
public class MainController {

    @GetMapping("/user")
    public String userAuth(Principal principal) {
        if (principal != null) {
            return null;
        }
        return principal.getName();
    }

}