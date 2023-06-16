package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.domain.model.Order;
import com.pragma.powerup.usermicroservice.domain.model.OrderDishes;

import java.util.List;

public interface IOrderServicePort {
    void saveOrder(Order order, List<OrderDishes> dishList, String token);
}
