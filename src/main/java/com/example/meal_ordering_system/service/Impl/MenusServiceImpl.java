package com.example.meal_ordering_system.service.Impl;

import com.example.meal_ordering_system.dao.MenusMapper;
import com.example.meal_ordering_system.dao.TypesMapper;
import com.example.meal_ordering_system.entity.Menus;
import com.example.meal_ordering_system.entity.MenusExample;
import com.example.meal_ordering_system.entity.Types;
import com.example.meal_ordering_system.service.MenusService;
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

    @Autowired
    private TypesMapper typesMapper;
    @Override
    public List<Menus> allmenus(MenusExample menusExample) {
        List<Menus> menus = menusMapper.selectByExample(menusExample);
        System.out.println(menus);
        return menus;
    }


    @Override
    public ModelAndView insert(HttpSession session, Menus menus, MultipartFile img, ModelAndView view, Types types) {

        String path="D:\\IdeaWorkSpace\\项目\\springboot-ordering\\target\\classes\\META-INF\\resources\\public\\img";

        if (img != null && !img.isEmpty()) {
            File pathFile = new File(path);

            String filename = img.getOriginalFilename();

            String suffix = filename.substring(filename.lastIndexOf('.'));

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

            String prefix = formatter.format(new Date());

            filename = prefix + suffix;

            try {
                img.transferTo(new File(pathFile, filename));

                // 上传成功之后需要把新头像的路径给存储到meuns对象中，因为等会需要刷新数据库
                menus.setImgpath("img/"+filename);
            } catch (IOException e) {

            }
        }

        //插入
        int affectedRows = menusMapper.insertSelective(menus);

        int insert = typesMapper.insert(types);


        if (affectedRows > 0||insert>0) {
            //插入成功后更新数据
            List<Menus> list = menusMapper.selectByExample(null);

            List<Types> types1 = typesMapper.selectByExample(null);
            //页面刷新
            if (menus != null||types1!=null) {

                session.setAttribute("list",list);

                session.setAttribute("typesList",types1);
                view.setViewName("/admin/menus");
            }

        }
        return view;
    }
}
