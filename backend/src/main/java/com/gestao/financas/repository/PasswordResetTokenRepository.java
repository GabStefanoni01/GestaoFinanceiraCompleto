package com.gestao.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.financas.Entity.PasswordResetToken;
import com.gestao.financas.Entity.User;

import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByToken(String token);

    Optional<PasswordResetToken> findByUser(User user);
}
