package com.pragma.powerup.usermicroservice.adapters.driving.http.clients;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.OwnerResponseDto;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class MicroserviceUser {
    //TODO: Generar toda la estructura de archivos para la arquitectura

    private final RestTemplate restTemplate;

    public MicroserviceUser() {
        this.restTemplate = new RestTemplate();
    }

    public OwnerResponseDto getOwnerByDniNumber(String dniNumber) {

        //TODO: almacenar url en application.properties
        String url = "http://localhost:8090/owner/search/" + dniNumber;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        OwnerResponseDto response = restTemplate.getForObject(url, OwnerResponseDto.class);

        if (response != null) {
            return response;
        } else {
            //TODO: create exception here
            throw new NullPointerException();
        }
    }
}
