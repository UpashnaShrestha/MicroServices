package com.microservices.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Upashna
 * Created: 9/28/2026
 */
@AllArgsConstructor
@Data
@NoArgsConstructor

public class ProductRequestDto {
    private String name;
    private Double price;
    private Integer stock;
}
