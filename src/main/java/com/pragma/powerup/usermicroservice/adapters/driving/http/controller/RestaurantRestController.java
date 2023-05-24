package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;


import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.RoleNotAllowedForCreationException;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.exceptions.RoleNotAllowedForRestaurantException;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IRestaurantHandler;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.utils.JwtUtils;
import com.pragma.powerup.usermicroservice.utils.RoleValidationInterceptor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.interceptor.Interceptors;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantRestController {

    private final IRestaurantHandler restaurantHandler;

    @Autowired
    private final JwtUtils jwtUtils;

    @Operation(summary = "Add a new restaurant",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Restaurant created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Restaurant already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveRestaurant(@RequestHeader("Authorization") String jwtToken,@Valid @RequestBody RestaurantRequestDto restaurantRequestDto) {
        //TODO: Validar rol de usuario ingresado en el DTO
        String role = jwtUtils.extractRoleFromJwt(jwtToken);
        if (!role.equals(Constants.ROLE_ADMIN)){
            throw new RoleNotAllowedForCreationException();
        }
        restaurantHandler.saveRestaurant(restaurantRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.PERSON_CREATED_MESSAGE));
    }
}
