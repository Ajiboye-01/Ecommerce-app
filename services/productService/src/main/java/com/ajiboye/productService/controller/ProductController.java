package com.ajiboye.productService.controller;

import com.ajiboye.productService.entity.ProductPurchaseRequest;
import com.ajiboye.productService.entity.ProductPurchaseResponse;
import com.ajiboye.productService.entity.ProductRequest;
import com.ajiboye.productService.entity.ProductResponse;
import com.ajiboye.productService.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<String> createProduct(@RequestBody @Valid ProductRequest request){
        productService.createProduct(request);
        return ResponseEntity.ok("Success");
    }
    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProduct(
            @RequestBody List<ProductPurchaseRequest> requests){
        return ResponseEntity.ok(productService.purchaseProducts(requests));
    }
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getById(@PathVariable String productId){
        return ResponseEntity.ok(productService.findById(productId));
    }
    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getAllById(){
        return ResponseEntity.ok(productService.findAll());
    }
}
