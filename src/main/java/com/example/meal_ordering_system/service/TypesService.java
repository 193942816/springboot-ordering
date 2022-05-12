package com.example.meal_ordering_system.service;

import com.example.meal_ordering_system.entity.Types;
import com.example.vo.ResultVo;
    public interface TypesService {
        ResultVo getAll(Integer id, String name);
        ResultVo delete(Integer id);
        ResultVo add(Types types);
        ResultVo update(Types types);
    }

