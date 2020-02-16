package com.example.alocationservice.repository;

import com.example.alocationservice.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation,Integer>{
    List<Allocation> findByEmpId(Integer empId);
}
