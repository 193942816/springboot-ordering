package com.example.meal_ordering_system.controller;

import com.example.meal_ordering_system.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UsersController {
    @Autowired
    private UsersService usersService;
}
