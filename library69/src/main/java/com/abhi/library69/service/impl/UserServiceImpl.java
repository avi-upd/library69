package com.abhi.library69.service.impl;

import com.abhi.library69.domain.User;
import com.abhi.library69.repository.UserRepository;
import com.abhi.library69.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(User user) {

        userRepository.save(user);
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User getById(Integer Id) {

        return userRepository.findById(Id).orElse(null);
    }

    @Override
    public User getByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public User updateUser(Integer id, User user) {

        Optional<User> originalUser = userRepository.findById(id);
        if(originalUser.isPresent()){
            userRepository.save(user);
        }
        return user;
    }

    public void deleteUser(Integer id){

        userRepository.deleteById(id);
    }

}
