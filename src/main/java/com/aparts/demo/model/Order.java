package com.aparts.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Schema(description = "Модель заказа")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Номер заказа", example = "1001")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Статус заказа", example = "NEW")
    private OrderStatus status;

    @Schema(description = "Адрес доставки", example = "г. Москва, ул. Пушкина, д. 10, кв. 5")
    private String deliveryAddress;

    @Schema(description = "Способ оплаты", example = "CARD")
    private String paymentMethod;

    @Column(precision = 10, scale = 2)
    @Schema(description = "Итоговая сумма заказа", example = "8750.00")
    private BigDecimal totalAmount;

    @Column(name = "created_at")
    @Schema(description = "Дата и время оформления заказа")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;
}

enum OrderStatus {
    NEW, PROCESSING, SHIPPED, DELIVERED, CANCELLED
}