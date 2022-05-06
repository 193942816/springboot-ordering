package com.example.meal_ordering_system.service.Impl;

import com.example.meal_ordering_system.dao.AdminMapper;
import com.example.meal_ordering_system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
}
