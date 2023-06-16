package com.pragma.powerup.usermicroservice.domain.model;

import java.time.LocalDateTime;

public class Order {

    private Long id;
    private String status;
    private LocalDateTime startDate;
    private Restaurant restaurant;
    private Long ownerId;

    public Order() {
    }

    public Order(Long id, String status, LocalDateTime startDate, Restaurant restaurant, Long ownerId) {
        this.id = id;
        this.status = status;
        this.startDate = startDate;
        this.restaurant = restaurant;
        this.ownerId = ownerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
