package com.pragma.powerup.usermicroservice.configuration;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.*;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.*;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.*;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl.OwnerHandlerImpl;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IOwnerResponseMapper;
import com.pragma.powerup.usermicroservice.domain.api.*;
import com.pragma.powerup.usermicroservice.domain.spi.*;
import com.pragma.powerup.usermicroservice.domain.usecase.*;
import com.pragma.powerup.usermicroservice.domain.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IRoleRepository roleRepository;
    private final IPersonRepository personRepository;
    private final IUserRepository userRepository;
    private final IRestaurantRepository restaurantRepository;
    private final ICategoryRepository categoryRepository;
    private final IOrderRepository orderRepository;
    private final IOrderDishRepository orderDishRepository;
    private final IRoleEntityMapper roleEntityMapper;
    private final IUserEntityMapper userEntityMapper;
    private final IRestaurantEntityMapper restaurantEntityMapper;
    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;
    private final IOwnerResponseMapper ownerResponseMapper;
    private final IOrderEntityMapper orderEntityMapper;
    private final IOrderDishEntityMapper orderDishEntityMapper;
    private final OwnerHandlerImpl ownerHandlerImpl;
   // private final JwtUtils jwtUtils;

    @Bean
    public IRoleServicePort roleServicePort() {
        return new RoleUseCase(rolePersistencePort());
    }
    @Bean
    public IRolePersistencePort rolePersistencePort() {
        return new RoleMysqlAdapter(roleRepository, roleEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }
    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserMysqlAdapter(userRepository, personRepository, roleRepository, userEntityMapper);
    }
    @Bean
    public IRestaurantServicePort restaurantServicePort(){
        return new RestaurantUseCase(restaurantPersistencePort(), ownerServicePort());
    }
    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort(){
        return new RestaurantMysqlAdapter(restaurantRepository,restaurantEntityMapper);
    }
    @Bean
    public IDishServicePort dishServicePort(){
        return new DishUseCase(dishPersistencePort(), ownerServicePort(), restaurantPersistencePort(), categoryPersistencePort());
    }
    @Bean
    public IDishPersistencePort dishPersistencePort(){
        return new DishMysqlAdapter(dishRepository, dishEntityMapper);
    }
    @Bean
    public IOwnerServicePort ownerServicePort(){
        return new OwnerUseCase(ownerHandlerImpl,ownerResponseMapper);
    }
    @Bean
    public ICategoryPersistencePort categoryPersistencePort(){
        return  new CategoryMysqlAdapter(categoryRepository);
    }

    @Bean
    public IOrderPersistencePort orderPersistencePort(){
        return new OrderMysqlAdapter(orderRepository, orderEntityMapper);
    }
    @Bean
    public IOrderServicePort orderServicePort(){
        return new OrderUseCase(jwtUtilsBean(), orderPersistencePort(), orderDishPersistencePort(), dishPersistencePort(), restaurantPersistencePort());
    }
    @Bean
    public IOrderDishPersistencePort orderDishPersistencePort(){
        return new OrderDishMysqlAdapter(orderDishRepository, orderDishEntityMapper);
    }
    @Bean
    public JwtUtils jwtUtilsBean(){
        return new JwtUtils(ownerServicePort());
    }

}
