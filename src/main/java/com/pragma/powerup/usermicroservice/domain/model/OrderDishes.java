package com.pragma.powerup.usermicroservice.domain.model;

public class OrderDishes {
    private Long id;
    private Order order;
    private Dish dish;
    private int amount;

    public OrderDishes(Long id, Order order, Dish dish, int amount) {
        this.id = id;
        this.order = order;
        this.dish = dish;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
