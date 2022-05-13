package com.example.meal_ordering_system.controller;

import com.example.meal_ordering_system.dao.TypesMapper;
import com.example.meal_ordering_system.entity.Types;
import com.example.meal_ordering_system.service.TypesService;
import com.example.meal_ordering_system.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("types")
public class TypesController {
    @Autowired
    private TypesService typesService;

    @Autowired
    private TypesMapper typesMapper;
    //获取全部菜单
    @GetMapping("queryAll")
    public String getAll(Integer id, String name, HttpSession session) {
        ResultVo all = typesService.getAll(id, name);

        session.setAttribute("type", all.getData());
        return "admin/type";
    }

    //删除菜单
    @GetMapping("delete")
    public String delete(Integer id,  HttpSession session) {


        return typesService.delete(id,session);
    }

    //添加菜单
    @PostMapping("insert")
    public String insert(Types types, HttpSession session) {
        ResultVo add = typesService.add(types);

       if (add.getData()!=null){
           List<Types> types1 = typesMapper.selectByExample(null);

           session.setAttribute("type",types1);
       }
        return "admin/type";
    }

    //修改菜单
    @PostMapping("update")
    public String update(Types types,HttpSession session) {
        ResultVo vo = typesService.update(types);

        if (vo.getData()!=null){

            List<Types> typesList = typesMapper.selectByExample(null);

            session.setAttribute("type",typesList);

        }
        return "admin/type";
    }

    @GetMapping("queryById")
    public String queryById(Integer id,HttpSession session){
        Types type = typesMapper.selectByPrimaryKey(id);

        if (type!=null){

            session.setAttribute("type",type);
        }

        return "admin/type_update";
    }
}