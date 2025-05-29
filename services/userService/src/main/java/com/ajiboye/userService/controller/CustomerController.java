package com.ajiboye.userService.controller;

import com.ajiboye.userService.entity.CustomerRequest;
import com.ajiboye.userService.entity.CustomerResponse;
import com.ajiboye.userService.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("")
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }
    @PutMapping("")
    public ResponseEntity<?> updateCustomer(@RequestBody @Valid CustomerRequest request){
        customerService.updateCustomer(request);
        return ResponseEntity.ok("Updated successfully");
    }
    @GetMapping("")
    public ResponseEntity<List<CustomerResponse>> getAllCustomer(){
        return ResponseEntity.ok(customerService.findAllCustomer());
    }
    @GetMapping("/exists/{customerId}")
    public ResponseEntity<String> customerExist(@PathVariable String customerId){
        return ResponseEntity.ok(customerService.customerExist(customerId));
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> findCustomer(@PathVariable String customerId){
        return ResponseEntity.ok(customerService.findCustomer(customerId));
    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String customerId){
        customerService.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }
}
