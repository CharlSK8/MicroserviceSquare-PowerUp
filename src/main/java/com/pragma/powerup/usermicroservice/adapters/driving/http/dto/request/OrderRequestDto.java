package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@AllArgsConstructor
@Getter
public class OrderRequestDto {

    private List<DishOrderRequestDto> ordersDishes;
    private Long restaurantId;
    private Long ownerId;

}
