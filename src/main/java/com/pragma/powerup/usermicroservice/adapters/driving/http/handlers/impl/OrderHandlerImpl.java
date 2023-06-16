package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.OrderRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.OrderStatusRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.OrderResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IOrderHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IOrderRequestMapper;
import com.pragma.powerup.usermicroservice.domain.api.IOrderServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderHandlerImpl implements IOrderHandler {

    private final IOrderServicePort orderServicePort;
    private final IOrderRequestMapper orderRequestMapper;
    @Override
    public void saveOrder(OrderRequestDto orderRequestDto, String token) {
        orderServicePort.saveOrder(orderRequestMapper.toOrder(orderRequestDto),
                orderRequestMapper.toOrderDishList(orderRequestDto.getOrdersDishes()),
                token);
    }

    @Override
    public List<OrderResponseDto> findByStatus(OrderStatusRequestDto orderStatusRequestDto, int page, int itemsPerPage) {
        return orderRequestMapper.toOrderResponseList(orderServicePort.findByStatus(orderStatusRequestDto, page, itemsPerPage));
    }

}
