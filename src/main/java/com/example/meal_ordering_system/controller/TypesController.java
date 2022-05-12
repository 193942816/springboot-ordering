package com.example.meal_ordering_system.controller;

import com.example.meal_ordering_system.entity.Types;
import com.example.meal_ordering_system.service.TypesService;
import com.example.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("types")
public class TypesController {
    @Autowired
    private TypesService typesService;
    //获取全部菜单
    @GetMapping("queryAll")
    public String getAll(Integer id, String name, HttpSession session){
        ResultVo all = typesService.getAll(id, name);
        System.out.println(all);
        session.setAttribute("types",all.getData());
        return "admin/type";
    }
    //删除菜单
    @GetMapping("delete")
    public String delete( Integer id,String name,HttpSession session){
        ResultVo vo = typesService.delete(id);
        this.getAll(id, name, session);
        return"admin/type";
    }
    //添加菜单
    @PostMapping("insert")
    public String insert(Types types,HttpSession session){
        ResultVo add = typesService.add(types);
        session.setAttribute("items",add);
        return "admin/type";
    }
    //修改菜单
    @PostMapping("update")
    public String update(Types types){
        typesService.update(types);
        return"admin/type";
    }



}