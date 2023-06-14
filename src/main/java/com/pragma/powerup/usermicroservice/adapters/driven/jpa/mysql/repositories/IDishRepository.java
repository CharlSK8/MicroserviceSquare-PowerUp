package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.powerup.usermicroservice.domain.model.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IDishRepository extends JpaRepository<DishEntity, Long> {
    Optional<DishEntity> findByName(String name);
    Page<DishEntity> findDishesByRestaurantEntityIdAndCategoryEntityId(Long restaurantId, Long categoryId, PageRequest pageRequest);

}
