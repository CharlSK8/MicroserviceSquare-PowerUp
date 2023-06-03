package com.pragma.powerup.usermicroservice.domain.model;

import java.time.LocalDate;

public class Owner {
    private Long id;
    private String name;
    private String surname;
    private Long dniNumber;
    private String phone;
    private LocalDate birthOfDate;
    private String mail;
    private String password;
    private Role role;

    public Owner(Long id, String name, String surname, Long dniNumber, String phone, LocalDate birthOfDate, String mail, String password, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dniNumber = dniNumber;
        this.phone = phone;
        this.birthOfDate = birthOfDate;
        this.mail = mail;
        this.password = password;
        this.role = role;
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

    public Long getDniNumber() {
        return dniNumber;
    }

    public void setDniNumber(Long dniNumber) {
        this.dniNumber = dniNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(LocalDate birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}