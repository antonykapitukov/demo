package com.aparts.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
@Schema(description = "Пользователь системы")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Имя пользователя", example = "Иван")
    private String firstName;

    @Column(nullable = false)
    @Schema(description = "Фамилия", example = "Иванов")
    private String lastName;

    @Column(nullable = false, unique = true)
    @Schema(description = "Email (логин)", example = "user@mail.ru")
    private String email;

    @Column(nullable = false)
    @Schema(description = "Пароль (хранится в хэшированном виде)")
    private String password;

    @Schema(description = "Контактный телефон", example = "+7 (999) 123-45-67")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Роль пользователя", example = "USER")
    private Role role = Role.USER;
}