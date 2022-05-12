package com.example.meal_ordering_system.service;

import com.example.meal_ordering_system.entity.Notice;
import com.example.meal_ordering_system.vo.ResultVo;

import java.util.List;

public interface NoticeService {

    ResultVo insert(String name, String content);

    List<Notice> queryAll(Notice notice);
}
