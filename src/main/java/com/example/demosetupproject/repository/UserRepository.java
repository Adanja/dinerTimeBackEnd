package com.example.demosetupproject.repository;

import com.example.demosetupproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, String> {
    @Query ("SELECT s FROM User s WHERE s.email =?1")
    Optional<User> findUserByEmail(String email);

    Optional<User> findById(String username);

    void deleteById(String username);
}
