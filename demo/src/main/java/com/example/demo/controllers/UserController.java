package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")  // все методы внутри будут доступны по адресу /api/users
public class UserController {

    private final UserRepository userRepository;

    // Конструктор для внедрения репозитория
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Обработчик GET-запроса на /api/users, возвращает список пользователей
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Обработчик POST-запроса для создания нового пользователя
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
