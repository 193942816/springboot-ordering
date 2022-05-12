package com.example.meal_ordering_system.service;

import com.example.meal_ordering_system.entity.Notice;
import com.example.meal_ordering_system.vo.ResultVo;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface NoticeService {

    ResultVo insert(String name, String content);

    List<Notice> queryAll(Notice notice);

    List<Notice> queryBytoQiantai(Notice notice);

    Integer deleteId(Integer id);

    Notice queryId(Integer id);

    ModelAndView update(Notice notice, ModelAndView mv, HttpSession session);

}
