package com.bhdx.controller;

import com.bhdx.service.SelectService;
import com.bhdx.tools.AjaxTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 级联查询
 */

@Controller
public class SelectController {
    private static HashMap mymap = new HashMap();
    ModelAndView mav = null;
    @Autowired
    private SelectService selectService;


    //查询Kind
    //查询zs细节


    @RequestMapping("/dostuidSession")
    public void stuidSession(HttpServletRequest request, HttpSession httpSession, HttpServletResponse response) {
        String stui = null;
        stui = selectService.getHeader(request);
        System.out.println(stui);
        new AjaxTool(stui, response);
    }

    //学号查证书
    @RequestMapping("/selectzcByid")
    public void selectzcByid(HttpServletRequest request, HttpServletResponse response) {
//, @RequestParam("adate") String stuid
        String stuid = request.getParameter("stuid");
        System.out.println(stuid);
        // 查询证书回显

        new AjaxTool("哈哈哈", response);
    }

    //查重
    @RequestMapping("/selectrepeat")
    public void selectrepeat(HttpServletRequest request, HttpServletResponse response) {
        boolean btn = true;
        String zsname = request.getParameter("zsname");
        //  String stuid = request.getParameter("stuid");
        btn = selectService.cchcx(zsname);
        new AjaxTool(btn, response);
    }

    @RequestMapping("/selectzcrepeat")
    public void selectzcrepeat(HttpServletRequest request, HttpServletResponse response) {
        boolean btn = true;
        String zsname = request.getParameter("zsname");

        // 查询证书回显
        btn = selectService.cchzc(zsname);
        new AjaxTool(btn, response);
    }

    @RequestMapping("/selectallrepeat")
    public void selectallrepeat(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        String zsname = request.getParameter("zsname");

        // 查询证书回显
        message = selectService.cchall(zsname);
        new AjaxTool(message, response);
    }
}



