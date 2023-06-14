package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.DishRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.DishStatusRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.DishUpdateRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.DishResponseDto;

import java.util.List;

public interface IDishHandler {
    void saveDish(DishRequestDto dishRequestDto);
    void updateDish(Long id, DishUpdateRequestDto dishUpdateRequestDto);
    void updateStatusDish(Long id, DishStatusRequestDto dishStatusRequestDto, String token);
    List<DishResponseDto> findDishesByRestaurantAndCategory(Long idRestaurant, Long idCategory, int page, int itemsPerPage);

}
