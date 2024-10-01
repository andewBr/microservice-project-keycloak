//package com.example.util;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import lombok.Getter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import ru.gogolin.exception.MyBadCredentialException;
//
//import java.security.Key;
//
//@Getter
//@Component
//public class JwtUtil {
//
//    @Value("${spring.security.secret.key}")
//    private String secretKey;
//
//    public void validateToken(String authHeader) {
//        try {
//            Jwts.parserBuilder()
//                    .setSigningKey(getSignKey())
//                    .build()
//                    .parseClaimsJws(authHeader);
//        }catch (Exception e) {
//            throw new MyBadCredentialException("Jwt token is not invalid");
//        }
//    }
//
//    public Key getSignKey() {
//        String secretKey = getSecretKey();
//        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//
//
//}
