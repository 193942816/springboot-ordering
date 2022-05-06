package com.example.meal_ordering_system.service.Impl;

import com.example.meal_ordering_system.dao.NoticeMapper;
import com.example.meal_ordering_system.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
}
