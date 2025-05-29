package com.ajiboye.productService.services;

import com.ajiboye.productService.entity.*;
import jakarta.validation.Valid;

import java.util.List;

public interface ProductService {
    String createProduct(@Valid ProductRequest request);

    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> requests);

    ProductResponse findById(String id);

    List<ProductResponse> findAll();
}
