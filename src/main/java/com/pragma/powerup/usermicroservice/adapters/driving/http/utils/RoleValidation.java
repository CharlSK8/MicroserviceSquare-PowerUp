package com.pragma.powerup.usermicroservice.adapters.driving.http.utils;

import com.pragma.powerup.usermicroservice.adapters.driving.http.exceptions.InvalidRoleException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;

@Aspect
@Component
public class RoleValidation {

    @Around("@annotation(requiresRole)")
    public Object validateRole(ProceedingJoinPoint joinPoint, RequiresRole requiresRole) throws Throwable {

        String[] requiredRoles = requiresRole.value();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserRole = null;

        if (authentication != null && authentication.getAuthorities() != null) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                currentUserRole = authority.getAuthority();
            }
        }
        if (currentUserRole != null && Arrays.asList(requiredRoles).contains(currentUserRole)) {
            return joinPoint.proceed();
        } else {
            throw new InvalidRoleException();
        }
    }
}
