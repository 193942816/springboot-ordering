package com.example.meal_ordering_system.service.Impl;

import com.example.meal_ordering_system.dao.OrdersMapper;
import com.example.meal_ordering_system.entity.Orders;
import com.example.meal_ordering_system.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> allmenus(Orders orders) {
        List<Orders> orders1 = ordersMapper.selectByExample(null);
        return orders1;
    }
}
