package com.ajiboye.productService.statics;

import java.util.Map;

public record CustomErrorResponse(
        Map<String, String> message
) {
}
