package com.example.meal_ordering_system.service;

import com.example.meal_ordering_system.vo.ResultVo;

public interface NoticeService {

    ResultVo insert(String name, String content);
}
