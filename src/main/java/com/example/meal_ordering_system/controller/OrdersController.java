package com.example.meal_ordering_system.controller;

import com.example.meal_ordering_system.entity.Orders;
import com.example.meal_ordering_system.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    //模糊查询：按菜品名称查询，按销售日期查询
//    @RequestMapping(value = "/order_qiantai",method = RequestMethod.POST)


    //查询所有订单
    @RequestMapping(value = "/ordersgetall",method = RequestMethod.GET)
    public String allOreders(Orders orders, HttpSession session) {
        List<Orders> allMenus = ordersService.allmenus(orders);
        session.setAttribute("ordersearch",allMenus);
        System.out.println(allMenus);
        return "/qiantai/index";
    }
}
