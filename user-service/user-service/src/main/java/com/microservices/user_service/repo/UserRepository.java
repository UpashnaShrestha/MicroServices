package com.microservices.user_service.repo;

import com.microservices.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Upashna
 * Created: 9/25/2026
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
