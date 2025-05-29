package com.ajiboye.userService.statics;

import java.util.Map;

public record CustomErrorResponse (
        Map<String, String> errors
){
}
