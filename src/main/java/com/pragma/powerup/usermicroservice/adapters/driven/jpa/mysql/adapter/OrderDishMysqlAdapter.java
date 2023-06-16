package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IOrderDishEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IOrderDishRepository;
import com.pragma.powerup.usermicroservice.domain.model.OrderDishes;
import com.pragma.powerup.usermicroservice.domain.spi.IOrderDishPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
public class OrderDishMysqlAdapter implements IOrderDishPersistencePort {

    private final IOrderDishRepository orderDishRepository;
    private final IOrderDishEntityMapper orderDishEntityMapper;
    @Override
    public void saveOrderDish(OrderDishes orderDish) {
        orderDishRepository.save(orderDishEntityMapper.toEntity(orderDish));
    }
}
