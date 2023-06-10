package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.OwnerEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.PrincipalUser;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IOwnerEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.clients.MicroserviceUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MicroserviceUser microserviceUser;
    private final IOwnerEntityMapper ownerEntityMapper;

    public UserDetailsServiceImpl(MicroserviceUser microserviceUser, IOwnerEntityMapper ownerEntityMapper) {
        this.microserviceUser = microserviceUser;
        this.ownerEntityMapper = ownerEntityMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String dniNumber) throws UsernameNotFoundException {
        try {
            OwnerEntity owner = ownerEntityMapper.toEntity(microserviceUser.getOwnerByDniNumber(dniNumber));
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
