package com.ajiboye.userService.statics;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerException extends RuntimeException {
    private final String message;
}
