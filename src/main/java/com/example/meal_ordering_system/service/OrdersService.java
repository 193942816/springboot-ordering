package com.example.meal_ordering_system.service;

import com.example.meal_ordering_system.entity.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> allmenus(Orders orders);

    Integer addshoppingcar(Integer id);
}

