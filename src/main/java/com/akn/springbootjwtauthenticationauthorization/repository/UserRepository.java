package com.akn.springbootjwtauthenticationauthorization.repository;

import com.akn.springbootjwtauthenticationauthorization.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
