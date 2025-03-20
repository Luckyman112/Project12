package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Разрешаем запросы к эндпоинтам, начинающимся на /api/
        registry.addMapping("/api/**")
                // Разрешаем запросы с React-приложения на http://localhost:3000
                .allowedOrigins("http://localhost:3000")
                // Разрешаем нужные HTTP-методы (GET, POST и т.д.)
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                // При необходимости можно разрешить куки
                .allowCredentials(true)
                // (опционально) время жизни кэширования preflight-запроса
                .maxAge(3600);
    }
}