package com.microservices.user_service.mapper;

import com.microservices.user_service.dto.UserResponse;
import com.microservices.user_service.entity.User;
import org.springframework.stereotype.Component;

/**
 * Author: Upashna
 * Created: 9/25/2026
 */
@Component
public class UserMapper {
    public UserResponse toDto(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }
    public static User toEntity(UserResponse userResponse) {
        User user = new User();
        user.setId(userResponse.getUserId());
        user.setUsername(userResponse.getUsername());
        user.setEmail(userResponse.getEmail());
        return user;
    }
}
