package com.ajiboye.productService.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        String id,
        @NotNull(message = "Product name is required")
        String name,
        @NotNull(message = "Product Description is required")
        String description,
        @Positive(message = "Kindly input a positive number")
        BigDecimal price,
        @Positive(message = "Kindly input a positive number")
        int availableQuantity,
        @NotNull(message = "Product Description is required")
        String categoryId
) {
}
