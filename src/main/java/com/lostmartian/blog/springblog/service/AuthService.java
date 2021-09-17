package com.lostmartian.blog.springblog.service;

import com.lostmartian.blog.springblog.dto.RegisterRequest;
import com.lostmartian.blog.springblog.model.User;
import com.lostmartian.blog.springblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
        userRepository.save(user);
    }

}
