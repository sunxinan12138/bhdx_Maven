package com.bhdx.controller;

import com.bhdx.models.ZsDetail;
import com.bhdx.service.AddZsService;
import com.bhdx.tools.AjaxTool;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Controller
public class AddZsController {
    ModelAndView mav = null;
    @Autowired
    private AddZsService addZsService;

    @RequestMapping("/doaddZs")
    @ResponseBody
    public void doaddZs(HttpServletRequest request, HttpServletResponse response, ZsDetail zsDetail, @RequestParam("file") MultipartFile file) {
        boolean btn = false;
        System.out.println("添加");
        try {
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            String originalName = file.getOriginalFilename();
            originalName = originalName.substring(originalName.length() - 4);
            String imgName = "img" + originalName;

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
            zsDetail.setImageName(imgName);
            zsDetail.setImg(file.getBytes());
            System.out.println(zsDetail);
            //btn = addZsService.sout(zsDetail);
            System.out.println(btn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new AjaxTool(btn, response);
        }
    }


}

