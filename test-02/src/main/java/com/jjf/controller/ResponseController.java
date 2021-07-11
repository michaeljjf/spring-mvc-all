package com.jjf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ResponseController {

    @RequestMapping("/testServlet")
    public void testServlet(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 请求转发
//        request.getRequestDispatcher("/forwardPage.jsp").forward(request, response);

        // 响应重定向，路径最好带上request.getContextPath()
        response.sendRedirect(request.getContextPath() + "redirectPage.jsp");
    }

    /**
     * 请求转发
     * @return
     */
    @RequestMapping("/testForward")
    public String testForward() {
        return "/forwardPage.jsp";
        // forward关键字可以省略
//        return "forward:/forwardPage.jsp";
    }

    /**
     * 响应重定向
     * @return
     */
    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "redirect:/redirectPage.jsp";
    }

    /**
     * 使用View视图转发和重定向
     * @return
     */
    @RequestMapping("/testView")
    public View testView(HttpServletRequest request) {
        View view = null;
        // 请求转发
//        view = new InternalResourceView("/forwardPage.jsp");
        // 重定向
        view = new RedirectView(request.getContextPath() + "/redirectPage.jsp");
        return view;
    }

    /**
     * 使用ModelAndView视图转发和重定向
     * @return
     */
    @RequestMapping("testView2")
    public ModelAndView testView2(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        // 转发
//        mv.setViewName("forwardPage.jsp");
//        mv.setView(new InternalResourceView("/forwardPage.jsp"));
        // 重定向
//        mv.setViewName("redirect:/redirectPage.jsp");
        mv.setView(new RedirectView(request.getContextPath() + "/redirectPage.jsp"));
        return mv;
    }
}
