package com.example.customerownerservice.repository;

import com.example.customerownerservice.model.CustomerOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerOwnerRepository extends JpaRepository<CustomerOwner,Integer> {
    List<CustomerOwner> findAllById(Integer id);
}
