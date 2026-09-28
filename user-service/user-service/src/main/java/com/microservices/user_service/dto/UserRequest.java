package com.microservices.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: Upashna
 * Created: 9/25/2026
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserRequest {
    private String username;
    private String email;
    private String password;
}
