package com.example.meal_ordering_system.controller;

import com.example.meal_ordering_system.entity.MenusExample;
import com.example.meal_ordering_system.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("menus")
public class MenusController {
    @Autowired
    private MenusService menusService;

    @RequestMapping( value = "/allMenus", method = RequestMethod.GET)
    public ModelAndView allMenus(MenusExample menusExample){
//        menusService.allmenus(menusExample);
        ModelAndView mv = new ModelAndView("menus_add");
        return mv;
    }

}
