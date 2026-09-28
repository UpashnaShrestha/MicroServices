package com.microservices.product_service.service;

import com.microservices.product_service.dto.ProductRequestDto;
import com.microservices.product_service.dto.ProductResponseDto;

import java.util.List;

/**
 * Author: Upashna
 * Created: 9/28/2026
 */
public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto request);
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto getProductById(Long id);
    ProductResponseDto updateProduct(Long id, ProductRequestDto request);
    void deleteProduct(Long id);
    ProductResponseDto updateStock(Long id, Integer quantity);
}
