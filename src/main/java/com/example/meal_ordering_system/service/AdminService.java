package com.example.meal_ordering_system.service;

import com.example.meal_ordering_system.vo.ResultVo;

public interface AdminService {
    ResultVo admin(String name, String pwd);

}
