package com.pragma.powerup.usermicroservice.adapters.driving.http.clients;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.OwnerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microserviceUser", url = "${url.microserviceUser}")
public interface MicroserviceUserFeign {

    @GetMapping("/search/{dniNumber}")
    OwnerResponseDto getOwnerByDni(@PathVariable String dniNumber);
    @GetMapping("/{id}")
    OwnerResponseDto getOwnerById(@PathVariable String id);
}
