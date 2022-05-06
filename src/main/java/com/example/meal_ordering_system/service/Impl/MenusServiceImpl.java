package com.example.meal_ordering_system.service.Impl;

import com.example.meal_ordering_system.dao.MenusMapper;
import com.example.meal_ordering_system.entity.Menus;
import com.example.meal_ordering_system.entity.MenusExample;
import com.example.meal_ordering_system.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenusServiceImpl implements MenusService {
    @Autowired
    private MenusMapper menusMapper;

    @Override
    public List<Menus> allmenus(MenusExample menusExample) {
        List<Menus> menus = menusMapper.selectByExample(menusExample);
        System.out.println(menus);
        return menus;
    }
}
