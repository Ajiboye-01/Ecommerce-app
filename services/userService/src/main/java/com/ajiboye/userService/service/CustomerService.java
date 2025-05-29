package com.ajiboye.userService.service;

import com.ajiboye.userService.entity.CustomerRequest;
import com.ajiboye.userService.entity.CustomerResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface CustomerService {
    String createCustomer(@Valid CustomerRequest request);

    void updateCustomer(@Valid CustomerRequest request);

    List<CustomerResponse> findAllCustomer();

    String customerExist(String customerId);

    CustomerResponse findCustomer(String customerId);

    void deleteCustomer(String customerId);
}
