package com.checklist.repository;

import com.checklist.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReporitory extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
