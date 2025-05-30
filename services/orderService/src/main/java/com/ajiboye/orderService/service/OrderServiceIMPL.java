package com.ajiboye.orderService.service;

import com.ajiboye.orderService.entity.OrderRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceIMPL implements OrderService{
    private final CustomerClient customerClient;
    @Override
    public void createOrder(OrderRequest request) {
        /*
        * First check for customer
        * purchase the product from product microservice
        * persist the order
        * persist the order lines
        * start payment process
        * send order confirmation notification to the notification service using kafka
         */

    }
}
