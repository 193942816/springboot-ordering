package com.example.meal_ordering_system.controller;

import com.example.meal_ordering_system.entity.Users;
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
        usersService.login(users.getName(), users.getPwd());

        ResultVo resultVo = usersService.login(users.getName(), users.getPwd());
        if (resultVo.getCode() == 0) {
            //登录失败
            return "/qiantai/userLoginFail";
        } else {
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
}