package com.example.meal_ordering_system.service.Impl;

import com.example.meal_ordering_system.dao.UsersMapper;
import com.example.meal_ordering_system.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
}
