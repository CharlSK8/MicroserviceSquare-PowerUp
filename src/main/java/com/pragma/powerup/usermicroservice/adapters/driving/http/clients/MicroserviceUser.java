package com.pragma.powerup.usermicroservice.adapters.driving.http.clients;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.OwnerResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class MicroserviceUser {
    //TODO: Generar toda la estructura de archivos para la arquitectura, handler, service, ports

    @Value("${url.microserviceUser.findByDni}")
    private String urlMicroserviceUser;

    private final RestTemplate restTemplate;

    public MicroserviceUser() {
        this.restTemplate = new RestTemplate();
    }

    public OwnerResponseDto getOwnerByDniNumber(String dniNumber) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        OwnerResponseDto OwnerResponse = restTemplate.getForObject(urlMicroserviceUser + dniNumber, OwnerResponseDto.class);

        if (OwnerResponse != null) {
            return OwnerResponse;
        } else {
            throw new PersonNotFoundException();
        }
    }
}
