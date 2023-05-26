package com.pragma.powerup.usermicroservice.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;


@Interceptor
public class RoleValidationInterceptor{

    @Value("${jwt.secret}")
    private static String secret;

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        HttpServletRequest request = (HttpServletRequest) context.getParameters()[0];
        String token = request.getHeader("Authorization");

        Claims claims = Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
        String userRole = (String) claims.get("roles");
        System.out.println("Interceptor");
        System.out.println(userRole);

        if (!userRole.equals("ROLE_OWNER")) {
            throw new SecurityException("Access denied. User role not authorized for this operation.");
        }

        return context.proceed();
    }

}
