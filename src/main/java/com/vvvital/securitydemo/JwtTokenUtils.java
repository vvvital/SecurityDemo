package com.vvvital.securitydemo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.hibernate.annotations.Comment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtils {

    private String secret;
    private Duration tokenLifeTime;

    public String generateToken(UserDetails userDetails){
        Map<String, Object> climes= new HashMap<>();
        List<String>rolesList=userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority).toList();
        climes.put("roles",rolesList);
        Date issueDate = new Date();
        Date expiredDate = new Date(issueDate.getTime() + tokenLifeTime.toMillis());
        return Jwts.builder()
                .claim("role",rolesList)
                .issuedAt(issueDate)
                .expiration(expiredDate)
                .signWith(SignatureAlgorithm.ES256,secret)
                .compact();
    }

    public Claims getClaims(String token) {
        return null;
    }
}
