package com.example.meal_ordering_system.service.Impl;

import com.example.meal_ordering_system.dao.TypesMapper;
import com.example.meal_ordering_system.entity.Types;
import com.example.meal_ordering_system.service.TypesService;
import com.example.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesServiceImpl implements TypesService {
    @Autowired
    private TypesMapper typesMapper;

    @Override
    public ResultVo getAll(Integer id, String name) {
        ResultVo resultVo=new ResultVo();
        List<Types> types = typesMapper.selectByExample(null);
        System.out.println(types);
        resultVo.setCode(200);
        resultVo.setData(types);
        resultVo.setMessage("全部菜品");
        resultVo.setSuccess(true);
        return resultVo;
    }
    //删除菜单
    @Override
    public ResultVo delete(Integer id) {
        ResultVo resultVo=null;
        int affectedRows = typesMapper.deleteByPrimaryKey(id);

        return resultVo;
    }
    //添加菜单
    @Override
    public ResultVo add(Types types) {
        ResultVo resultVo = new ResultVo();

        int affectedRows =typesMapper.insert(types);
        //判断是否插入成功
        if (affectedRows>0){
            resultVo.setData(affectedRows);
        }
        return resultVo;
    }
    @Override
    public ResultVo update(Types types) {
        ResultVo resultVo = new ResultVo();
        int i = typesMapper.updateByPrimaryKey(types);
        if (i>0){
            //修改成功
            types=typesMapper.selectByPrimaryKey(types.getId());
            resultVo.setData(types);
        }
        return resultVo;
    }
}

