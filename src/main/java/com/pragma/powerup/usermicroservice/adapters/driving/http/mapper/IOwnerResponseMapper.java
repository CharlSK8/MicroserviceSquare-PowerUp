package com.pragma.powerup.usermicroservice.adapters.driving.http.mapper;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.OwnerResponseDto;
import com.pragma.powerup.usermicroservice.domain.model.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOwnerResponseMapper {
    OwnerResponseDto toOwnerResponse(Owner owner);
    Owner toOwner(OwnerResponseDto ownerResponseDto);
}
