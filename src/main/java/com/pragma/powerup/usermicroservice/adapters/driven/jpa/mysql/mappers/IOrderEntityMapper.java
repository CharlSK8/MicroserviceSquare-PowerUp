package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.OrderEntity;
import com.pragma.powerup.usermicroservice.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderEntityMapper {

    @Mapping(target = "restaurantEntity.id", source = "restaurant.id")
    //@Mapping(target = "ordersDishes.dishEntity.id", source = "ordersDishes.dish.id")
    OrderEntity toEntity(Order order);

    @Mapping(target = "restaurant.id", source = "restaurantEntity.id")
    Order toOrder(OrderEntity orderEntity);
}
