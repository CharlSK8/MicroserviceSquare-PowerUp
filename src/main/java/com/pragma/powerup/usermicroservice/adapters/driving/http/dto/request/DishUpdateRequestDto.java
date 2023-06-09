package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DishUpdateRequestDto {

    @Positive(message = Constants.PRICE_VALIDATION)
    @NotNull(message =  Constants.ENTERED_NULL_OR_EMPTY)
    private String price;
    @NotBlank(message =  Constants.ENTERED_NULL_OR_EMPTY)
    private String description;
}
