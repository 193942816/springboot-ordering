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
import javax.servlet.http.HttpSession;
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
            this.queryAll(notice,request);
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


    /**
     * @param mv
     * @param notice
     * @param session
     * @return
     */
    @RequestMapping(value = "/queryAlltoQiantai", method = RequestMethod.GET)
    public ModelAndView queryByIdtoQiantai(ModelAndView mv, Notice notice, HttpSession session) {

        List<Notice> notices = noticeService.queryBytoQiantai(notice);

        session.setAttribute("notices", notices);

        mv.setViewName("/qiantai/index");
        return mv;
    }

    /**
     * @param id
     * @param mv
     * @param notice
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam Integer id, ModelAndView mv, Notice notice, HttpServletRequest request) {

        Integer affectedRows = noticeService.deleteId(id);

        if (affectedRows > 0) {
            this.queryAll(notice, request);
            mv.setViewName("/admin/notice");
        }

        return mv;
    }

    /**
     * @param id
     * @param mv
     * @return
     */
    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    public ModelAndView queryId(@RequestParam Integer id, ModelAndView mv, HttpSession session) {

        Notice notice = noticeService.queryId(id);

        if (notice != null) {
            session.setAttribute("notice", notice);
            mv.setViewName("/admin/notice_update");
        }
        return mv;

    }

    /**
     *
     * @param id
     * @param mv
     * @param session
     * @return
     */
    @RequestMapping(value = "/queryByIdtoQiantai", method = RequestMethod.GET)
    public ModelAndView queryByIdtoQiantai(@RequestParam Integer id, ModelAndView mv,HttpSession session) {

        Notice notice = noticeService.queryId(id);

        session.setAttribute("notice",notice);


        mv.setViewName("/qiantai/notice");

        return mv;
    }

    /**
     *
     * @param notice
     * @param mv
     * @param session
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(Notice notice,ModelAndView mv,HttpSession session){

        return noticeService.update(notice,mv,session);
    }
}
