package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IRestaurantEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IRestaurantRepository;
import com.pragma.powerup.usermicroservice.domain.model.Restaurant;
import com.pragma.powerup.usermicroservice.domain.spi.IRestaurantPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class RestaurantMysqlAdapter implements IRestaurantPersistencePort {
    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;


    @Override
    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurantEntityMapper.toEntity(restaurant));
    }

    @Override
    public Optional<RestaurantEntity> findByNIT(Long nit) {
        return restaurantRepository.findByNIT(nit);
    }

    @Override
    public Optional<RestaurantEntity> findById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> getAllRestaurantsByNameAsc(int page, int itemsPerPage) {
        Pageable pageRequest = PageRequest.of(page, itemsPerPage);
        Page<RestaurantEntity> restaurantPage = restaurantRepository.findAllByOrderByNameAsc(1L, pageRequest);
        List<RestaurantEntity> restaurantList = restaurantPage.getContent();
        return restaurantEntityMapper.toRestaurant(restaurantList);
    }
}
