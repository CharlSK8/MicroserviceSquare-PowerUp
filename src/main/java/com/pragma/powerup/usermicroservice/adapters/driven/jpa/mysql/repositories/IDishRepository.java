package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.DishEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IDishRepository extends JpaRepository<DishEntity, Long> {

    Page<DishEntity> findDishesByRestaurantEntityIdAndCategoryEntityId(Long restaurantId, Long categoryId, PageRequest pageRequest);

}
