package com.example.shop.Repo;

import com.example.shop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
