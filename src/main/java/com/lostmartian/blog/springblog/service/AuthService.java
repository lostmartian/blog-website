package com.lostmartian.blog.springblog.service;

import com.lostmartian.blog.springblog.dto.LoginRequest;
import com.lostmartian.blog.springblog.dto.RegisterRequest;
import com.lostmartian.blog.springblog.model.User;
import com.lostmartian.blog.springblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        userRepository.save(user);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public void login(LoginRequest loginRequest) {
    }
}
