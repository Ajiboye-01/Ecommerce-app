package com.ajiboye.userService.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @Email(message = "Kindly enter a valid email")
        @NotNull(message = "Email is required")
        String email,

        Address address,
        @NotNull(message = "Last name is required")
        String lastName,
        @NotNull(message = "First name is required")
        String firstName
) {
}
