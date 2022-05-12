package com.example.meal_ordering_system.service.Impl;

import com.example.meal_ordering_system.dao.MenusMapper;
import com.example.meal_ordering_system.entity.Menus;
import com.example.meal_ordering_system.entity.MenusExample;
import com.example.meal_ordering_system.service.MenusService;
import com.example.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenusServiceImpl implements MenusService {
    @Autowired
    private MenusMapper menusMapper;

    //查询所有菜品信息
    @Override
    public List<Menus> allmenus(Menus menus) {
        List<Menus> menus1 = menusMapper.selectByExample(null);
        return menus1;
    }
    //进入增加页
    @Override
    public Integer toAddPage(Menus menus) {
        return menusMapper.insertSelective(menus);
    }
    //进入修改页
    @Override
    public Menus uptatetoPage(Integer id) {
        return menusMapper.selectByPrimaryKey(id);
    }

    //修改
    @Override
    public Integer update(Menus menus) {
        return menusMapper.updateByPrimaryKeySelective(menus);

    }
    //删除
    @Override
    public ResultVo delete(Integer id) {
        ResultVo resultVo = new ResultVo();
        int rows = menusMapper.deleteByPrimaryKey(id);
        if (rows > 0){
            resultVo.setCode(200);

        }else {
            resultVo.setCode(-100);
        }
        return resultVo;
    }


}
