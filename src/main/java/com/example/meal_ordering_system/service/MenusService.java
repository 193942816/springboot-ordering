package com.example.meal_ordering_system.service;

import com.example.meal_ordering_system.entity.Menus;
import com.example.meal_ordering_system.entity.MenusExample;
import com.example.vo.ResultVo;

import java.util.List;

public interface MenusService {
    List<Menus> allmenus(Menus menus);

    Integer toAddPage(Menus menus);

    Menus uptatetoPage(Integer id);

    Integer update(Menus menus);

    ResultVo delete(Integer id);
}
