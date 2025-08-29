package com.codewithvihanga.store.repository;

import com.codewithvihanga.store.dtos.LoginRequest;
import com.codewithvihanga.store.entities.User;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}