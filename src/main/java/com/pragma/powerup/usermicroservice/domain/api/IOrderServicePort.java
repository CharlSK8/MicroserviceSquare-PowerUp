package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.OrderStatusRequestDto;
import com.pragma.powerup.usermicroservice.domain.model.Order;
import com.pragma.powerup.usermicroservice.domain.model.OrderDishes;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IOrderServicePort {
    void saveOrder(Order order, List<OrderDishes> dishList, String token);
    List<Order> findByStatus(OrderStatusRequestDto orderStatusRequestDto, int page, int itemsPerPage);
}
