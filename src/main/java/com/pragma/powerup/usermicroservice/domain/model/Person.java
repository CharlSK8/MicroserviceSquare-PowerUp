package com.pragma.powerup.usermicroservice.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private Long id;
    private String name;
    private String surname;
    private String mail;
    private String phone;
    private String address;
    private String idDniType;
    private Long dniNumber;
    private String idPersonType;
    private String password;

    @JsonCreator
    public Person(@JsonProperty("id") Long id,
                  @JsonProperty("name") String name,
                  @JsonProperty("surname") String surname,
                  @JsonProperty("mail") String mail,
                  @JsonProperty("phone") String phone,
                  @JsonProperty("address") String address,
                  @JsonProperty("idDniType") String idDniType,
                  @JsonProperty("dniNumber") Long dniNumber,
                  @JsonProperty("idPersonType") String idPersonType,
                  @JsonProperty("password") String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
        this.idDniType = idDniType;
        this.dniNumber = dniNumber;
        this.idPersonType = idPersonType;
        this.password = password;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdDniType() {
        return idDniType;
    }

    public void setIdDniType(String idDniType) {
        this.idDniType = idDniType;
    }

    public Long getDniNumber() {
        return dniNumber;
    }

    public void setDniNumber(Long dniNumber) {
        this.dniNumber = dniNumber;
    }

    public String getIdPersonType() {
        return idPersonType;
    }

    public void setIdPersonType(String idPersonType) {
        this.idPersonType = idPersonType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
