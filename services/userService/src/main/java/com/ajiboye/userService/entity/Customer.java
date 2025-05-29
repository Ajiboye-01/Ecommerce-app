package com.ajiboye.userService.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Builder
public class Customer {
    private String id;
    private String keyCloakId;
    private String email;
    private Address address;
    private String firstName;
    private String lastName;
}
