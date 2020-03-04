package com.example.customerownerservice.service;

import com.example.customerownerservice.model.CustomerOwner;
import com.example.customerownerservice.model.Telephone;
import com.example.customerownerservice.repository.CustomerOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOwnerServiceImpl implements CustomerOwnerService {

    @Autowired
    CustomerOwnerRepository customerOwnerRepository;

    @Override
    public CustomerOwner save(CustomerOwner customerOwner) {
        for(Telephone telephone:customerOwner.getTelephone())
            telephone.setCustomerOwner(customerOwner);
        return customerOwnerRepository.save(customerOwner);
    }

    @Override
    public List<CustomerOwner> getAllCustomerOwner() {
        return customerOwnerRepository.findAll();
    }
}
