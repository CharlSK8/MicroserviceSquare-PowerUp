package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.powerup.usermicroservice.domain.model.Dish;

import java.util.List;
import java.util.Optional;

public interface IDishPersistencePort {
    void saveDish(Dish dish);
    void updateDish(Long id, Dish dish);
    void updateStatusDish(Long id, Dish dish);
    Optional<DishEntity> findById(Long id);
    List<Dish> findDishesByRestaurantAndCategory(Long idRestaurant, Long idCategory, int page, int itemsPerPage);
}
