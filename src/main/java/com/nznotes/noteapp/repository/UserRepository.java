package com.nznotes.noteapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nznotes.noteapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
}
