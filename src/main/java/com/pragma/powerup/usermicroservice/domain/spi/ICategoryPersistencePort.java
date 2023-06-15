package com.pragma.powerup.usermicroservice.domain.spi;

public interface ICategoryPersistencePort {
    boolean existsById(Long id);
}
