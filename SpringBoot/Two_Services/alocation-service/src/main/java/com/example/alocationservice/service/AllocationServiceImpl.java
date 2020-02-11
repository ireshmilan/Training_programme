package com.example.alocationservice.service;

import com.example.alocationservice.model.Allocation;
import com.example.alocationservice.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationServiceImpl implements AllocationService{

    @Autowired
    AllocationRepository allocationRepository;

    public Allocation save(Allocation allocation){
        return allocationRepository.save(allocation);

    }

    @Override
    public List<Allocation> fetchAllAllocations() {
        return allocationRepository.findAll();
    }

    @Override
    public List<Allocation> getAllocationByEmployeeId(Integer id) {
        return allocationRepository.findByEmpId(id);
    }
}
