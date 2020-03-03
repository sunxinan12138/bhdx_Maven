package com.bhdx.controller;

import com.bhdx.models.JIngFei_mark;
import com.bhdx.models.ZsDetail;
import com.bhdx.service.AddZsService;
import com.bhdx.service.SelectService;
import com.bhdx.tools.AjaxTool;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Controller
public class AddZsController {
    ModelAndView mav = null;
    @Autowired
    private AddZsService addZsService;

    @RequestMapping("/doaddZs")
    @ResponseBody
    public void doaddZs(HttpServletRequest request, HttpServletResponse response, ZsDetail zsDetail) {
        boolean btn = false;
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            String multia = request.getParameter("multia");
            String multib = request.getParameter("multib");
            String detail = request.getParameter("detail");
            String level = request.getParameter("level");
            String mark = request.getParameter("mark");
            double markdou = Double.parseDouble(mark);
            //System.out.println(markdou);
            zsDetail.setStudentId("201916050112");
            zsDetail.setDetail(detail);
            zsDetail.setProclass(multib);
            zsDetail.setLevel(level);
            zsDetail.setMark(markdou);
            zsDetail.setProject(multia);
            System.out.println(zsDetail);
            //btn = addZsService.sout();
            //添加到数据库
            //成功btn = true
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            new AjaxTool(btn, response);
        }


    }
}
