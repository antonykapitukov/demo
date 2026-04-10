package com.aparts.demo.controller;

import com.aparts.demo.model.Order;
import com.aparts.demo.repository.OrderRepository;
import com.aparts.demo.repository.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Заказы", description = "API для управления заказами")
public class OrderController {
    @GetMapping
    @Operation(summary = "Получить список всех заказов (ADMIN/WORKER)")
    public void getAllOrders() {
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить заказ по ID")
    public void getOrderById(@PathVariable Long id) {
    }

    @PostMapping
    @Operation(summary = "Создать новый заказ")
    public void createOrder(@RequestBody Order order) {
        // Расчет итоговой суммы
    }

    @PatchMapping("/{id}/status")
    @Operation(summary = "Изменить статус заказа (WORKER/ADMIN)")
    public void updateOrderStatus(
            @PathVariable Long id,
            @RequestParam String status) {
    }
}