package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DishOrderRequestDto {
    @NotNull(message =  Constants.ENTERED_NULL_OR_EMPTY)
    private Long dishId;
    @NotNull(message =  Constants.ENTERED_NULL_OR_EMPTY)
    private int amount;
}
