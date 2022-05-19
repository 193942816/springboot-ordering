package com.example.meal_ordering_system.controller;

import com.example.meal_ordering_system.entity.ShoppingCart;
import com.example.meal_ordering_system.entity.Users;
import com.example.meal_ordering_system.service.ShoppingCartService;
import com.example.meal_ordering_system.service.UsersService;
import com.example.meal_ordering_system.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lihao
 *
 * 用户模块
 */
@Controller
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 用户登录
     *
     * @param users
     * @param session
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Users users,
                        HttpSession session,
                        HttpServletResponse response,
                        HttpServletRequest request
    ) {
        ResultVo resultVo = usersService.login(users.getName(), users.getPwd());
        if (resultVo.getCode() == 0) {
            //登录失败
            return "/qiantai/userLoginFail";
        } else {
            Users user = (Users) resultVo.getUserInfo();
            List<ShoppingCart> carts = shoppingCartService.getCart(user.getId());

            session.setAttribute("shoppingcar", carts);

            System.out.println(resultVo);
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(30 * 60);

            response.addCookie(cookie);
            session.setAttribute("user_session", resultVo.getUserInfo());
            request.setAttribute("menusList", resultVo.getData());
            request.setAttribute("notices", resultVo.getNotice());
        }

        return "/qiantai/index";
    }
    /**
     * 用户修改
     * @param users
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update( Users users){
        Integer num= usersService.update(users);
        if (num>0){
            return "修改成功";
        }
        return "修改失败";
    }
    /**
     * 用户添加功能
     * @param users
     * @return
     */
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(Users users){
        Integer num= usersService.insert(users);

        if (num>0){
            return "/qiantai/login";
        }
        return "/qiantai/reg";
    }
    /**
     * 退出登录
     * @return
     */
    @RequestMapping(value = "logout",method =RequestMethod.GET)
    public  String logout(HttpSession session){
        session.removeAttribute("admin_session");
        return "/qiantai/login";
    }
}