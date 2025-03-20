package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")  // Переименовали таблицу в "users"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    public User() {}

    public User(String username) {
        this.username = username;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
