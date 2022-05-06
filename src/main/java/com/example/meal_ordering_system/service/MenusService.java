package com.example.meal_ordering_system.service;

import com.example.meal_ordering_system.entity.Menus;
import com.example.meal_ordering_system.entity.MenusExample;

import java.util.List;

public interface MenusService {
    List<Menus> allmenus(MenusExample menusExample);
}
