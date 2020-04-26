package com.iresh.apigateway.service;

import com.iresh.apigateway.config.JwtTokenUtil;
import com.iresh.apigateway.model.Role;
import com.iresh.apigateway.model.Users;
import com.iresh.apigateway.repository.RoleRepository;
import com.iresh.apigateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);
        if(users==null){
            throw new UsernameNotFoundException("User not found with username: " + username);

        }
        return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(),
                new ArrayList<>());
    }

    public String createAuthenticationToken(String username, String password) throws Exception {
        authenticate(username, password);
        final UserDetails userDetails = loadUserByUsername(username);
        System.out.println("create Authentication token method    "+userDetails);
        return jwtTokenUtil.generateToken(userDetails);
    }

    private void authenticate(String userame, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userame, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    public Users save(Users users){
        for(Role role : users.getRoles())
            role.setUsers(users);
        return userRepository.save(users);

    }

}
