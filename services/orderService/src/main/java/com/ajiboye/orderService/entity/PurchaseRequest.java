package com.ajiboye.orderService.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(
        @NotNull(message = "A product is mandatory")
        String productId,
        @Positive(message = "kindly select the quantity of product you want to purchase")
        Integer quantity

) {
}
