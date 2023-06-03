package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.OwnerEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.PrincipalUser;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.powerup.usermicroservice.adapters.driving.http.clients.MicroserviceUser;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.OwnerResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IOwnerResponseMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MicroserviceUser microserviceUser;
    private final IOwnerResponseMapper ownerResponseMapper;

    public UserDetailsServiceImpl(MicroserviceUser microserviceUser, IOwnerResponseMapper ownerResponseMapper) {
        this.microserviceUser = microserviceUser;
        this.ownerResponseMapper = ownerResponseMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String dniNumber) throws UsernameNotFoundException {
        try {
            OwnerEntity owner = ownerResponseMapper.toEntity(microserviceUser.getOwnerByDniNumber(dniNumber));
            List<RoleEntity> roles = new ArrayList<>();
            roles.add(owner.getRoleEntity());
            return PrincipalUser.build(owner, roles);
        } catch (UsernameNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

}
