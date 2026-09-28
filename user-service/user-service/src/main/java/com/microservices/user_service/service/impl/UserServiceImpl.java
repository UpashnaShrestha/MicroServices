package com.microservices.user_service.service.impl;

import com.microservices.user_service.dto.UserRequest;
import com.microservices.user_service.dto.UserResponse;
import com.microservices.user_service.entity.User;
import com.microservices.user_service.mapper.UserMapper;
import com.microservices.user_service.repo.UserRepository;
import com.microservices.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Upashna
 * Created: 9/25/2026
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        User savedUser =  userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public UserResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toDto(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }


}
