package com.aparts.demo.repository;

import com.aparts.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByArticleContainingIgnoreCase(String article);
    List<Product> findByBrand(String brand);
    List<Product> findByPriceBetween(java.math.BigDecimal min, java.math.BigDecimal max);
}