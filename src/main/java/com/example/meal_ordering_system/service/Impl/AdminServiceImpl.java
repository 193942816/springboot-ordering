package com.example.meal_ordering_system.service.Impl;

import com.example.meal_ordering_system.dao.AdminMapper;
import com.example.meal_ordering_system.entity.Admin;
import com.example.meal_ordering_system.entity.AdminExample;
import com.example.meal_ordering_system.service.AdminService;
import com.example.meal_ordering_system.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ResultVo admin(String name, String pwd) {

        ResultVo vo = new ResultVo();
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andPwdEqualTo(pwd);

        List<Admin> admins = adminMapper.selectByExample(adminExample);
        Admin admin = adminMapper.selectById(name, pwd);
        System.out.println(admins);
        if (admins.size()!=0){

            vo.setCode(200);
            vo.setMessage("登录成功");
            vo.setSuccess(true);
            vo.setData(admin);
            return vo;
        }else {
            vo.setCode(0);
            vo.setMessage("登录失败");
            vo.setSuccess(true);
            vo.setData(null);

        }

        return vo;
    }
}
