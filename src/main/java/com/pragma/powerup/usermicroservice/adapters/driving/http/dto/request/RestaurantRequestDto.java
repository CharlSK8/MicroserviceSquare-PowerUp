package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RestaurantRequestDto {

    @NotBlank(message =  Constants.ENTERED_NULL_OR_EMPTY)
    @Pattern(regexp = "^(?=.*[a-zA-Z])[\\w\\d\\s]*[a-zA-Z]+[\\w\\d\\s]*$", message = Constants.NAME_VALIDATION)
    private String name;
    @NotBlank(message =  Constants.ENTERED_NULL_OR_EMPTY)
    @Pattern(regexp = "[0-9]*", message = Constants.NIT_VALIDATION)
    private String NIT;
    @NotBlank(message = Constants.ENTERED_NULL_OR_EMPTY)
    private String address;
    @NotBlank(message = Constants.ENTERED_NULL_OR_EMPTY)
    @Pattern(regexp = "^[+]?[0-9]+$", message = Constants.PHONE_VALIDATION)
    @Size(min = 10, max = 13, message = Constants.PHONE_LENGTH)
    private String phone;
    @NotBlank(message = Constants.ENTERED_NULL_OR_EMPTY)
    private String urlLogo;
    @NotNull(message =  Constants.ENTERED_NULL_OR_EMPTY)
    private long idUser;
}
