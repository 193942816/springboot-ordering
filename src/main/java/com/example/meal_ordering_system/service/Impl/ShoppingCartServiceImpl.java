package com.example.meal_ordering_system.service.Impl;

import com.example.meal_ordering_system.dao.ShoppingCartDao;
import com.example.meal_ordering_system.entity.ShoppingCart;
import com.example.meal_ordering_system.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    public List<ShoppingCart> getCart(Integer id) {
        return shoppingCartDao.getCart(id);
    }
}
