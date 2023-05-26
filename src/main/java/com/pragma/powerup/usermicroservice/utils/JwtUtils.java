package com.pragma.powerup.usermicroservice.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;


public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret;

    public  String extractRoleFromJwt(String jwt) {
        jwt= jwt.replaceAll("\\b" + "Bearer " + "\\b", "");
        Jwt<?, ?> parsedJwt = Jwts.parser().setSigningKey(secret.getBytes()).parse(jwt);
        Claims claims = (Claims) parsedJwt.getBody();
        ArrayList<String> role = (ArrayList<String>) claims.get("roles");
        return role.get(0);
    }
}


