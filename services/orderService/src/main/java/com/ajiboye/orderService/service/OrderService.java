package com.ajiboye.orderService.service;

import com.ajiboye.orderService.entity.OrderRequest;
import jakarta.validation.Valid;

public interface OrderService {
    void createOrder(@Valid OrderRequest request);
}
