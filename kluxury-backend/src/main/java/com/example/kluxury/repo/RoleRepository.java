package com.example.kluxury.repo;


import com.example.kluxury.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleById(int id);
}
