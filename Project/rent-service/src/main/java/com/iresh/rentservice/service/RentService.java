package com.iresh.rentservice.service;

import com.iresh.rentservice.model.Rent;

import java.util.List;

public interface RentService {
    Rent save(Rent rent);
   // List<Rent> getAllRent(String token);
    List<Rent> findById(Integer id);
    List<Rent> previousRentFindById(Integer id);
    Rent update(Rent rent);
    Rent cancel(Rent rent);
    Rent complete(Rent rent);
    List<Rent> findAll();
    List<Rent> findAllPrevious();
    List<Rent> getAllRent(Integer id);
}
