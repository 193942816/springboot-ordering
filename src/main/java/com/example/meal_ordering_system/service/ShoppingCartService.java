package com.example.meal_ordering_system.service;

import com.example.meal_ordering_system.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> getCart(Integer id);
}
