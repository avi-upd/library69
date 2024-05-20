package com.abhi.library69.controller;

import com.abhi.library69.domain.User;
import com.abhi.library69.service.impl.UserDetailServiceImpl;
import com.abhi.library69.service.resource.UserRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecurityDemoController {

    @Autowired
    UserDetailServiceImpl userDetailsService;

    @GetMapping("/greet/{username}")
    public String greet(@PathVariable("username") String username){
        return "Hello " + username;
    }

    @GetMapping("/admin/greet/{username}")
    public String adminGreet(@PathVariable("username") String username){
        return "Hello Admin " + username;
    }

    @GetMapping("/csrf")
    public String homepage(HttpServletRequest request){

        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        return csrfToken.getToken();
    }


}
