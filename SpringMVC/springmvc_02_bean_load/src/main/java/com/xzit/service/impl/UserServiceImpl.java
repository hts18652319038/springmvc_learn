package com.xzit.service.impl;

import com.xzit.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("user service ...");
    }
}
