package com.pragma.powerup.usermicroservice.domain.model;

public class Dish {

    private Long id;
    private String name;
    private String description;
    private String price;
    private String urlImage;
    private boolean status;
    private Restaurant restaurant;
    private Category category;

    public Dish(Long id, String name, String description, String price, String urlImage, boolean status, Restaurant restaurant, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.urlImage = urlImage;
        this.status = status;
        this.restaurant = restaurant;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
