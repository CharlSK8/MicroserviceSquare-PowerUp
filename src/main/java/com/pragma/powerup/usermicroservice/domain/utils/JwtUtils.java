package com.pragma.powerup.usermicroservice.domain.utils;

import com.pragma.powerup.usermicroservice.domain.api.IOwnerServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Owner;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret;

    private final IOwnerServicePort ownerServicePort;

    public JwtUtils(IOwnerServicePort ownerServicePort) {
        this.ownerServicePort = ownerServicePort;
    }

    public Long idFromToken(String token){
        String jwtToken = token.replace("Bearer ", "");
        Jws<Claims> decodedToken = Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(jwtToken);
        Claims claims = decodedToken.getBody();
        String dniToken = claims.getSubject();
        Owner owner = ownerServicePort.getOwnerByDni(dniToken);
        return owner.getId();
    }
}
