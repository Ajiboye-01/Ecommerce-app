package com.ajiboye.productService.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private int availableQuantity;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
