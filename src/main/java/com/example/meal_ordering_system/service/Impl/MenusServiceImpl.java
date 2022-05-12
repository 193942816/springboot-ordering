package com.example.meal_ordering_system.service.Impl;

import com.example.meal_ordering_system.dao.MenusMapper;
import com.example.meal_ordering_system.dao.TypesMapper;
import com.example.meal_ordering_system.entity.Menus;
import com.example.meal_ordering_system.entity.MenusExample;
import com.example.meal_ordering_system.entity.Types;
import com.example.meal_ordering_system.service.MenusService;
import com.example.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MenusServiceImpl implements MenusService {
    @Autowired
    private MenusMapper menusMapper;

    @Override
    public List<Menus> allmenus(Menus menus) {
        List<Menus> menus1 = menusMapper.selectByExample(null);
        return menus1;
    }

}
