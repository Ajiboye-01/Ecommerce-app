package com.ajiboye.userService.repository;

import com.ajiboye.userService.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
