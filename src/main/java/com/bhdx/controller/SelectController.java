package com.bhdx.controller;

import com.bhdx.models.DetailMark;
import com.bhdx.models.JIngFei_mark;
import com.bhdx.models.JingFei;
import com.bhdx.models.Student;
import com.bhdx.service.SelectService;
import com.bhdx.tools.AjaxTool;
import com.google.gson.Gson;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

    /*//级联查询细节
    @RequestMapping("/doselectkind")
    public void doselectkind(HttpServletRequest request, HttpServletResponse response, JingFei jingFei) {
        String a = "0";
        String b = "1";
        Object obj0 = request.getParameter(a);
        Object obj1 = request.getParameter(b);
        int index0 = Integer.parseInt(obj0.toString());
        int index1 = Integer.parseInt(obj1.toString());
        List detailList = new ArrayList<>();
        // System.out.println(index0 + "--" + index1);
        switch (index0) {
            case 0:
                switch (index1) {
                    case 0:
                        detailList = selectService.findJK();
                        break;
                    case 1:
                        //查0-1
                        detailList = selectService.findJF();
                        break;
                }
                break;
            case 1:
                switch (index1) {
                    case 0:
                        //查询科发
                        detailList = selectService.findKF();
                        break;
                    case 1:
                        //查询科科
                        detailList = selectService.findKK();
                        break;
                    case 2:
                        //查询科科研
                        // what should i do???WTF?
                        System.out.println("查科科研");
                        break;
                }
                break;
            case 2:
                switch (index1) {
                    case 0:
                        //查询证职
                        detailList = selectService.findZZ();
                        break;
                    case 1:
                        //查询证全
                        detailList = selectService.findZQ();
                        break;
                }
                break;
            case 3:
                switch (index1) {
                    case 0:
                        //查询活科
                        detailList = selectService.findHK();
                        break;
                    case 1:
                        detailList = selectService.findHS();
                        //查询活社
                        break;
                    case 2:
                        //查询活学
                        detailList = selectService.findHX();
                        break;
                    case 3:
                        //查询活素质
                        detailList = selectService.findHSZ();
                        break;
                    case 4:
                        //查活社团
                        detailList = selectService.findHST();
                        break;
                }
                break;
            case 4:
                switch (index1) {
                    case 0:
                        //查询学生素质
                        detailList = selectService.findXC();
                        break;
                }
                break;
            case 5:
                switch (index1) {
                    case 0:
                        //查询其他
                        break;
                }
                break;
        }
        new AjaxTool(detailList, response);
      *//*  try {
            response.setHeader("Content-Type", "text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            Gson g = new Gson();
            String value = g.toJson(detailList);
            out.print(value);// 返给ajax请求
            // 刷新
            out.flush();
            // 关闭
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }*//*
    }*/

    //级联查询分数
//    @RequestMapping("/doselectmark")
//    public void doselectkind(HttpServletRequest request, HttpServletResponse response, JIngFei_mark jfm) {
//        List<JIngFei_mark> jfLIst = new ArrayList<>();
//        Object obj0 = request.getParameter("multi");
//        Object obj1 = request.getParameter("multil");
//        Object objd = request.getParameter("detail");
//        String indexstr0 = obj0.toString() + "" + obj1.toString();
//        int index1 = Integer.parseInt(objd.toString());
//        System.out.println(indexstr0 + "===" + index1);
//        Integer id = index1 + 1;
//        switch (indexstr0) {
//            case "00":
//                jfLIst = selectService.findjkmark();
//                break;
//            case "01":
//                jfLIst = selectService.findmark(id);
//                break;
//            //1
//            case "10":
//                //科发
//                jfLIst = selectService.findkfmark(id);
//                break;
//            case "11":
//                //科科
//                jfLIst = selectService.findkkmark(id);
//                break;
//            case "12":
//                break;
//
//            case "20":
//                //证职
//                jfLIst = selectService.findzzMark();
//                break;
//            case "21":
//                //证全
//                jfLIst = selectService.findzqMark(id);
//                break;
//            //3
//            //活动
//            case "30":
//                //科学
//                jfLIst = selectService.findhkMark(id);
//                break;
//            case "31":
//                //社会
//                jfLIst = selectService.findhsMark(id);
//                break;
//            case "32":
//                jfLIst = selectService.findhxMark();
//                break;
//            case "33":
//                jfLIst = selectService.findhszMark();
//                break;
//            case "34":
//                //社团
//                jfLIst = selectService.findhstMark(id);
//                break;
//            //4
//            case "40":
//                List<DetailMark> xcList = selectService.findXC();
//                jfm.setLevel(xcList.get(0).getDetail());
//                jfm.setId(xcList.get(0).getId());
//                jfm.setMark(xcList.get(0).getMark());
//                jfLIst.add(jfm);
//                break;
//            //其他
//            case "50":
//                break;
//        }
//        System.out.println(jfLIst);
//        new AjaxTool(jfLIst, response);
//    }

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



