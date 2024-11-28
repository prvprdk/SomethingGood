package com.example.somethinggood.repository;

import com.example.somethinggood.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface UserRepo extends JpaRepository<User,Long> {
        User findByUsername (String username);
    }
