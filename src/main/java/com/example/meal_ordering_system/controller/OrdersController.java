package com.example.meal_ordering_system.controller;

import com.example.meal_ordering_system.entity.Orders;
import com.example.meal_ordering_system.entity.ShoppingCart;
import com.example.meal_ordering_system.service.OrdersService;
import com.example.meal_ordering_system.service.ShoppingCartService;
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
    @Autowired
    private ShoppingCartService shoppingCartService;
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

    @RequestMapping("order_addshoppingcartoOrder")
    public void test() {

    }

    @RequestMapping("order_shoppingcardel")
    public void test2(Integer del) {

    }
    @RequestMapping("order_addshoppingcar")
    public ModelAndView addshoppingcar(Integer id ,ModelAndView mv){
        List<ShoppingCart> cart = shoppingCartService.getCart(id);
        System.out.println(id);
        System.out.println(cart);
        mv.addObject("shoppingcar",cart);
        mv.setViewName("/qiantai/shoppingcar");
        return mv;
    }
}
