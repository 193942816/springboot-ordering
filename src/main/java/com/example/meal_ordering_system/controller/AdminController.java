package com.example.meal_ordering_system.controller;

import com.example.meal_ordering_system.dao.TypesMapper;
import com.example.meal_ordering_system.entity.Admin;
import com.example.meal_ordering_system.entity.Types;
import com.example.meal_ordering_system.entity.Users;
import com.example.meal_ordering_system.service.AdminService;
import com.example.meal_ordering_system.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private TypesMapper typesMapper;
    /**
     * 登录功能
     * @param admin
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Admin admin, HttpSession session){
        ResultVo resultVo= adminService.admin(admin.getName(), admin.getPwd());

        List<Types> typesList = typesMapper.selectByExample(null);

        if (typesList!=null){
            session.setAttribute("typesList",typesList);
        }
        if (resultVo.getCode() == 0) {
            return "/admin/index";
        }else {
            session.setAttribute("admin_session",resultVo.getData());
            return "/admin/main";

        }
    }

}
