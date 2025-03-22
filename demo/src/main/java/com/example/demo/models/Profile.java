package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String bio;

  // Связь "один к одному" с User. Profile – владелец связи (хранит внешний ключ user_id).
  // @JsonBackReference предотвращает повторную сериализацию user при сериализации Profile.
  @OneToOne
  @JoinColumn(name = "user_id")
  @JsonBackReference
  private User user;

  // Конструктор по умолчанию (обязателен для JPA)
  public Profile() {
  }

  // Дополнительный конструктор
  public Profile(String bio, User user) {
    this.bio = bio;
    this.user = user;
  }

  // Геттеры и сеттеры
  public Long getId() {
    return id;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
