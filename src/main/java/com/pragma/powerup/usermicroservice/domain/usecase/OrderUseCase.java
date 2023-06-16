package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.OrderStatusRequestDto;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.domain.api.IOrderServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.DishNotFoundDbException;
import com.pragma.powerup.usermicroservice.domain.exceptions.OrderAlreadyInProcessException;
import com.pragma.powerup.usermicroservice.domain.exceptions.OrderNullException;
import com.pragma.powerup.usermicroservice.domain.exceptions.RestaurantNotFoundException;
import com.pragma.powerup.usermicroservice.domain.model.Order;
import com.pragma.powerup.usermicroservice.domain.model.OrderDishes;
import com.pragma.powerup.usermicroservice.domain.spi.IDishPersistencePort;
import com.pragma.powerup.usermicroservice.domain.spi.IOrderDishPersistencePort;
import com.pragma.powerup.usermicroservice.domain.spi.IOrderPersistencePort;
import com.pragma.powerup.usermicroservice.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.usermicroservice.domain.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;


public class OrderUseCase implements IOrderServicePort {

    @Autowired
    private final JwtUtils jwtUtils;

    private final IOrderPersistencePort orderPersistencePort;
    private final IOrderDishPersistencePort orderDishPersistencePort;
    private final IDishPersistencePort dishPersistencePort;
    private final IRestaurantPersistencePort restaurantPersistencePort;

    public OrderUseCase(JwtUtils jwtUtils, IOrderPersistencePort orderPersistencePort, IOrderDishPersistencePort orderDishPersistencePort, IDishPersistencePort dishPersistencePort, IRestaurantPersistencePort restaurantPersistencePort) {
        this.jwtUtils = jwtUtils;
        this.orderPersistencePort = orderPersistencePort;
        this.orderDishPersistencePort = orderDishPersistencePort;
        this.dishPersistencePort = dishPersistencePort;
        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public void saveOrder(Order order, List<OrderDishes> dishList, String token) {
        Long idUser = jwtUtils.idFromToken(token);
        if (orderPersistencePort.existsOrderInProcessByOwnerId(idUser)) {
            throw new OrderAlreadyInProcessException();
        }
        validateRestaurant(order.getRestaurant().getId());
        validateDish(dishList);
        order.setOwnerId(idUser);
        order.setStatus(Constants.ORDER_STATUS_PENDING);
        order.setStartDate(LocalDateTime.now());
        Order orderPersistence = orderPersistencePort.saveOrder(order);
        saveOrderDish(dishList, orderPersistence);
    }

    @Override
    public List<Order> findByStatus(OrderStatusRequestDto orderStatusRequestDto, int page, int itemsPerPage) {
        List<Order> orderList = orderPersistencePort.findByStatus(orderStatusRequestDto.getStatus(), page, itemsPerPage);
        if(orderList.isEmpty()){
            throw new OrderNullException();
        }
        return orderList ;
    }

    public void saveOrderDish(List<OrderDishes> orderDish, Order order){
        for (OrderDishes orderDishes: orderDish) {
            orderDishes.setOrder(order);
            orderDishPersistencePort.saveOrderDish(orderDishes);
        }

    }

    public void validateDish(List<OrderDishes> orderDish){
        for (OrderDishes orderDishes: orderDish) {
            if (!dishPersistencePort.existsById(orderDishes.getDish().getId())) {
                throw new DishNotFoundDbException();
            }
        }
    }
    public void validateRestaurant(Long id){
        if(!restaurantPersistencePort.existsById(id)){
            throw new RestaurantNotFoundException();
        }
    }

}
