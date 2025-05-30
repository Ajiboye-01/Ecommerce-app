package com.ajiboye.orderService.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        String id,
        String reference,
        @Positive(message = "order amount should be positive")
        BigDecimal amount,
        @NotNull(message = "Kindly select the payment method")
        PaymentMethod paymentMethod,
        @NotNull(message = "A customer must make order")
        @NotBlank(message = "A customer must make order")
        @NotEmpty(message = "A customer must make order")
        String customerId,
        @NotEmpty(message = "You need t make a purchase of at-least one product")
        List<PurchaseRequest> products
) {
}
