package com.gestao.financas.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.financas.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}