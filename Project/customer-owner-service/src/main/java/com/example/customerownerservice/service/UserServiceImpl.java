package com.example.customerownerservice.service;

import com.example.customerownerservice.model.APIResponse;
import com.example.customerownerservice.model.CustomerOwner;
import com.example.customerownerservice.model.Telephone;
import com.example.customerownerservice.repository.CustomerOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserDetailsService {
    public static CustomerOwner user;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private CustomerOwnerRepository customerOwnerRepository;

    @Autowired
    private CustomerOwnerService customerOwnerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails userDetails=null;
        user = customerOwnerRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        else if(user.getActivity()){
            userDetails=new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    new ArrayList<>());
        }

        return userDetails;
    }

    public CustomerOwner save(CustomerOwner customerOwner) {


        if (customerOwnerService.findByUsername(customerOwner.getUsername()) == null && customerOwnerService.findByEmail(customerOwner.getEmail()) == null && customerOwnerService.findByIdCardNumber(customerOwner.getIdCardNumber())==null) {

            for (Telephone telephone : customerOwner.getTelephone())
                telephone.setCustomerOwner(customerOwner);

            customerOwner.setJoinedDate(LocalDate.now());
            customerOwner.setActivity(true);
            customerOwner.setDlt(true);
            customerOwner.setRole("User");
            customerOwner.setPassword(bcryptEncoder.encode(customerOwner.getPassword()));
            return customerOwnerRepository.save(customerOwner);
        }
throw new IllegalArgumentException();


    }



}
