package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  // Двунаправленная связь: один User имеет один Profile.
  // Аннотация @JsonManagedReference предотвращает рекурсию при сериализации (с обратной стороны Profile).
  @OneToOne(mappedBy = "user")
  @JsonManagedReference
  private Profile profile;

  // Конструктор по умолчанию (обязателен для JPA)
  public User() {
  }

  // Дополнительный конструктор для удобства
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

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }
}


