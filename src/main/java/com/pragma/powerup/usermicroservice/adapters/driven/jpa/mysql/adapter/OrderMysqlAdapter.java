package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IOrderEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IOrderRepository;
import com.pragma.powerup.usermicroservice.domain.model.Order;
import com.pragma.powerup.usermicroservice.domain.spi.IOrderPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class OrderMysqlAdapter implements IOrderPersistencePort {
    private final IOrderRepository orderRepository;
    private final IOrderEntityMapper orderEntityMapper;
    @Override
    public Order saveOrder(Order order) {
        return orderEntityMapper.toOrder(orderRepository.save(orderEntityMapper.toEntity(order)));
    }

    @Override
    public boolean existsOrderInProcessByOwnerId(Long idOwner) {
        return orderRepository.existsOrdersInProcessByOwnerId(idOwner);
    }

    @Override
    public List<Order> findByStatus(String status, int page, int itemsPerPage) {
        Pageable pageRequest = PageRequest.of(page, itemsPerPage);
        return orderEntityMapper.toOrderList(orderRepository.findByStatus(status, pageRequest).getContent());
    }
}
