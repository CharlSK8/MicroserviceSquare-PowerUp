package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.clients.MicroserviceUserFeign;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.OwnerResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IOwnerHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerHandlerImpl implements IOwnerHandler{

    private final MicroserviceUserFeign microserviceUserFeign;

    @Override
    public OwnerResponseDto getOwnerByDni(String dniNumber) {
        return microserviceUserFeign.getOwnerByDni(dniNumber);
    }

    @Override
    public OwnerResponseDto getOwnerById(String id) {
        return microserviceUserFeign.getOwnerById(id);
    }
}
