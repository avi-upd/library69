package com.abhi.library69.service.impl;

import com.abhi.library69.domain.User;
import com.abhi.library69.exception.UserAlreadyExistsException;
import com.abhi.library69.repository.UserRepository;
import com.abhi.library69.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserService {

    @Setter
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByUsername(username);

        return optionalUser.orElseThrow(()->new UsernameNotFoundException("User not found"));
    }


    @Override
    public void addUser(User user) {

        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if(optionalUser.isEmpty()){
            user.setAuthority("USER");
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        else
            throw new UserAlreadyExistsException("User Already Exists");

    }
}
