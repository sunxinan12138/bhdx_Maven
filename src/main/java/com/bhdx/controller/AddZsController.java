package com.bhdx.controller;

import com.bhdx.models.CXDetail;
import com.bhdx.models.ZCDetail;
import com.bhdx.service.AddZsService;
import com.bhdx.tools.AjaxTool;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AddZsController {
    ModelAndView mav = null;
    @Autowired
    private AddZsService addZsService;

    //综测
    @RequestMapping("/doaddZC")
    @ResponseBody
    public void doaddZs(HttpServletRequest request, HttpServletResponse response, ZCDetail zcDetail, @RequestParam("file") MultipartFile file) {
        boolean btn = false;
        System.out.println("添加");
        try {

            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            String originalName = file.getOriginalFilename();
            originalName = originalName.substring(originalName.length() - 4);
            String imgName = "imgZC" + originalName;
            /**
             * detail: "国家级"
             * mark: "12"
             * remark: "请二位发我QQ"
             * stuid: "220123"
             * time: "2019-2020"
             * zsname: "1去去去"
             * zk：折扣
             */
            String detail = request.getParameter("detail");
            String remark = request.getParameter("remark");
            String mark = request.getParameter("mark");
            String stuid = request.getParameter("stuid");
            String zsname = request.getParameter("zsname");
            String zk = request.getParameter("zk");
            String time = request.getParameter("time");
            double markdou = Double.parseDouble(mark);
            //System.out.println(markdou);
            zcDetail.setStuid(stuid);
            zcDetail.setLevel(detail);
            zcDetail.setRemark(remark);
            zcDetail.setTime(time);
            zcDetail.setZsName(zsname);
            zcDetail.setMark(markdou);
            zcDetail.setZk(zk);
            zcDetail.setImgName(imgName);
            zcDetail.setImg(file.getBytes());
            System.out.println(zcDetail);
            btn = addZsService.zcadd(zcDetail);
            System.out.println(btn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new AjaxTool(btn, response);
        }
    }

    //  创新
    @RequestMapping("/doaddCX")
    @ResponseBody
    public void doaddCx(HttpServletRequest request, HttpServletResponse response, CXDetail cxDetail, @RequestParam("file") MultipartFile file) {
        boolean btn = false;

        try {
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            String iname = file.getOriginalFilename();
            iname = iname.substring(iname.length() - 4);
            String imgName = "imgCX" + iname;
            cxDetail.setImgName(imgName);
            cxDetail.setImg(file.getBytes());
            System.out.println(cxDetail);
            btn = addZsService.cxadd(cxDetail);
            System.out.println(btn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new AjaxTool(btn, response);
        }
    }

    @RequestMapping("/doaddZAC")
    @ResponseBody
    public void doaddZAC(HttpServletRequest request, HttpServletResponse response, ZCDetail zcDetail, CXDetail cxDetail, @RequestParam("file") MultipartFile file) {
        boolean btn = false;
        boolean repet = true;
        try {
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            String zsname = request.getParameter("zsname");
            String markzc = request.getParameter("markzc");
            double markzcd = Double.parseDouble(markzc);
            String markcx = request.getParameter("markcx");
            double markcxd = Double.parseDouble(markcx);
            String iname = file.getOriginalFilename();
            iname = iname.substring(iname.length() - 4);
            String imgCXName = "imgCX" + iname;
            String imgZCName = "imgZC" + iname;
            zcDetail.setZsName(zsname);
            zcDetail.setMark(markzcd);
            zcDetail.setImgName(imgZCName);
            zcDetail.setImg(file.getBytes());
            cxDetail.setMark(markcxd);
            cxDetail.setImgName(imgCXName);
            cxDetail.setImg(file.getBytes());
            System.out.println(cxDetail);
            System.out.println(zcDetail);

            // 查重

            if(repet){
                return;
            }
            //综测添加
            btn = addZsService.zcadd(zcDetail);
            //创新添加
            btn = addZsService.cxadd(cxDetail);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new AjaxTool(btn, response);
        }
    }

}

