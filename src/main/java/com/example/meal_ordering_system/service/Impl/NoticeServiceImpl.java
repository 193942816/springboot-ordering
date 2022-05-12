package com.example.meal_ordering_system.service.Impl;

import com.example.meal_ordering_system.dao.NoticeMapper;
import com.example.meal_ordering_system.entity.Notice;
import com.example.meal_ordering_system.service.NoticeService;
import com.example.meal_ordering_system.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public ResultVo insert(String name, String content) {

        //创建实体类对象传递参数
        Notice notice = new Notice();
        notice.setName(name);
        notice.setContent(content);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(new Date());
        notice.setTimes(time);

        //受影响的行数
        int affectedRows = noticeMapper.insert(notice);

        Map<String, Object> map = new HashMap<>();

        ResultVo vo = new ResultVo();
        if (affectedRows > 0) {

            //查询总个数
            int count = noticeMapper.selectCount();

            map.put("total", count);
            //根据主键回填获取最新插入的数据
            Notice list = noticeMapper.selectByPrimaryKey(notice.getId());

            map.put("list", list);

            vo.setData(map);
        }

        return vo;
    }


    //查询所有
    @Override
    public List<Notice> queryAll(Notice notice) {
        List<Notice> notices = noticeMapper.selectByExample(null);

        return notices;
    }


    //查询所有并传递前台
    @Override
    public List<Notice> queryBytoQiantai(Notice notice) {

        return noticeMapper.selectByExample(null);
    }


    //根据id删除
    @Override
    public Integer deleteId(Integer id) {


        return noticeMapper.deleteByPrimaryKey(id);
    }


    //根据id查询
    @Override
    public Notice queryId(Integer id) {

        return noticeMapper.selectByPrimaryKey(id);
    }


    //修改
    @Override
    public ModelAndView update(Notice notice, ModelAndView mv, HttpSession session) {

        //受影响的行数
        int affectedRows = noticeMapper.updateByPrimaryKeySelective(notice);

        if (affectedRows > 0) {

            //获取日期时间格式
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String time = format.format(new Date());
            //设置最新修改的时间
            notice.setTimes(time);

            //修改之后根据id查询修改的数据
            Notice notices = noticeMapper.selectByPrimaryKey(notice.getId());

            if (notices != null) {

                List<Notice> list = noticeMapper.selectByExample(null);
                //放到域对象中
                session.setAttribute("notices", list);

                mv.setViewName("/admin/notice");


            }
        }

        return mv;
    }
}
