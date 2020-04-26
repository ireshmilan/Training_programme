package com.iresh.apigateway.controller;

import com.iresh.apigateway.config.JwtTokenUtil;
import com.iresh.apigateway.model.*;
import com.iresh.apigateway.service.JwtUserDetailsService;
import com.iresh.apigateway.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")

public class JwtAuthenticationController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        String token=jwtUserDetailsService.createAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());

//        final UserDetails userDetails = userServiceImpl
//                .loadUserByUsername(authenticationRequest.getUsername());
//
//        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserModel userModel) throws Exception {
        Users users = new Users();
        users.setUsername(userModel.getUsername());
        users.setPassword(passwordEncoder.encode(userModel.getPassword()));
        users.setActive(true);
        users.setRoles(userModel.getRoles());
        jwtUserDetailsService.save(users);



        CustomerOwner customerOwner = new CustomerOwner();
        customerOwner.setFirstName(userModel.getFirstName());
        customerOwner.setLastName(userModel.getLastName());
        customerOwner.setEmail(userModel.getEmail());
        customerOwner.setGender(userModel.getGender());
        customerOwner.setDateOfBirth(userModel.getDateOfBirth());
        customerOwner.setIdCardNumber(userModel.getIdCardNumber());
        customerOwner.setJoinedDate(userModel.getJoinedDate());
        customerOwner.setTelephone(userModel.getTelephone());
        customerOwner.setAddress(userModel.getAddress());
        String token = jwtUserDetailsService.createAuthenticationToken(userModel.getUsername(),userModel.getPassword());
        System.out.println("token    " +token);
        return ResponseEntity.ok(userService.saveInUserService(customerOwner,token));
    }

//    private void authenticate(String userName, String password) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }
//
//    @GetMapping("/get")
//    public List<CustomerOwner> findAllCustomerOwner() {
//        return customerOwnerService.getAllCustomerOwner();
//    }
//@GetMapping("/getActive")
//public boolean findByActive(){
//        return customerOwnerService.findByActivity(true);
//}
}