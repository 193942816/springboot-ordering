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

    //查询所有菜品信息
    @Override
    public List<Menus> allmenus(Menus menus) {
        List<Menus> menus1 = menusMapper.selectByExample(null);
        return menus1;
    }
}
