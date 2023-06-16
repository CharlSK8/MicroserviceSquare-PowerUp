package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.OrderRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IOrderHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IOrderRequestMapper;
import com.pragma.powerup.usermicroservice.domain.api.IOrderServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderHandlerImpl implements IOrderHandler {

    private final IOrderServicePort orderServicePort;
    private final IOrderRequestMapper orderRequestMapper;
    @Override
    public void saveOrder(OrderRequestDto orderRequestDto) {
        orderServicePort.saveOrder(orderRequestMapper.toOrder(orderRequestDto),
                orderRequestMapper.toOrderDishList(orderRequestDto.getOrdersDishes()));
    }

}
