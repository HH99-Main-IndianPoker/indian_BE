package com.example.socketpractice.domain.chat.repository;

import com.example.socketpractice.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(User userId);
}
