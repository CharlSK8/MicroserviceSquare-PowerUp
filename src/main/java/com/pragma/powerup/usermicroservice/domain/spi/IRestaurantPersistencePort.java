package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import com.pragma.powerup.usermicroservice.domain.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface IRestaurantPersistencePort {
    void saveRestaurant(Restaurant restaurant);
    Optional<RestaurantEntity> findByNIT(Long nit);
    Optional<RestaurantEntity> findById(Long id);
    boolean existsById(Long id);
    List<Restaurant> getAllRestaurantsByNameAsc(int page, int itemsPerPage);
}
