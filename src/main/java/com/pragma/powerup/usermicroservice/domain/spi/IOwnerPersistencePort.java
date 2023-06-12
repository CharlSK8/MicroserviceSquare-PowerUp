package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.Owner;

public interface IOwnerPersistencePort {
    Owner getOwnerByDni(String dniNumber);
    Owner getOwnerById(String id);
}
