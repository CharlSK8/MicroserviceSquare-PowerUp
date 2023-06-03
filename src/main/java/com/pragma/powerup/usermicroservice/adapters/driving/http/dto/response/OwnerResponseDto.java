package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import com.pragma.powerup.usermicroservice.domain.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OwnerResponseDto {

    private String name;
    private String surname;
    private Long dniNumber;
    private String phone;
    private LocalDate birthOfDate;
    private String mail;
    private String password;
    private Role role;

}
