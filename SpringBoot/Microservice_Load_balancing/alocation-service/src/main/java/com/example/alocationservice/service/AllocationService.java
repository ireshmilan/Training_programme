package com.example.alocationservice.service;

import com.example.alocationservice.model.Allocation;

import java.util.List;

public interface AllocationService {

    Allocation save(Allocation allocation);

    List<Allocation> fetchAllAllocations();

    List<Allocation> getAllocationByEmployeeId(Integer id);
}
