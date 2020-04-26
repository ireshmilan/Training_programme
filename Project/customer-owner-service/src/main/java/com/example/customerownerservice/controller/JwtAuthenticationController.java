package com.example.customerownerservice.controller;


import com.example.customerownerservice.config.JwtTokenUtil;
import com.example.customerownerservice.model.CustomerOwner;
import com.example.customerownerservice.model.JwtRequest;
import com.example.customerownerservice.model.JwtResponse;
import com.example.customerownerservice.model.Rent;
import com.example.customerownerservice.service.CustomerOwnerService;
import com.example.customerownerservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private CustomerOwnerService customerOwnerService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userServiceImpl
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
        System.out.println("ddddddddddddddddddd "+token);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody CustomerOwner user) throws Exception {
        return ResponseEntity.ok(userServiceImpl.save(user));
    }

    private void authenticate(String userName, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @GetMapping("/get")
    public List<CustomerOwner> findAllCustomerOwner() {
        return customerOwnerService.getAllCustomerOwner();
    }
@GetMapping("/getActive")
public boolean findByActive(){
        return customerOwnerService.findByActivity(true);
}

    @GetMapping("/getRent/{empId}")
    public List<Rent> fetchAllRent(@PathVariable Integer empId){
        return customerOwnerService.fetchAllRent(empId);
    }


}