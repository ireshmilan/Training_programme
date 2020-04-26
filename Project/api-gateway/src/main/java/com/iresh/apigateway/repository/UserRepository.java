package com.iresh.apigateway.repository;

import com.iresh.apigateway.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {

    Users findByUsername (String username);
}
