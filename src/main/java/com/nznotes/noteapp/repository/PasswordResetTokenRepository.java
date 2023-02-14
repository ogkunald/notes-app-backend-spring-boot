package com.nznotes.noteapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nznotes.noteapp.entity.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,Long> {

    PasswordResetToken findByToken(String token);
    
}
