package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import com.pragma.powerup.usermicroservice.domain.api.IDishServicePort;
import com.pragma.powerup.usermicroservice.domain.api.IOwnerServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.DishNotFoundDbException;
import com.pragma.powerup.usermicroservice.domain.exceptions.RestaurantNotFoundException;
import com.pragma.powerup.usermicroservice.domain.exceptions.UnauthorizedDishEditStatusException;
import com.pragma.powerup.usermicroservice.domain.model.Dish;
import com.pragma.powerup.usermicroservice.domain.model.Owner;
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

    public DishUseCase(IDishPersistencePort dishPersistencePort, IOwnerServicePort ownerServicePort, IRestaurantPersistencePort restaurantPersistencePort) {
        this.dishPersistencePort = dishPersistencePort;
        this.ownerServicePort = ownerServicePort;
        this.restaurantPersistencePort = restaurantPersistencePort;
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
    public List<Dish> findDishesByRestaurantAndCategory(Long idRestaurant, Long idCategory, int page, int itemsPerPage) {
        return dishPersistencePort.findDishesByRestaurantAndCategory(idRestaurant, idCategory, page, itemsPerPage);
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
