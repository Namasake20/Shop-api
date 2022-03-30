package com.example.shop.Repo;

import com.example.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
