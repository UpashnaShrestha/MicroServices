package com.microservices.user_service.controller;

import com.microservices.user_service.dto.UserRequest;
import com.microservices.user_service.dto.UserResponse;
import com.microservices.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Upashna
 * Created: 9/25/2026
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }
    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id,  @RequestBody UserRequest userRequest) {
        return userService.updateUser(id, userRequest);
    }
    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}
