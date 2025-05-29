package com.ajiboye.userService.service;

import com.ajiboye.userService.entity.Customer;
import com.ajiboye.userService.entity.CustomerMapper;
import com.ajiboye.userService.entity.CustomerRequest;
import com.ajiboye.userService.entity.CustomerResponse;
import com.ajiboye.userService.repository.CustomerRepository;
import com.ajiboye.userService.statics.CustomerException;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceIMPL implements CustomerService{
    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    @Override
    @Transactional
    public String createCustomer(CustomerRequest request) {
        var customer = customerRepository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    @Override
    public void updateCustomer(CustomerRequest request) {
        var customer = customerRepository.findById(request.id()).
                orElseThrow(() -> new CustomerException("Customer not found"));
        mergeCustomer(customer, request);
        customerRepository.save(customer);
    }

    @Override
    public List<CustomerResponse> findAllCustomer() {
        return customerRepository.findAll().stream().map(mapper::fromCustomer).collect(Collectors.toList());
    }

    @Override
    public String customerExist(String customerId) {
        var check = customerRepository.existsById(customerId);
        if (check){
            return "Customer Found";
        }else {
            return "Customer not Found";
        }
    }

    @Override
    public CustomerResponse findCustomer(String customerId) {
        var customer = customerRepository.findById(customerId);
        return customer.map(mapper::fromCustomer).orElseThrow(() -> new CustomerException("Customer not Found"));
    }

    @Override
    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstName())){
            customer.setFirstName(request.firstName());
        }
        if (StringUtils.isNotBlank(request.lastName())){
            customer.setFirstName(request.lastName());
        }
        if (StringUtils.isNotBlank(request.email())){
            customer.setFirstName(request.email());
        }
        if (request.address() != null){
            customer.setAddress(request.address());
        }
    }
}
