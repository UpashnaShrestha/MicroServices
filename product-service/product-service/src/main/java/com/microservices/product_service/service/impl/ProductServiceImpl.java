package com.microservices.product_service.service.impl;

import com.microservices.product_service.dto.ProductRequestDto;
import com.microservices.product_service.dto.ProductResponseDto;
import com.microservices.product_service.entity.Product;
import com.microservices.product_service.mapper.ProductMapper;
import com.microservices.product_service.repo.ProductRepository;
import com.microservices.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Upashna
 * Created: 9/28/2026
 */
@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.toDto(product);
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        Product updatedProduct = productRepository.save(product);
        return productMapper.toDto(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }

    @Override
    public ProductResponseDto updateStock(Long id, Integer quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getStock() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }
        product.setStock(product.getStock() - quantity);
        Product updatedProduct = productRepository.save(product);
        return productMapper.toDto(updatedProduct);
    }
}
