package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.domain.model.Owner;

public interface IOwnerServicePort {
    Owner getOwnerByDni(String dniNumber);
    Owner getOwnerById(String id);
}
