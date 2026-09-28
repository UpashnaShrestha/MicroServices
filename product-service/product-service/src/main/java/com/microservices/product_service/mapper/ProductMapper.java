package com.microservices.product_service.mapper;

import com.microservices.product_service.dto.ProductResponseDto;
import com.microservices.product_service.entity.Product;
import org.springframework.stereotype.Component;

/**
 * Author: Upashna
 * Created: 9/28/2026
 */
@Component
public class ProductMapper {
    public ProductResponseDto toDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setProductId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        return dto;
    }
}
