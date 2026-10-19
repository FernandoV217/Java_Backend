package com.erp.store.controller;

import com.erp.store.entity.Product;
import com.erp.store.entity.Product;
import com.erp.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {
        List<Product> productsList = productService.allProducts();
        return ResponseEntity.ok(productsList);
    }
}
