package com.example;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtCore {
//    @Value("${testing.app.secret}")
    private String secret = "asdfsafsdfds";
//    @Value("${testing.app.expirationMs}")
    private int lifetime = 60000;

    public String generateToken(Authentication authenticator) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authenticator.getPrincipal();
        return Jwts.builder().setSubject((userDetails.getUsername())).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + lifetime))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getNameFromJwt(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody().getSubject();
    }
}
