package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.DishNotFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.RestaurantNotFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IDishEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IDishRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IRestaurantRepository;
import com.pragma.powerup.usermicroservice.domain.model.Dish;
import com.pragma.powerup.usermicroservice.domain.spi.IDishPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class DishMysqlAdapter implements IDishPersistencePort {

    private final IDishRepository dishRepository;
    private final IRestaurantRepository restaurantRepository;
    private final IDishEntityMapper dishEntityMapper;

    @Override
    public void saveDish(Dish dish) {
       if(!restaurantRepository.existsById(dish.getRestaurant().getId())){
           throw new RestaurantNotFoundException();
       }
        dishRepository.save(dishEntityMapper.toEntity(dish));

    }

    @Override
    public void updateDish(Long id, Dish dish) {
        Optional<DishEntity> dishEntity = dishRepository.findById(id);
        if (!dishEntity.isPresent()) {
            throw new DishNotFoundException();
        }
        dishEntity.get().setPrice(dish.getPrice());
        dishEntity.get().setDescription(dish.getDescription());
        dishRepository.save(dishEntity.get());

    }

    @Override
    public void updateStatusDish(Long id, Dish dish) {
        Optional<DishEntity> dishEntity = dishRepository.findById(id);
        if (!dishEntity.isPresent()) {
            throw new DishNotFoundException();
        }
        dishEntity.get().setStatus(dish.getStatus());
        dishRepository.save(dishEntity.get());
    }


}
