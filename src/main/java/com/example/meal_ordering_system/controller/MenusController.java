package com.example.meal_ordering_system.controller;

import com.example.meal_ordering_system.entity.Menus;
import com.example.meal_ordering_system.entity.MenusExample;
import com.example.meal_ordering_system.entity.Types;
import com.example.meal_ordering_system.service.MenusService;
import com.example.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("menus")
public class MenusController {
    @Autowired
    private MenusService menusService;
    //菜单信息查询
    @RequestMapping(value = "/allMenus", method = RequestMethod.GET)
    public String allMenus(Menus menus, HttpSession session) {
        List<Menus> menus1 = menusService.allmenus(menus);
        session.setAttribute("list", menus1);
        return "/admin/menus";
    }
    //进入菜品添加页
    @RequestMapping(value = "/toAddPage", method = RequestMethod.GET)
    public String toAddPage(Menus menus) {

        return "/admin/menus_add";
    }
    //进入菜单修改页面
    @RequestMapping(value = "toUpdatePage",method = RequestMethod.GET)
    public String uptatetoPage(Integer id,HttpSession session) {
        Menus menus = menusService.uptatetoPage(id);
        session.setAttribute("menu", menus);
        return "/admin/menus_update";
    }
    //修改菜品信息
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Menus menus,HttpSession session) {
        Integer integer = menusService.update(menus);
        if (integer > 0) {
            this.allMenus(menus,session);
            return "/admin/menus";


}
