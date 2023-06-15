package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import com.pragma.powerup.usermicroservice.domain.api.IDishServicePort;
import com.pragma.powerup.usermicroservice.domain.api.IOwnerServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.*;
import com.pragma.powerup.usermicroservice.domain.model.Dish;
import com.pragma.powerup.usermicroservice.domain.model.Owner;
import com.pragma.powerup.usermicroservice.domain.spi.ICategoryPersistencePort;
import com.pragma.powerup.usermicroservice.domain.spi.IDishPersistencePort;
import com.pragma.powerup.usermicroservice.domain.spi.IRestaurantPersistencePort;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import java.security.Key;
import java.util.List;

public class DishUseCase implements IDishServicePort {

    @Value("${jwt.secret}")
    private String secret;

    private final IDishPersistencePort dishPersistencePort;
    private final IOwnerServicePort ownerServicePort;
    private final IRestaurantPersistencePort restaurantPersistencePort;
    private final ICategoryPersistencePort categoryPersistencePort;

    public DishUseCase(IDishPersistencePort dishPersistencePort, IOwnerServicePort ownerServicePort, IRestaurantPersistencePort restaurantPersistencePort, ICategoryPersistencePort categoryPersistencePort) {
        this.dishPersistencePort = dishPersistencePort;
        this.ownerServicePort = ownerServicePort;
        this.restaurantPersistencePort = restaurantPersistencePort;
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveDish(Dish dish) {
        dish.setStatus(true);
        if(!restaurantPersistencePort.findById(dish.getRestaurant().getId()).isPresent()) {
            throw new RestaurantNotFoundException();
        }
        dishPersistencePort.saveDish(dish);
    }

    @Override
    public void updateDish(Long id, Dish dish) {
        dishPersistencePort.updateDish(id, dish);
    }

    @Override
    public void updateStatusDish(Long id, Dish dish, String token) {
        DishEntity dishEntity = dishPersistencePort.findById(id).orElseThrow(DishNotFoundDbException::new);

        Long idRestaurant = dishEntity.getRestaurantEntity().getId();
        String dniNumber = extractDniNumberFromToken(token);

        if(!isOwnerOfRestaurant(idRestaurant,dniNumber)){
            throw new UnauthorizedDishEditStatusException();
        }
        dishPersistencePort.updateStatusDish(id, dish);
    }

    @Override
    public List<Dish> findDishesByRestaurantAndCategory(Long restaurantId, Long categoryId, int page, int itemsPerPage) {
        validateRestaurantExists(restaurantId);
        validateCategoryExists(categoryId);

        List<Dish> listDishes = dishPersistencePort.findDishesByRestaurantAndCategory(restaurantId, categoryId, page, itemsPerPage);

        if(listDishes.isEmpty()){
            throw new MenuNotFoundException();
        }
        return listDishes;
    }
    private void validateRestaurantExists(Long restaurantId) {
        if (!restaurantPersistencePort.existsById(restaurantId)) {
            throw new RestaurantNotFoundException();
        }
    }

    private void validateCategoryExists(Long categoryId) {
        if (!categoryPersistencePort.existsById(categoryId)) {
            throw new CategoryNotFoundException();
        }
    }

    private String extractDniNumberFromToken(String token) {
        String jwtToken = token.replace("Bearer ", "");
        Claims claims = parseJwtToken(jwtToken);
        return claims.getSubject();
    }

    private Claims parseJwtToken(String jwtToken) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtToken).getBody();
    }

    private boolean isOwnerOfRestaurant(Long restaurantId, String dniNumber) {
        RestaurantEntity restaurantEntity = restaurantPersistencePort.findById(restaurantId).orElseThrow(RestaurantNotFoundException::new);
        Owner owner = ownerServicePort.getOwnerByDni(dniNumber);
        Long ownerRestaurantId = restaurantEntity.getIdOwner();
        return owner.getId().equals(ownerRestaurantId);
    }
}
