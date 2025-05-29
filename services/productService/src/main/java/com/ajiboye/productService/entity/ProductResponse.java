package com.ajiboye.productService.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductResponse(
        String id,
        String name,
        String description,
        BigDecimal price,
        int availableQuantity,
        String categoryId,
        String categoryName,
        String categoryDescription
) {
}
