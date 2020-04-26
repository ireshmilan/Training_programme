package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    @Query(value ="SELECT * FROM cars u WHERE u.hide = true ",nativeQuery = true)
    List<Car> findAll();
    List<Car> findAllById(Integer id);
    Car findByRegisteredNumber(String registerdNumber);
    List<Car> findByOwnerId(Integer id);

}
