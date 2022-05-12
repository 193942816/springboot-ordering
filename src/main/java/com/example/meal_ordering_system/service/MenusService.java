package com.example.meal_ordering_system.service;

import com.example.meal_ordering_system.entity.Menus;
import com.example.meal_ordering_system.entity.MenusExample;
import com.example.meal_ordering_system.entity.Types;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface MenusService {
    List<Menus> allmenus(MenusExample menusExample);

    ModelAndView insert(HttpSession session, Menus menus, MultipartFile img, ModelAndView view, Types types);
}
