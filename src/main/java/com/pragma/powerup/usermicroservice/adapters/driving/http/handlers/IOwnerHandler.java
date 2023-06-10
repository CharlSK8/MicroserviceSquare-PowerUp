package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.OwnerResponseDto;

public interface IOwnerHandler {
    OwnerResponseDto getOwnerByDni(String dniNumber);
    OwnerResponseDto getOwnerById(String id);
}
