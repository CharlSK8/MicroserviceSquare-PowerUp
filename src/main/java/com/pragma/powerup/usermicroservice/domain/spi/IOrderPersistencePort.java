package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.Order;

import java.util.List;

public interface IOrderPersistencePort {
    Order saveOrder(Order order);
    boolean existsOrderInProcessByOwnerId(Long idOwner);
    List<Order> findByStatus(String status, int page, int itemsPerPage);
}
