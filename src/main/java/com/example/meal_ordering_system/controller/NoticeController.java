package com.example.meal_ordering_system.controller;

import com.example.meal_ordering_system.entity.Notice;
import com.example.meal_ordering_system.service.NoticeService;
import com.example.meal_ordering_system.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    /**
     * @param name
     * @param content
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView insert(@RequestParam String name, @RequestParam String content, Notice notice, HttpServletRequest request) {

        ModelAndView view = new ModelAndView();

        //返回所需要的参数
        ResultVo resultVo = noticeService.insert(name, content);
        //跳转
        if (resultVo.getData() != null) {
            view.setViewName("/admin/notice");
        } else {
            view.setViewName("/admin/notice_add");
        }

        return view;
    }

    /**
     * @param notice
     * @param request
     * @return
     */

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    public String queryAll(Notice notice, HttpServletRequest request) {

        List<Notice> notices = noticeService.queryAll(notice);

        request.setAttribute("notices", notices);

        return "/admin/notice";
    }

}
