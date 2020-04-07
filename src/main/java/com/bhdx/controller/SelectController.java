package com.bhdx.controller;

import com.bhdx.models.*;
import com.bhdx.service.SelectService;
import com.bhdx.tools.AjaxTool;
import org.mybatis.spring.SqlSessionTemplate;
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
    @Autowired
    private SqlSessionTemplate template;


    //查询Kind
    @RequestMapping("/doselectKind")
    public void doselectKind(HttpServletRequest request, Integer lableId, HttpServletResponse response) {
        lableId += 1;
        String id = lableId.toString();
        System.out.println(lableId);
        List<KindDic> kindDicList = selectService.selectKind(id);
        System.out.println(kindDicList);
        new AjaxTool(kindDicList, response);
    }

    //查询zs细节
    @RequestMapping("/doselectlevel")
    public void doselectlevel(HttpServletRequest request, String kindId, HttpServletResponse response) {
        List<LevelDic> levelDicList = selectService.selectlevel(kindId);
        //System.out.println(levelDicList);
        new AjaxTool(levelDicList, response);
    }

    // 获取session
    @RequestMapping("/dostuidSession")
    public void stuidSession(HttpServletRequest request, HttpSession httpSession, HttpServletResponse response) {
        String stui = null;
        stui = selectService.getHeader(request);
        //System.out.println(stui);
        new AjaxTool(stui, response);
    }


    //查重
//    @RequestMapping("/selectrepeat")
//    public void selectrepeat(HttpServletRequest request, HttpServletResponse response) {
//        boolean btn = true;
//        String zsname = request.getParameter("zsname");
//        //  String stuid = request.getParameter("stuid");
//        btn = selectService.cchcx(zsname);
//        new AjaxTool(btn, response);
//    }
//
//    @RequestMapping("/selectzcrepeat")
//    public void selectzcrepeat(HttpServletRequest request, HttpServletResponse response) {
//        boolean btn = true;
//        String zsname = request.getParameter("zsname");
//        btn = selectService.cchzc(zsname);
//        new AjaxTool(btn, response);
//    }
//
//    @RequestMapping("/selectallrepeat")
//    public void selectallrepeat(HttpServletRequest request, HttpServletResponse response) {
//        String message = "";
//        String zsname = request.getParameter("zsname");
//
//
//        message = selectService.cchall(zsname);
//        new AjaxTool(message, response);
//    }
    // 查询证书回显
    @RequestMapping("/dostuSeeZs")
    public void stuSeeZs(HttpServletRequest request, HttpServletResponse response, String msg, String stuid) {
        List<CXDetail> cxDetails = new ArrayList<>();
        List<ZCDetail> zcDetails = new ArrayList<>();
        if (msg.equals("创新")) {
            cxDetails = selectService.findCxBistuid(stuid);
            new AjaxTool(cxDetails, response);
        } else if (msg.equals("综测")) {
            zcDetails = selectService.findZcBistuid(stuid);
            System.out.println(zcDetails);
            new AjaxTool(zcDetails, response);
        }
    }

    @RequestMapping("/dostuDel")
    public void dostuDel(HttpServletRequest request, HttpServletResponse response, String id, String current) {
        System.out.println(id + "" + current);
        // tab1 创新 2 综测
        if (current.equals("tab1")) {
            //System.out.println(current);
            template.delete("com.bhdx.DAO.SelectMapper.delById", id);
        } else {
            //System.out.println(current);
            template.delete("com.bhdx.DAO.SelectMapper.delByIdZC", id);
        }

    }

    @RequestMapping("/dofinddelzs")
    public void dofinddelzs(HttpServletRequest request, HttpServletResponse response, String stuid) {
        List<DelMessage> list = template.selectList("com.bhdx.DAO.SelectMapper.finddelzs", stuid);
        new AjaxTool(list, response);
    }

    @RequestMapping("/dodeldel")
    public void dodeldel(HttpServletRequest request, HttpServletResponse response, String id) {
        template.delete("com.bhdx.DAO.SelectMapper.deldel", id);
    }
}



