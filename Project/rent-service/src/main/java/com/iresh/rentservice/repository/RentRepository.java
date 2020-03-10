package com.iresh.rentservice.repository;

import com.iresh.rentservice.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent,Integer> {
}
