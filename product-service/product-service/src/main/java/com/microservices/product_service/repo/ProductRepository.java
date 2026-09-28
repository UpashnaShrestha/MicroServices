package com.microservices.product_service.repo;

import com.microservices.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Upashna
 * Created: 9/28/2026
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
}
