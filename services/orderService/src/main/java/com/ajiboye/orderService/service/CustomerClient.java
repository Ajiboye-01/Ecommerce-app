package com.ajiboye.orderService.service;

import com.ajiboye.orderService.entity.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "customerService", url = "application.config.customer-url")
public interface CustomerClient {
    @GetMapping("/{customerId}")
    Optional<CustomerResponse> findCustomerById(@PathVariable("customerId") String customerId);
}
