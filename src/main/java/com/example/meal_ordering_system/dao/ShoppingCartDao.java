package com.example.meal_ordering_system.dao;

import com.example.meal_ordering_system.entity.ShoppingCart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartDao {
    List<ShoppingCart> getCart(@Param("id") Integer id);
}
