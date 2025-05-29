package com.ajiboye.userService.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@Data
@Document
@Builder
@Validated
public class Address {
    private String street;
    private String houseNumber;
    private  String zipCode;
}
