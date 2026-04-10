package com.aparts.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Data
@Schema(description = "Позиция в заказе")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @Schema(description = "Товар")
    private Product product;

    @Schema(description = "Количество", example = "2")
    private Integer quantity;

    @Schema(description = "Цена за единицу на момент заказа", example = "1250.00")
    private BigDecimal price;
}