package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import com.pragma.powerup.usermicroservice.domain.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class OrderResponseDto {
    private Long id;
    private String status;
    private LocalDateTime startDate;
    private Restaurant restaurant;
    private Long ownerId;

}
