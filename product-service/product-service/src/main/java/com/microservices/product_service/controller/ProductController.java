package com.microservices.product_service.controller;

import com.microservices.product_service.dto.ProductRequestDto;
import com.microservices.product_service.dto.ProductResponseDto;
import com.microservices.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Upashna
 * Created: 9/28/2026
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public ProductResponseDto createProduct(
            @RequestBody ProductRequestDto request) {

        return productService.createProduct(request);
    }

    @GetMapping
    public List<ProductResponseDto> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(
            @PathVariable Long id) {

        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDto updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequestDto request) {

        return productService.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return "Product deleted successfully";
    }
    
    @PatchMapping("/{id}/stock")
    public ProductResponseDto updateStock(
            @PathVariable Long id,
            @RequestParam Integer quantity) {

        return productService.updateStock(id, quantity);
    }
}
