package com.ajiboye.productService.entity;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
        String productId,
        String name,
        String description,
        BigDecimal price,
        Integer quantity
) {
}
