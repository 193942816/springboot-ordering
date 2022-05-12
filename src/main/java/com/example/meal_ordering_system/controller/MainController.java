package com.example.meal_ordering_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lihao
 *
 * 主要方法模块
 */
@Controller
public class MainController {
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin() {
        return "/admin/index";
    }
    @RequestMapping(value = "/qiantai",method = RequestMethod.GET)
    public String qiantai(){
        return "/qiantai/login";

    }
    @RequestMapping(value = "/reg",method = RequestMethod.GET)
    public String reg(){
        return "/qiantai/reg";
    }
}

