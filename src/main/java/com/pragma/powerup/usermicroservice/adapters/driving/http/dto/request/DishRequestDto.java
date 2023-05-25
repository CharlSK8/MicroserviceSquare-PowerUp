package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DishRequestDto {

    private String name;
    private String price;
    private String description;
    private String urlImage;
    private Long idCategory;
    private Long idRestaurant;
}
