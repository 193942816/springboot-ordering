package com.example.meal_ordering_system.service.Impl;

import com.example.meal_ordering_system.dao.MenusMapper;
import com.example.meal_ordering_system.dao.NoticeMapper;
import com.example.meal_ordering_system.dao.UsersMapper;
import com.example.meal_ordering_system.entity.Users;
import com.example.meal_ordering_system.entity.UsersExample;
import com.example.meal_ordering_system.service.UsersService;
import com.example.meal_ordering_system.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private MenusMapper menusMapper;
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public ResultVo login(String name, String pwd) {
        ResultVo vo = new ResultVo();
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andPwdEqualTo(pwd);
        List<Users> users = usersMapper.selectByExample(usersExample);
        if (users.size() != 0){
            vo.setCode(200);
            vo.setSuccess(true);
            vo.setMessage("登录成功");
            vo.setData(menusMapper.selectByExample(null));
            vo.setUserInfo(usersMapper.selectById(name,pwd));
            vo.setNotice(noticeMapper.selectByExample(null));
            return vo;
        }else {
            vo.setCode(0);
            vo.setSuccess(false);
            vo.setMessage("登录失败");
            vo.setData(null);

        }

        return vo ;
    }

}
