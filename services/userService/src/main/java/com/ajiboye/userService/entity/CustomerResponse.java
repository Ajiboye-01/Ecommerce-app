package com.ajiboye.userService.entity;

public record CustomerResponse(
        String id,
        String email,
        Address address,
        String lastName,
        String firstName
) {
}
