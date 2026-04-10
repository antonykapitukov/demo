package com.aparts.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер аутентификации
 */
@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Аутентификация", description = "Методы для регистрации, входа и управления токенами")
public class AuthController {

    @Operation(summary = "Регистрация нового пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Пользователь создан"),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации", content = @Content),
            @ApiResponse(responseCode = "409", description = "Пользователь уже существует", content = @Content)
    })
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        // TODO: реализация
        return null;
    }

    @Operation(summary = "Вход в систему")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный вход",
                    content = @Content(schema = @Schema(implementation = AuthResponse.class))),
            @ApiResponse(responseCode = "401", description = "Неверные учетные данные", content = @Content)
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        // TODO: реализация
        return null;
    }

    @Operation(summary = "Обновление токена доступа")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Токены обновлены",
                    content = @Content(schema = @Schema(implementation = AuthResponse.class))),
            @ApiResponse(responseCode = "401", description = "Refresh токен недействителен", content = @Content)
    })
    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody RefreshTokenRequest request) {
        // TODO: реализация
        return null;
    }

    @Operation(summary = "Выход из системы")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный выход"),
            @ApiResponse(responseCode = "401", description = "Не авторизован", content = @Content)
    })
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@Parameter(hidden = true) @RequestHeader("Authorization") String authHeader) {
        // TODO: реализация
        return null;
    }

    @Operation(summary = "Подтверждение email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email подтвержден"),
            @ApiResponse(responseCode = "400", description = "Неверный токен", content = @Content)
    })
    @GetMapping("/verify-email")
    public ResponseEntity<?> verifyEmail(@Parameter(description = "Токен подтверждения") @RequestParam String token) {
        // TODO: реализация
        return null;
    }

    @Operation(summary = "Запрос на восстановление пароля")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Инструкция отправлена на email"),
            @ApiResponse(responseCode = "404", description = "Email не найден", content = @Content)
    })
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        // TODO: реализация
        return null;
    }

    @Operation(summary = "Сброс пароля")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пароль изменен"),
            @ApiResponse(responseCode = "400", description = "Неверный токен", content = @Content)
    })
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
        // TODO: реализация
        return null;
    }

    // ----- Вспомогательные DTO классы (в этом же файле или отдельных) -----

    @Schema(description = "Запрос на регистрацию")
    public static class RegisterRequest {
        @Schema(description = "Имя пользователя", example = "ivan_ivanov", required = true)
        public String username;
        @Schema(description = "Email", example = "ivan@mail.ru", required = true)
        public String email;
        @Schema(description = "Пароль", example = "Password123!", required = true)
        public String password;
    }

    @Schema(description = "Запрос на вход")
    public static class LoginRequest {
        @Schema(description = "Email или имя пользователя", example = "ivan@mail.ru", required = true)
        public String login;
        @Schema(description = "Пароль", example = "Password123!", required = true)
        public String password;
    }

    @Schema(description = "Запрос на обновление токена")
    public static class RefreshTokenRequest {
        @Schema(description = "Refresh токен", example = "550e8400-e29b-41d4-a716-446655440000", required = true)
        public String refreshToken;
    }

    @Schema(description = "Ответ с токенами")
    public static class AuthResponse {
        @Schema(description = "Access токен", example = "eyJhbGciOiJIUzI1NiJ9...")
        public String accessToken;
        @Schema(description = "Refresh токен", example = "550e8400-e29b-41d4-a716-446655440000")
        public String refreshToken;
        @Schema(description = "Тип токена", example = "Bearer")
        public String tokenType;
    }

    @Schema(description = "Запрос на восстановление пароля")
    public static class ForgotPasswordRequest {
        @Schema(description = "Email пользователя", example = "ivan@mail.ru", required = true)
        public String email;
    }

    @Schema(description = "Запрос на сброс пароля")
    public static class ResetPasswordRequest {
        @Schema(description = "Токен сброса", example = "abc123...", required = true)
        public String token;
        @Schema(description = "Новый пароль", example = "NewPassword123!", required = true)
        public String newPassword;
    }
}