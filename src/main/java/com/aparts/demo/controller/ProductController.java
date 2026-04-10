package com.aparts.demo.controller;

import com.aparts.demo.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Товары", description = "API для работы с каталогом товаров")
public class ProductController {


    @GetMapping
    @Operation(summary = "Получить список всех товаров",
            description = "Возвращает полный список товаров из каталога")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение списка")
    })
    public void getAllProducts() {
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить товар по ID",
            description = "Возвращает детальную информацию о конкретном товаре")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товар найден"),
            @ApiResponse(responseCode = "404", description = "Товар не найден")
    })
    public void getProductById(
            @Parameter(description = "ID товара", example = "1")
            @PathVariable Long id) {
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Получить товары по категории")
    public void getProductsByCategory(
            @Parameter(description = "ID категории")
            @PathVariable Long categoryId) {
    }

    @GetMapping("/search")
    @Operation(summary = "Поиск товаров по названию")
    public void searchProducts(
            @Parameter(description = "Поисковый запрос", example = "фильтр")
            @RequestParam String query) {
    }

    @PostMapping
    @Operation(summary = "Добавить новый товар (ADMIN)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Товар создан"),
            @ApiResponse(responseCode = "403", description = "Доступ запрещен")
    })
    public void createProduct(@RequestBody Product product) {
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить информацию о товаре (ADMIN)")
    public void updateProduct(
            @PathVariable Long id,
            @RequestBody Product product) {
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить товар (ADMIN)")
    public void deleteProduct(@PathVariable Long id) {
    }
}