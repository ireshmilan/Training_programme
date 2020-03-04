package com.example.customerownerservice.repository;

import com.example.customerownerservice.model.CustomerOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOwnerRepository extends JpaRepository<CustomerOwner,Integer> {
}
