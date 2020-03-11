package com.iresh.rentservice.service;

import com.iresh.rentservice.model.Rent;

import java.util.List;

public interface RentService {
    Rent save(Rent rent);
    List<Rent> findById(Integer id);
}
