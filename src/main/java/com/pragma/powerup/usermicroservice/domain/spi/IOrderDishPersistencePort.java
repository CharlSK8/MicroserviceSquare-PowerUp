package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.OrderDishes;

public interface IOrderDishPersistencePort {

    void saveOrderDish(OrderDishes orderDish);
}
