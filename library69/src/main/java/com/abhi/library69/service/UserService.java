package com.abhi.library69.service;

import com.abhi.library69.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public void addUser(User user);
}
