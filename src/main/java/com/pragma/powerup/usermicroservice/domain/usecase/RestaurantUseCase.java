package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IOwnerServicePort;
import com.pragma.powerup.usermicroservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.OwnerNotFoundException;
import com.pragma.powerup.usermicroservice.domain.exceptions.RestaurantAlreadyExistsException;
import com.pragma.powerup.usermicroservice.domain.model.Owner;
import com.pragma.powerup.usermicroservice.domain.model.Restaurant;
import com.pragma.powerup.usermicroservice.domain.spi.IRestaurantPersistencePort;
import feign.FeignException;

import java.util.List;

public class RestaurantUseCase implements IRestaurantServicePort {

    private final IRestaurantPersistencePort restaurantPersistencePort;
    private final IOwnerServicePort ownerServicePort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort, IOwnerServicePort ownerServicePort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
        this.ownerServicePort = ownerServicePort;
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        if(restaurantPersistencePort.findByNIT(restaurant.getNIT()).isPresent()){
            throw new RestaurantAlreadyExistsException();
        }
        try {
            Owner owner = ownerServicePort.getOwnerById(restaurant.getIdUser().toString());
            restaurant.setIdUser(owner.getId());
            restaurantPersistencePort.saveRestaurant(restaurant);
        } catch (FeignException e) {
            throw new OwnerNotFoundException();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while saving the restaurant: " +  e.getMessage());
        }
    }

    @Override
    public List<Restaurant> getAllRestaurantsByNameAsc(int page, int itemsPerPage) {
        return restaurantPersistencePort.getAllRestaurantsByNameAsc(page, itemsPerPage);
    }
}
