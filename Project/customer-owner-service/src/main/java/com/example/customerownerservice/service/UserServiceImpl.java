package com.example.customerownerservice.service;

import com.example.customerownerservice.model.CustomerOwner;
import com.example.customerownerservice.repository.CustomerOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private CustomerOwnerRepository customerOwnerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        CustomerOwner user = customerOwnerRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                new ArrayList<>());
    }

    public CustomerOwner save(CustomerOwner customerOwner) {
        //customerOwner.setUserName(customerOwner.getUserName());
        customerOwner.setPassword(bcryptEncoder.encode(customerOwner.getPassword()));
        return customerOwnerRepository.save(customerOwner);
    }

}
