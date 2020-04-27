package com.iresh.rentservice.repository;

import com.iresh.rentservice.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent,Integer> {
    @Query(value ="SELECT * FROM rent u WHERE u.active = true AND u.customerId=:customerId ",nativeQuery = true)
    List<Rent> findByCustomerId(@Param("customerId") Integer id);
    @Query(value ="SELECT * FROM rent u WHERE u.active = false AND u.customerId=:customerId ",nativeQuery = true)
    List<Rent> findByCustomerIda(@Param("customerId") Integer id);

    @Query(value ="SELECT * FROM rent u WHERE u.active = true ",nativeQuery = true)
    List<Rent>findAll();

    @Query(value ="SELECT * FROM rent u WHERE u.active = false ",nativeQuery = true)
    List<Rent>findAllPrevios();

    List<Rent> findAllById(Integer id);
}
