package com.iresh.rentservice.repository;

import com.iresh.rentservice.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent,Integer> {
    List<Rent> findByCustomerId(Integer id);
}
