package com.aparts.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@Schema(description = "Модель товара (автозапчасти)")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Уникальный идентификатор товара", example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Наименование запчасти", example = "Масляный фильтр MANN")
    private String name;

    @Column(unique = true)
    @Schema(description = "Артикул производителя", example = "HU 719/8 x")
    private String article;

    @Column(length = 2000)
    @Schema(description = "Подробное описание товара")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    @Schema(description = "Цена в рублях", example = "1250.00")
    private BigDecimal price;

    @Column(nullable = false)
    @Schema(description = "Количество на складе", example = "15")
    private Integer stockQuantity;

    @Schema(description = "Бренд производителя", example = "MANN-FILTER")
    private String brand;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @Schema(description = "Категория товара")
    private Category category;

    public void setId(Long id) {
    }
}