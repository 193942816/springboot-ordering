package com.example.meal_ordering_system.service.Impl;

import com.example.meal_ordering_system.dao.OrdersMapper;
import com.example.meal_ordering_system.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
}
