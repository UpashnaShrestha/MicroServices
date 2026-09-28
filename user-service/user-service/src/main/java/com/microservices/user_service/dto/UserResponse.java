package com.microservices.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Upashna
 * Created: 9/25/2026
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserResponse {
    private Long userId;
    private String username;
    private String email;

}
