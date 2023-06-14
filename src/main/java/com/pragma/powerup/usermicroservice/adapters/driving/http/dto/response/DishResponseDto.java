package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class DishResponseDto {
    private String name;
    private String description;
    private String price;
    private String urlImage;
}
