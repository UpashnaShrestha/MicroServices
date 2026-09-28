package com.microservices.order_service.service.impl;

import com.microservices.order_service.dto.*;
import com.microservices.order_service.entity.Order;
import com.microservices.order_service.mapper.OrderMapper;
import com.microservices.order_service.repo.OrderRepository;
import com.microservices.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;


/**
 * Author: Upashna
 * Created: 9/25/2026
 */

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final RestClient restClient;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto request) {
        UserResponseDto user;
        ProductResponseDto product;
        try {
             user = restClient.get()
                    .uri("http://localhost:8081/api/users/" + request.getUserId())
                    .retrieve()
                    .body(UserResponseDto.class);
        } catch (Exception e) {
            throw new RuntimeException("User not found with id: " + request.getUserId());
        }
        try {
            product = restClient.get()
                    .uri("http://localhost:8082/api/products/" + request.getProductId())
                    .retrieve()
                    .body(ProductResponseDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Product not found with id: " + request.getProductId());
        }
            if (product.getStock() < request.getQuantity()) {
                throw new RuntimeException("Insufficient product stock");
            }
            restClient.patch()
                    .uri("http://localhost:8082/api/products/"
                            + request.getProductId()
                            + "/stock?quantity="
                            + request.getQuantity())
                    .retrieve()
                    .body(ProductResponseDto.class);

        Order order = new Order();
        order.setUserId(user.getUserId());
        order.setProductId(product.getProductId());
        double totalPrice = product.getPrice() * request.getQuantity();
        order.setTotalPrice(totalPrice);
        order.setQuantity(request.getQuantity());
        order.setStatus("PENDING");

        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Override
    public OrderResponseDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.toDto(order);
    }

    @Override
    public List<OrderResponseDto> getOrdersByUserId(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream()
                .map(order -> {ProductResponseDto product = restClient.get()
                        .uri("http://localhost:8082/api/products/"+order.getProductId())
                        .retrieve()
                        .body(ProductResponseDto.class);
                    OrderResponseDto orderResponseDto = orderMapper.toDto(order);
                    orderResponseDto.setProductName(product.getName());
                    return orderResponseDto;
                })
                .toList();
    }

    @Override
    public UserOrderResponseDto getUserOrderHistory(Long id) {
        UserResponseDto user;
        try{
            user = restClient.get()
                    .uri("http://localhost:8081/api/users/{id}" ,id)
                    .retrieve()
                    .body(UserResponseDto.class);
            System.out.println(user);
        }catch (Exception e){
            throw new RuntimeException("User not found with id: " + id);
        }
        List<Order> orders = orderRepository.findByUserId(id);
        List<ProductOrderItemDto> items = new ArrayList<>();
        double totalPrice = 0;
        for (Order order : orders) {
            ProductResponseDto product;
            try {
                product = restClient.get()
                        .uri("http://localhost:8082/api/products/{id}",order.getProductId())
                        .retrieve()
                        .body(ProductResponseDto.class);
            } catch (Exception e) {
                throw new RuntimeException("Product not found with id : "+order.getProductId());
            }
            ProductOrderItemDto item = new ProductOrderItemDto();
            item.setProduct(product);
            item.setQuantity(order.getQuantity());
            items.add(item);
            totalPrice += product.getPrice() * order.getQuantity();
        }
        UserOrderResponseDto response  = new UserOrderResponseDto();
        response.setUser(user);
        response.setOrderItems(items);
        response.setTotalPrice(totalPrice);

        return response;
    }
}
