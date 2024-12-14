package com.demo.jewelry_store.entities;

import java.util.UUID;

public class User {

    UUID id;
    String name;
    String email;
    String password;
    String phone;
    String role;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String email, String password, String phone ,String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "DefaultUser{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
