package com.myapp.team.user.service;

import com.myapp.team.user.mapper.UserMapper;
import com.myapp.team.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public void register(User user) {
        user.setUserPw(passwordEncoder.encode(user.getUserPw()));
        user.setRole("USER");
        userMapper.insertUser(user);
    }


}