package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDateTime startDate;
    @ManyToOne
    @JoinColumn(name = "restaurant_entity_id")
    private RestaurantEntity restaurantEntity;
    @Column(name = "owner_id")
    private Long ownerId;
    @Column(name = "employee_id")
    private Long employeeId;
    @OneToMany(mappedBy = "orderEntity")
    private List<OrderDishEntity> orderDishes;
}
