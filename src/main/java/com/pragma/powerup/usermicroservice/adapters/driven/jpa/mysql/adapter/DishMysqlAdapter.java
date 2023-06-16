package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.DishNotFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IDishEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IDishRepository;
import com.pragma.powerup.usermicroservice.domain.model.Dish;
import com.pragma.powerup.usermicroservice.domain.spi.IDishPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DishMysqlAdapter implements IDishPersistencePort {

    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;

    @Override
    public void saveDish(Dish dish) {
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

    @Override
    public boolean existsById(Long id) {
        return dishRepository.existsById(id);
    }

    @Override
    public Optional<DishEntity> findById(Long id) {
        return dishRepository.findById(id);
    }

    @Override
    public List<Dish> findDishesByRestaurantAndCategory(Long idRestaurant, Long idCategory, int page, int itemsPerPage) {
        PageRequest pageRequest = PageRequest.of(page, itemsPerPage);
        return dishEntityMapper.toDish(dishRepository.findDishesByRestaurantEntityIdAndCategoryEntityId(idRestaurant, idCategory, pageRequest).getContent());
    }


}
