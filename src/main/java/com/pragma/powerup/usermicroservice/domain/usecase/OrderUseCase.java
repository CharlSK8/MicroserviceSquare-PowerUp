package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IOrderServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Order;
import com.pragma.powerup.usermicroservice.domain.model.OrderDishes;
import com.pragma.powerup.usermicroservice.domain.spi.IOrderDishPersistencePort;
import com.pragma.powerup.usermicroservice.domain.spi.IOrderPersistencePort;

import java.time.LocalDateTime;
import java.util.List;


public class OrderUseCase implements IOrderServicePort {

    private final IOrderPersistencePort orderPersistencePort;
    private final IOrderDishPersistencePort orderDishPersistencePort;

    public OrderUseCase(IOrderPersistencePort orderPersistencePort, IOrderDishPersistencePort orderDishPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
        this.orderDishPersistencePort = orderDishPersistencePort;
    }

    @Override
    public void saveOrder(Order order, List<OrderDishes> dishList) {
        order.setStatus("Pendiente");
        order.setStartDate(LocalDateTime.now());
        Order orderPersistence = orderPersistencePort.saveOrder(order);
        for (OrderDishes orderDishes: dishList) {
            orderDishes.setOrder(orderPersistence);
            orderDishPersistencePort.saveOrderDish(orderDishes);
        }
    }
}
