package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Optional;

public interface IRestaurantRepository extends JpaRepository<RestaurantEntity,Long> {
    Optional<RestaurantEntity> findByNIT(Long nit);
    Page<RestaurantEntity> findAllByOrderByNameAsc(PageRequest pageRequest);
}
