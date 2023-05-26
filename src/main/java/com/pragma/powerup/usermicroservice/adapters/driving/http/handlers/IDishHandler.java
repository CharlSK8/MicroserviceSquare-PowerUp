package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.DishRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.DishUpdateRequestDto;

public interface IDishHandler {
    void saveDish(DishRequestDto dishRequestDto);
    void updateDish(Long id, DishUpdateRequestDto dishUpdateRequestDto);

}
