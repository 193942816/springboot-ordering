package com.example.meal_ordering_system.service;

import com.example.meal_ordering_system.entity.Types;
import com.example.meal_ordering_system.vo.ResultVo;

import javax.servlet.http.HttpSession;

public interface TypesService {
        ResultVo getAll(Integer id, String name);
        String delete(Integer id, HttpSession session);
        ResultVo add(Types types);
        ResultVo update(Types types);
    }

