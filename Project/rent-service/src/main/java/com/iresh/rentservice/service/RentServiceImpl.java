package com.iresh.rentservice.service;

import com.iresh.rentservice.model.Rent;
import com.iresh.rentservice.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepository rentRepository;

    @Override
    public Rent save(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public Rent update(Rent rent) {
            rentRepository.save(rent);
        return rent;
    }

    @Override
    public List<Rent> findById(Integer id) {
        return rentRepository.findByCustomerId(id);
    }

    @Override
    public List<Rent> getAllRent() {
        return rentRepository.findAll();
    }
}
