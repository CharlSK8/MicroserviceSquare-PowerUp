package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl.OwnerHandlerImpl;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IOwnerResponseMapper;
import com.pragma.powerup.usermicroservice.domain.api.IOwnerServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Owner;

public class OwnerUseCase implements IOwnerServicePort {
    private final OwnerHandlerImpl ownerHandler;
    private final IOwnerResponseMapper ownerResponseMapper;

    public OwnerUseCase(OwnerHandlerImpl ownerHandler, IOwnerResponseMapper ownerResponseMapper) {
        this.ownerHandler = ownerHandler;
        this.ownerResponseMapper = ownerResponseMapper;
    }

    @Override
    public Owner getOwnerByDni(String dniNumber) {
        return ownerResponseMapper.toOwner(ownerHandler.getOwnerByDni(dniNumber));
    }

    @Override
    public Owner getOwnerById(String id) {
        return ownerResponseMapper.toOwner(ownerHandler.getOwnerById(id));
    }
}
