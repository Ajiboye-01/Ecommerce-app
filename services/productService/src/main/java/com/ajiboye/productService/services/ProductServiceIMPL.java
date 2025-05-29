package com.ajiboye.productService.services;

import com.ajiboye.productService.entity.*;
import com.ajiboye.productService.repository.ProductRepo;
import com.ajiboye.productService.statics.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceIMPL implements ProductService{
    private final ProductRepo repository;
    private final ProductMapper productMapper;
    @Override
    public String createProduct(ProductRequest request) {
        var product = productMapper.toProduct(request);
        repository.save(product);
        return "Product saved successfully";
    }

    @Override
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> requests) {
        //I first extract the ID of each product
        var productsId = requests.stream()
                //using the product id from product purchase request
                .map(ProductPurchaseRequest::productId)
                .toList();

        /*
         I need to check if the product is in the database by querying it with the product id
         so that i can block any purchase request that contains one or more id that is not in the database
         */
        var storedProduct = repository.findAllByIdInOrderById(productsId);
        if (productsId.size() != storedProduct.size()){
            throw new ProductPurchaseException("One or more products does not exist");
        }

        var storedRequest = requests.stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();

        /*
        This method is for purchasing product
        * This loop over storedProduct
        * After looping over the stored product
        * We get the stored product and stored request
        * if the available quantity in the database is less than the request quantity
         */
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storedProduct.size(); i++) {
            var product = storedProduct.get(i);
            var productRequest = storedRequest.get(i);
            if (product.getAvailableQuantity() < productRequest.quantity()){
                throw new ProductPurchaseException("Insufficient stock quantity for product");
            }

            /*
            In summary, this check the available quantity of stored product in the database by querying the
            product via the product purchase request id that is being mapped to stored product and update the product
            accordingly in terms of quantity
             */
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            repository.save(product);
            purchasedProducts.add(productMapper.toProductPurchaseResponse(product, productRequest.quantity()));
        }
        return purchasedProducts;
    }

    @Override
    public ProductResponse findById(String id) {
        return repository.findById(id)
                .map(productMapper::toProductResponse)
                .orElseThrow(()-> new EntityNotFoundException("Product not found"));
    }

    @Override
    public List<ProductResponse> findAll() {
        return repository.findAll().stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
