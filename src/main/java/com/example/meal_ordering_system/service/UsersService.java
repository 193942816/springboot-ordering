package com.example.meal_ordering_system.service;

import com.example.meal_ordering_system.vo.ResultVo;

public interface UsersService {
    ResultVo login(String name, String pwd);

}
