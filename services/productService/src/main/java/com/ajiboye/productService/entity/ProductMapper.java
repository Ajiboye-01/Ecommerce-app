package com.ajiboye.productService.entity;

import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.id())
                .description(request.description())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .category(Category.builder()
                        .id(request.id())
                        .build())
                .name(request.name())
                .build();
    }
    public ProductResponse toProductResponse(Product product){
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getAvailableQuantity(),
                product.getCategory().getId(),
                product.getCategory().getDescription(),
                product.getCategory().getName()
        );
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, int quantity){
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
