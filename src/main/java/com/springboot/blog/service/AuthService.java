package com.springboot.blog.service;

import com.springboot.blog.entity.LoginDto;
import com.springboot.blog.entity.RegisterDto;

public interface AuthService {

    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
