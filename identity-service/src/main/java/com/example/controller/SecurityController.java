package com.example.controller;

import com.example.JwtCore;
import com.example.entity.SignUpRequest;
import com.example.entity.SigninRequest;
import com.example.entity.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class SecurityController {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final AuthenticationManager authenticationManager;
    private final JwtCore jwtCore;


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Choose different name");
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Choose different email");
        }
        User user = new User();
        user.setUsername(signUpRequest.getUsername());
//        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setEmail(signUpRequest.getEmail());
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

//    @PostMapping("/signin")
//    ResponseEntity<?> signin(@RequestBody SigninRequest signInRequest) {
//        Authentication authentication = null;
//        try {
//            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));
//        } catch (BadCredentialsException e) {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//        return ResponseEntity.ok(jwtCore.generateToken(authentication));
//    }

}
