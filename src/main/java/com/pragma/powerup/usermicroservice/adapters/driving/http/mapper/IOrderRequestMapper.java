package com.pragma.powerup.usermicroservice.adapters.driving.http.mapper;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.DishOrderRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.OrderRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.OrderResponseDto;
import com.pragma.powerup.usermicroservice.domain.model.Order;
import com.pragma.powerup.usermicroservice.domain.model.OrderDishes;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderRequestMapper {

    @Mapping(target = "restaurant.id", source = "restaurantId")
    Order toOrder(OrderRequestDto orderRequestDto);

    @Mapping(target = "dish.id", source = "dishId")
    OrderDishes toOrderDishes(DishOrderRequestDto dishOrderRequestDto);

    List<OrderDishes> toOrderDishList(List<DishOrderRequestDto> orderDishRequestDtoList);
    List<OrderResponseDto> toOrderResponseList(List<Order> orderResponseDto);

}
