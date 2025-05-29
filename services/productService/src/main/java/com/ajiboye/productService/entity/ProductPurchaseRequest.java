package com.ajiboye.productService.entity;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
        @NotNull(message = "Product cannot be empty")
        String productId,
        @NotNull(message = "Quantity of the product must be specified")
        int quantity
) {
}
