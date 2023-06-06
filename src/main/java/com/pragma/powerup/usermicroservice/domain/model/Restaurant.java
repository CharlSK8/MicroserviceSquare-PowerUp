package com.pragma.powerup.usermicroservice.domain.model;

public class Restaurant {
    private Long id;
    private String name;
    private Long NIT;
    private String address;
    private Long phone;
    private String urlLogo;
    private Long idUser;
    private Owner owner;

    public Restaurant(Long id, String name, Long NIT, String address, Long phone, String urlLogo, Long idUser, Owner owner) {
        this.id = id;
        this.name = name;
        this.NIT = NIT;
        this.address = address;
        this.phone = phone;
        this.urlLogo = urlLogo;
        this.idUser = idUser;
        this.owner = owner;
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

    public Long getNIT() {
        return NIT;
    }

    public void setNIT(Long NIT) {
        this.NIT = NIT;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        urlLogo = urlLogo;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
