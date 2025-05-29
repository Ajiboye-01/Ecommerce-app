package com.ajiboye.userService.entity;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toCustomer(@NotNull CustomerRequest request) {
        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getLastName(),
                customer.getFirstName()
        );
    }
}
