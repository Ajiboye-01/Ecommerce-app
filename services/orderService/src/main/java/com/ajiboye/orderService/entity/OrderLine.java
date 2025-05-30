package com.ajiboye.orderService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class OrderLine {
    private String id;
    @ManyToOne
    private Order order;
    private String productId;
    private Integer quantity;
}
