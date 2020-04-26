package com.iresh.apigateway.repository;

import com.iresh.apigateway.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
