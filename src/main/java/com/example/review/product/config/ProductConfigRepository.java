package com.example.review.product.config;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductConfigRepository extends JpaRepository<ProductConfig, Long> {
    Optional<ProductConfig> findByProductId(Long productId);
}
