package com.microservices.user_service.service;

import com.microservices.user_service.dto.UserRequest;
import com.microservices.user_service.dto.UserResponse;

import java.util.List;

/**
 * Author: Upashna
 * Created: 9/25/2026
 */

public interface UserService  {
    List<UserResponse> getAllUsers();
    UserResponse createUser(UserRequest request);
    UserResponse getById(Long id);
    UserResponse updateUser(Long id, UserRequest request);
    void deleteUser(Long id);
}